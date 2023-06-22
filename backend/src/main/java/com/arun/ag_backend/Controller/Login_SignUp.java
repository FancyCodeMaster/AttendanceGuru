package com.arun.ag_backend.Controller;

import com.arun.ag_backend.Dto.Helper;
import com.arun.ag_backend.Dto.StudentDto;
import com.arun.ag_backend.Dto.TeacherDTO;
import com.arun.ag_backend.Dto.UserDTO;
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

@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
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
    private Admin_a_User_Service   adminAUserService;

    @Autowired
    private JWTService jwtService;

    @Autowired
    private OTP_Service otpService;

    CustomResponse response = new CustomResponse();
    AuthResponse authResponse = new AuthResponse();

    @PostMapping("/signIn")
    public ResponseEntity<Object> signIn(@RequestBody LoginDetails loginDetails){


//
//        Optional<Users> user = userService.finByEmail(loginDetails.getEmail());

//        if(!user.get().isEnabled()){
//            OTP otp = new OTP(user.get());
//            otpService.save_otp(otp);
//            emailService.sendConfirmationEmail(loginDetails.getEmail(), String.valueOf(otp.getOtp_token()));
//
//        }
        try {
             Authentication authentication = new UsernamePasswordAuthenticationToken(loginDetails.getEmail(),loginDetails.getPassword());

            Authentication authenticated = authenticationManager.authenticate(authentication);

             if (authenticated.isAuthenticated()) {


                CustomUserDetails userDetails = (CustomUserDetails) authenticated.getPrincipal();
                String role = userDetails.getAuthorities().toString();
                String token = jwtService.generateToken(userDetails.getEmail());
//
                 authResponse.setName(userDetails.getUsername());

                 if(role.equals("[Student]")){
                    authResponse.setRole("student");
                 }
                 if(role.equals("[Teacher]")){
                     authResponse.setRole("teacher");

                 }
                 authResponse.setToken(token);

                return ResponseEntity.ok(authResponse);

            } else {
                 response.setMessage("Login Failed");
               return ResponseEntity.ok(response);
            }
        } catch (AuthenticationException e) {
            response.setMessage("Wrong credentails");
            return ResponseEntity.ok(response);
        }
    }




//    @RequestMapping("/register/student")
//    public ResponseEntity<CustomResponse> register_student(@RequestBody StudentDto studentDto){
//
//
//        Users user = studentService.save_student(studentDto);
//         // Replace with your actual confirmation link
//
//        if(user == null){
//           message = "Email Already Exists";
//        }
//        else{
//            OTP otp = new OTP(user);
//            otpService.save_otp(otp);
//            emailService.sendConfirmationEmail(studentDto.getEmail(), String.valueOf(otp.getOtp_token()));
//            message = "Please confirm the OTP code";
//        }
//        // Send confirmation email
////        emailService.sendConfirmationEmail(studentDto.getEmail(), );
////        System.out.println("Mail sent");
//        return ResponseEntity.ok(new CustomResponse(message));
//    }
//
//    @RequestMapping("/register/teacher")
//    public ResponseEntity<CustomResponse> register_Teacher(@RequestBody TeacherDTO teacherDTO){
//
//        Users user = teacherService.save_teacher(teacherDTO);
//        if(user == null){
//            message = "Email Already Exists";
//        }
//        else{
//            OTP otp = new OTP(user);
//            otpService.save_otp(otp);
//            emailService.sendConfirmationEmail(teacherDTO.getEmail(), String.valueOf(otp.getOtp_token()));
//            message = "Please confirm the OTP code";
//        }
//        return ResponseEntity.ok(new CustomResponse(message));
//    }

    @RequestMapping("/signup")
    public ResponseEntity<Object> register(@RequestBody UserDTO userDTO){

        if(adminAUserService.findByEmail(userDTO.getEmail()).isEmpty()){
            response.setMessage("Email does not exist . Please contact to your college");
            return ResponseEntity.ok(response);
        }
        else {
            String role = adminAUserService.findByEmail(userDTO.getEmail()).get().getUser_role();
            if(userService.finByEmail(userDTO.getEmail()).isPresent()){
                response.setMessage("Email already exists");
            }else {



                Users user = Helper.dto_to_entity(userDTO);
                user.setRole(role);

                userService.save_user(user);

                if(role.equals("Student")){
                    int roll = adminAUserService.findByEmail(user.getEmail()).get().getRoll();
                    System.out.println(roll);
                    studentService.save_student(user , roll);
                }
                if(role.equals("Teacher")){
                    teacherService.save_teacher(user);
                }
                response.setMessage("success");
            }
        }


        return ResponseEntity.ok(response);
    }

    @RequestMapping("/register/confirm_otp")
    public ResponseEntity<Object> confirm_otp(@RequestBody CustomResponse token){

        Optional<OTP> otp = otpService.find_otp(token.getMessage());

        if(otp.isPresent()){
            Optional<Users> user = userService.finByEmail(otp.get().getUsers().getEmail());
            userService.update_value(true , user.get().getEmail());

            response.setMessage("Successfully Registered");
            otpService.delete_otp(user.get());
        }else{
            response.setMessage("wrong OTP");
        }

        return ResponseEntity.ok(response);
    }
}
