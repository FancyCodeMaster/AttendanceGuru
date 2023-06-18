package com.arun.ag_backend.Controller;

import com.arun.ag_backend.Dto.StudentDto;
import com.arun.ag_backend.Dto.TeacherDTO;
import com.arun.ag_backend.Entities.LoginDetails;
import com.arun.ag_backend.JSON.AuthResponse;
import com.arun.ag_backend.JSON.CustomResponse;
import com.arun.ag_backend.JWT.JWTService;
import com.arun.ag_backend.Services.EmailService;
import com.arun.ag_backend.Services.StudentService;
import com.arun.ag_backend.Services.TeacherService;
import com.arun.ag_backend.UserDetails.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class Login_SignUp {

    @Autowired
    private EmailService emailService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private StudentService studentService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private JWTService jwtService;


    @PostMapping("/signIn")
    public ResponseEntity<Object> signIn(@RequestBody LoginDetails loginDetails){

        CustomResponse response = new CustomResponse();
        AuthResponse authResponse = new AuthResponse();
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


        String message = studentService.save_student(studentDto);
        String confirmationLink = "http://ag.register/confirm?token=abc123";  // Replace with your actual confirmation link

        // Send confirmation email
        emailService.sendConfirmationEmail(studentDto.getEmail(), confirmationLink);
        System.out.println("Mail sent");
        return ResponseEntity.ok(new CustomResponse(message));
    }

    @RequestMapping("/register/teacher")
    public ResponseEntity<CustomResponse> register_Teacher(@RequestBody TeacherDTO teacherDTO){

        String message = teacherService.save_teacher(teacherDTO);

        return ResponseEntity.ok(new CustomResponse(message));
    }
}
