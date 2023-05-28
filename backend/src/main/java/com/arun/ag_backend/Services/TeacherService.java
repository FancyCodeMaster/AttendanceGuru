package com.arun.ag_backend.Services;

import com.arun.ag_backend.Dto.Helper;
import com.arun.ag_backend.Dto.StudentDto;
import com.arun.ag_backend.Dto.TeacherDTO;
import com.arun.ag_backend.Entities.Student;
import com.arun.ag_backend.Entities.Teacher;
import com.arun.ag_backend.Repo.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeacherService {

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    private TeacherRepo teacherRepo;

    public String save_teacher(TeacherDTO teacherDTO){

        Optional<Teacher> existingteacher = teacherRepo.findByEmail(teacherDTO.getEmail());
        if(existingteacher.isEmpty()){
            Teacher teacher = Helper.dto_to_entity(teacherDTO);
            teacher.setRole("ROLE_TEACHER");
            teacher.setPassword(encoder.encode(teacher.getPassword()));
            teacherRepo.save(teacher);
            return "Successfully registered";
        }else {
            return "Email already exist";
        }

    }
}
