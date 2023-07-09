package com.arun.ag_backend.Controller.Admin;

import com.arun.ag_backend.Services.ClassRoutineService;
import com.arun.ag_backend.Services.SubjectService;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/admin")
public class AdminController {


    @Autowired
    private ClassRoutineService classRoutineService;



    @PostMapping("/add/classRoutine")
    public ResponseEntity<Object> addClassRoutine(@RequestBody JsonNode classRoutineJson){


        classRoutineService.insertRoutine(classRoutineJson);
        return ResponseEntity.ok("Ok");
    }
}
