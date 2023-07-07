package com.arun.ag_backend.Services;

import com.arun.ag_backend.Dto.StudentDto;
import com.arun.ag_backend.Entities.OTP;
import com.arun.ag_backend.Entities.Student;

import com.arun.ag_backend.Entities.Users;
import com.arun.ag_backend.Repo.OtpRepo;
import com.arun.ag_backend.Repo.StudentRepo;
import com.arun.ag_backend.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private BCryptPasswordEncoder encoder;
    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private UserService userService;

    @Autowired
    private OtpRepo otpRepo;

    public void save_student(Users user , int roll) {


        Student student = new Student();
        student.setRoll(roll);
        student.setUser(user);

        studentRepo.save(student);

    }

    public void get_classes(String email){

       List<Object[]> objectList = studentRepo.findClassAndSubjectsByEmail(email);
        System.out.println(objectList);
    }
}
