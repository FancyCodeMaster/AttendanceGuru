package com.arun.ag_backend.Controller;

import com.arun.ag_backend.Services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/user/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;


    @RequestMapping("/classes")
    public void get_teaching_details(Principal principal){
        teacherService.get_teacher_subjects(principal.getName());
    }
}
