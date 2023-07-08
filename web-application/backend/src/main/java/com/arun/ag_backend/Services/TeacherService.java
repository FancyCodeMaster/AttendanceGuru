package com.arun.ag_backend.Services;

import com.arun.ag_backend.Dto.TeacherDTO;
import com.arun.ag_backend.Entities.Class;
import com.arun.ag_backend.Entities.Subject;
import com.arun.ag_backend.Entities.Teacher;
import com.arun.ag_backend.Entities.Users;
import com.arun.ag_backend.Repo.TeacherRepo;
import com.arun.ag_backend.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    private TeacherRepo teacherRepo;

    @Autowired
    private UserService userService;

    public void save_teacher(Users user) {

        Teacher teacher = new Teacher();
        teacher.setUser(user);
        teacherRepo.save(teacher);

//        Optional<Users> existingUser = userService.finByEmail(user.getEmail());
//
//        if(existingUser.isEmpty()){
//
//
//            userService.save_user(user);
//
//
//            teacherRepo.save(teacher);
//
//            return user;
//    }else {
//            Users ex_user = existingUser.get();
//            Optional<Teacher> ex_teacher = teacherRepo.findByUserEmail(ex_user.getEmail());
//            Teacher t = ex_teacher.get();
//            teacherRepo.delete(t);
//            if(!ex_user.isEnabled()){
//                userService.delete_user(ex_user);
//                userService.save_user(user);
//                teacherRepo.save(teacher);
//
//                return user;
//            }else
//            {
//
//                return null;
//            }
//    }
    }




    public void get_teacher_subjects(String email){
        List<Object[]> teacher_subjects =   teacherRepo.findTeacherSubjectsByEmail(email);
        for (Object[] result : teacher_subjects) {
            Class classes = (Class) result[0];
            Subject subject = (Subject) result[1];

            // Access the class and subject properties as needed
            String classDetails = classes.toString();
            String subjectName = subject.toString();
            System.out.println( classDetails + " " + subjectName);


        }
    }
}
