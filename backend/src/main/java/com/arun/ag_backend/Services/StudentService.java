package com.arun.ag_backend.Services;

import com.arun.ag_backend.Dto.Helper;
import com.arun.ag_backend.Dto.StudentDto;
import com.arun.ag_backend.Entities.Student;
import com.arun.ag_backend.Repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private BCryptPasswordEncoder encoder;
    @Autowired
    private StudentRepo studentRepo;


    public String save_student(StudentDto studentdto){
        Optional<Student> existingStudent = studentRepo.findByEmail(studentdto.getEmail());

        if(existingStudent.isEmpty()){
            Student student = Helper.dto_to_entity(studentdto);
            student.setRole("ROLE_STUDENT");
            student.setPassword(encoder.encode(student.getPassword()));
            studentRepo.save(student);
            return "Successfully registered";

        }else {
            return "Email already exists";
        }
    }
}
