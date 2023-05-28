package com.arun.ag_backend.Dto;

import com.arun.ag_backend.Entities.Student;
import com.arun.ag_backend.Entities.Teacher;
import org.springframework.stereotype.Component;

@Component
public class Helper {

    public static Student dto_to_entity(StudentDto studentdto) {
        Student student = new Student();
        student.setName(studentdto.getName());

        student.setEmail(studentdto.getEmail());
        student.setCollege_roll(studentdto.getCollege_roll());
        student.setPassword(studentdto.getPassword());

        return student;
    }

    public static Teacher dto_to_entity(TeacherDTO teacherDTO) {
       Teacher teacher = new Teacher();
        teacher.setName(teacherDTO.getName());

        teacher.setEmail(teacherDTO.getEmail());

        teacher.setPassword(teacherDTO.getPassword());

        return teacher;
    }



}
