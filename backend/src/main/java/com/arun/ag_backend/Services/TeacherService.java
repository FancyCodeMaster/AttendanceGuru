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
    private UserService userService;

    public Users save_teacher(TeacherDTO teacherDTO) {

        Users user = new Users();
        user.setEmail(teacherDTO.getEmail());
        user.setName(teacherDTO.getName());

        user.setRole("ROLE_TEACHER");
        user.setPassword(encoder.encode(teacherDTO.getPassword()));

        Teacher teacher = new Teacher();
        teacher.setUser(user);

        Optional<Users> existingUser = userService.finByEmail(teacherDTO.getEmail());

        if(existingUser.isEmpty()){


            userService.save_user(user);


            teacherRepo.save(teacher);

            return user;
    }else {
            Users ex_user = existingUser.get();
            Optional<Teacher> ex_teacher = teacherRepo.findByUserEmail(ex_user.getEmail());
            Teacher t = ex_teacher.get();
            teacherRepo.delete(t);
            if(!ex_user.isEnabled()){
                userService.delete_user(ex_user);
                userService.save_user(user);
                teacherRepo.save(teacher);

                return user;
            }else
            {

                return null;
            }
    }
}
}
