package com.arun.ag_backend.Controller;

import com.arun.ag_backend.Dto.StudentDto;
import com.arun.ag_backend.Dto.TeacherDTO;
import com.arun.ag_backend.Entities.LoginDetails;
import com.arun.ag_backend.Services.StudentService;
import com.arun.ag_backend.Services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Login_SignUp {


    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private StudentService studentService;

    @Autowired
    private TeacherService teacherService;




    @PostMapping("/signIn")
    public ResponseEntity<String> signIn(@RequestBody LoginDetails loginDetails){

        try {
             Authentication authentication = new UsernamePasswordAuthenticationToken(loginDetails.getUsername(),loginDetails.getPassword());

            Authentication authenticated = authenticationManager.authenticate(authentication);

             if (authenticated.isAuthenticated()) {

                 String authority = authenticated.getAuthorities().toString();
                 System.out.println(authority);
                 if(authority.equals("[ROLE_TEACHER]")){
                     return ResponseEntity.ok("Teacher");
                 }
                 else{
                     return ResponseEntity.ok("Student");
                 }

            } else {
               return ResponseEntity.ok("");
            }
        } catch (AuthenticationException e) {
            return ResponseEntity.ok("Wrong credentails");
        }
    }




    @RequestMapping("/register/student")
    public ResponseEntity<String> register_student(@RequestBody StudentDto studentDto){

        String message = studentService.save_student(studentDto);

        return ResponseEntity.ok(message);
    }

    @RequestMapping("/register/teacher")
    public ResponseEntity<String> register_Teacher(@RequestBody TeacherDTO teacherDTO){

        String message = teacherService.save_teacher(teacherDTO);

        return ResponseEntity.ok(message);
    }
}
