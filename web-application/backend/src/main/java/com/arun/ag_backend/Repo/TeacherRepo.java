package com.arun.ag_backend.Repo;

import com.arun.ag_backend.Entities.Class;
import com.arun.ag_backend.Entities.Student;
import com.arun.ag_backend.Entities.Subject;
import com.arun.ag_backend.Entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeacherRepo extends JpaRepository<Teacher, Integer > {
    @Query("SELECT t FROM Teacher t WHERE t.user.email = :email")
    Optional<Teacher> findByUserEmail(@Param("email") String email);


    @Query("SELECT   c FROM Class c " +
            "JOIN TeacherSubjects ts ON c.class_id = ts.aClass.class_id " +
            "JOIN Users u ON ts.users.email = u.email " +
            "JOIN Subject s ON ts.subject.subject_id = s.subject_id " +
            "WHERE u.email = :email")
    List<Class> findTeacherSubjectsByEmail(@Param("email") String email);

    @Query("SELECT subject FROM Subject subject " +
            "JOIN TeacherSubjects ts on subject.subject_id = ts.subject.subject_id " +
            "WHERE ts.aClass.class_id = :classId AND ts.users.email = :email")
    Subject findTeacherSubject(@Param("classId") int classId , @Param("email") String email);
}
