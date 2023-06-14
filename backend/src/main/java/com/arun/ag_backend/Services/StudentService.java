package com.arun.ag_backend.Services;

import com.arun.ag_backend.Dto.StudentDto;
import com.arun.ag_backend.Entities.Student;

import com.arun.ag_backend.Entities.Users;
import com.arun.ag_backend.Repo.StudentRepo;
import com.arun.ag_backend.Repo.UserRepo;
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

    @Autowired
    private UserRepo userRepo;

    public String save_student(StudentDto studentdto){
        Optional<Student> existingStudent = studentRepo.findByUserEmail(studentdto.getEmail());

        if(existingStudent.isEmpty()){

            Users user = new Users();
            user.setEmail(studentdto.getEmail());
            user.setName(studentdto.getName());

            user.setRole("ROLE_STUDENT");
            user.setPassword(encoder.encode(studentdto.getPassword()));
            userRepo.save(user);

            Student student  = new Student();
            student.setRoll(studentdto.getCollege_roll());
            student.setUser(user);

            studentRepo.save(student);

            return "Successfully registered";

        }else {
            return "Email already exists";
        }
    }
}
