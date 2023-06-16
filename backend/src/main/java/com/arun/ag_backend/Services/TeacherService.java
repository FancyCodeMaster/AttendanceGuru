package com.arun.ag_backend.Services;

import com.arun.ag_backend.Dto.TeacherDTO;
import com.arun.ag_backend.Entities.Teacher;
import com.arun.ag_backend.Entities.Users;
import com.arun.ag_backend.Repo.TeacherRepo;
import com.arun.ag_backend.Repo.UserRepo;
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

    @Autowired
    private UserRepo userRepo;

    public String save_teacher(TeacherDTO teacherDTO) {

        Optional<Teacher> existingteacher = teacherRepo.findByUserEmail(teacherDTO.getEmail());
        if(existingteacher.isEmpty()){
            Users user = new Users();
            user.setEmail(teacherDTO.getEmail());
            user.setName(teacherDTO.getName());

            user.setRole("ROLE_TEACHER");
            user.setPassword(encoder.encode(teacherDTO.getPassword()));
            userRepo.save(user);
            Teacher teacher = new Teacher();
            teacher.setUser(user);

            teacherRepo.save(teacher);

            return "Successfully registered";
    }else {
        return "Email already exists";
    }
}
}
