package com.arun.ag_backend.Services;

import com.arun.ag_backend.Dto.StudentDto;
import com.arun.ag_backend.Entities.Class;
import com.arun.ag_backend.Entities.OTP;
import com.arun.ag_backend.Entities.Student;

import com.arun.ag_backend.Entities.Subject;
import com.arun.ag_backend.Entities.Users;
import com.arun.ag_backend.Repo.OtpRepo;
import com.arun.ag_backend.Repo.StudentRepo;
import com.arun.ag_backend.Repo.UserRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    public void save_student(Users user , int roll , Class aClass) {


        Student student = new Student();
        student.setRoll(roll);
        student.setUser(user);
        student.setAClass(aClass);

        studentRepo.save(student);

    }

    public void get_classes(String email) throws Exception {
        String classDetails = " ";
        List<Object[]> classAndSubjects = studentRepo.findClassAndSubjectsByEmail(email);
        for (Object[] result : classAndSubjects) {
            Class classes = (Class) result[0];
            Subject subject = (Subject) result[1];

            // Access the class and subject properties as needed
            classDetails = classes.toString();
            String subjectName = subject.getShort_name();
            System.out.println(" " + subjectName);


        }
        System.out.println(classDetails);
    }
}
