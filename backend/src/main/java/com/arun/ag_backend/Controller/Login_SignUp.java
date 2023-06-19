package com.arun.ag_backend.Controller;

import com.arun.ag_backend.Dto.StudentDto;
import com.arun.ag_backend.Dto.TeacherDTO;
import com.arun.ag_backend.Entities.LoginDetails;
import com.arun.ag_backend.Entities.OTP;
import com.arun.ag_backend.Entities.Users;
import com.arun.ag_backend.JSON.AuthResponse;
import com.arun.ag_backend.JSON.CustomResponse;
import com.arun.ag_backend.JWT.JWTService;
import com.arun.ag_backend.Services.*;
import com.arun.ag_backend.UserDetails.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
public class Login_SignUp {

    @Autowired
    private EmailService emailService;

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private StudentService studentService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private JWTService jwtService;

    @Autowired
    private OTP_Service otpService;

    private String message;

    @PostMapping("/signIn")
    public ResponseEntity<Object> signIn(@RequestBody LoginDetails loginDetails){


        CustomResponse response = new CustomResponse();
        AuthResponse authResponse = new AuthResponse();

        Optional<Users> user = userService.finByEmail(loginDetails.getEmail());

        if(!user.get().isEnabled()){
            OTP otp = new OTP(user.get());
            otpService.save_otp(otp);
            emailService.sendConfirmationEmail(loginDetails.getEmail(), String.valueOf(otp.getOtp_token()));

        }
        try {
             Authentication authentication = new UsernamePasswordAuthenticationToken(loginDetails.getEmail(),loginDetails.getPassword());

            Authentication authenticated = authenticationManager.authenticate(authentication);

             if (authenticated.isAuthenticated()) {


                 String authority = authenticated.getAuthorities().toString();

                CustomUserDetails userDetails = (CustomUserDetails) authenticated.getPrincipal();

                String token = jwtService.generateToken(userDetails.getEmail());
                 authResponse.setEmail(userDetails.getEmail());
                 authResponse.setName(userDetails.getUsername());
                 authResponse.setToken(token);

                     // System.out.println(authority);
                 if(authority.equals("[ROLE_TEACHER]")){

                     authResponse.setRole("Teacher");
                     return ResponseEntity.ok(authResponse);
                 }
                 else{
                        authResponse.setRole("Student");
                     return ResponseEntity.ok(authResponse);
                 }

            } else {
                 response.setMessage("Login Failed");
               return ResponseEntity.ok(response);
            }
        } catch (AuthenticationException e) {
            response.setMessage("Wrong credentails");
            return ResponseEntity.ok(response);
        }
    }




    @RequestMapping("/register/student")
    public ResponseEntity<CustomResponse> register_student(@RequestBody StudentDto studentDto){


        Users user = studentService.save_student(studentDto);
         // Replace with your actual confirmation link

        if(user == null){
           message = "Email Already Exists";
        }
        else{
            OTP otp = new OTP(user);
            otpService.save_otp(otp);
            emailService.sendConfirmationEmail(studentDto.getEmail(), String.valueOf(otp.getOtp_token()));
            message = "Please confirm the OTP code";
        }
        // Send confirmation email
//        emailService.sendConfirmationEmail(studentDto.getEmail(), );
//        System.out.println("Mail sent");
        return ResponseEntity.ok(new CustomResponse(message));
    }

    @RequestMapping("/register/teacher")
    public ResponseEntity<CustomResponse> register_Teacher(@RequestBody TeacherDTO teacherDTO){

        Users user = teacherService.save_teacher(teacherDTO);
        if(user == null){
            message = "Email Already Exists";
        }
        else{
            OTP otp = new OTP(user);
            otpService.save_otp(otp);
            emailService.sendConfirmationEmail(teacherDTO.getEmail(), String.valueOf(otp.getOtp_token()));
            message = "Please confirm the OTP code";
        }
        return ResponseEntity.ok(new CustomResponse(message));
    }


    @RequestMapping("/register/confirm_otp")
    public ResponseEntity<CustomResponse> confirm_otp(@RequestBody CustomResponse token){

        Optional<OTP> otp = otpService.find_otp(token.getMessage());

        if(otp.isPresent()){
            Optional<Users> user = userService.finByEmail(otp.get().getUsers().getEmail());
            userService.update_value(true , user.get().getEmail());
            message = "Successfully Registered";
            otpService.delete_otp(user.get());
        }else{
            message = "wrong OTP";
        }

        return ResponseEntity.ok(new CustomResponse(message));
    }
}
