package com.arun.ag_backend.Controller;

import com.arun.ag_backend.Dto.StudentDto;
import com.arun.ag_backend.Dto.TeacherDTO;
import com.arun.ag_backend.Entities.LoginDetails;
import com.arun.ag_backend.JSON.CustomResponse;
import com.arun.ag_backend.Services.StudentService;
import com.arun.ag_backend.Services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class Login_SignUp {


    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private StudentService studentService;

    @Autowired
    private TeacherService teacherService;




    @PostMapping("/signIn")
    public ResponseEntity<CustomResponse> signIn(@RequestBody LoginDetails loginDetails){

        CustomResponse response = new CustomResponse();
        try {
             Authentication authentication = new UsernamePasswordAuthenticationToken(loginDetails.getEmail(),loginDetails.getPassword());

            Authentication authenticated = authenticationManager.authenticate(authentication);

             if (authenticated.isAuthenticated()) {

                 String authority = authenticated.getAuthorities().toString();
                // System.out.println(authority);
                 if(authority.equals("[ROLE_TEACHER]")){
                     response.setMessage("Teacher");
                     return ResponseEntity.ok(response);
                 }
                 else{
                     response.setMessage("Student");
                     return ResponseEntity.ok(response);
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

        return ResponseEntity.ok(new CustomResponse(message));
    }

    @RequestMapping("/register/teacher")
    public ResponseEntity<CustomResponse> register_Teacher(@RequestBody TeacherDTO teacherDTO){

        String message = teacherService.save_teacher(teacherDTO);

        return ResponseEntity.ok(new CustomResponse(message));
    }
}
