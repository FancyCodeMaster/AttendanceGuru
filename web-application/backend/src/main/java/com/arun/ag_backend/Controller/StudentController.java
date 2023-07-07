package com.arun.ag_backend.Controller;
import com.arun.ag_backend.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/user/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/classes")
    public ResponseEntity<Object> getClasses(Principal principal){
        System.out.println(principal.getName());
        studentService.get_classes(principal.getName());
        return ResponseEntity.ok("classes");
    }

}
