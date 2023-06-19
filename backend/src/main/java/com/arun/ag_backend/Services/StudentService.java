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

    public Users save_student(StudentDto studentdto){

        Users user = new Users();
        user.setEmail(studentdto.getEmail());
        user.setName(studentdto.getName());
        user.setEnabled(false);
        user.setRole("ROLE_STUDENT");
        user.setPassword(encoder.encode(studentdto.getPassword()));

        Student student  = new Student();
        student.setRoll(studentdto.getCollege_roll());
        student.setUser(user);


        Optional<Users> existingUser = userService.finByEmail(studentdto.getEmail());

        if(existingUser.isEmpty()){

            userService.save_user(user);
            studentRepo.save(student);

            return user;

        }else {
            Users ex_user = existingUser.get();
            Optional<Student> ex_student = studentRepo.findByUserEmail(ex_user.getEmail());
            Student s = ex_student.get();
            studentRepo.delete(s);

            if(!ex_user.isEnabled()){

                userService.delete_user(ex_user);
                userService.save_user(user);
                studentRepo.save(student);
                return user;
            }else
            {

                return null;
            }
        }
    }
}
