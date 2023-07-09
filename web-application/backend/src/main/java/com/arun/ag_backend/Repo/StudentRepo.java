package com.arun.ag_backend.Repo;

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
public interface StudentRepo extends JpaRepository<Student , Integer> {

    @Query("SELECT s FROM Student s WHERE s.user.email = :email")
    Optional<Student> findByUserEmail(@Param("email") String email);

    @Query("SELECT   c ,s FROM Class c " +
            "JOIN Student stu ON c.class_id = stu.aClass.class_id " +
            "JOIN Users u ON stu.user.id = u.id " +
            "JOIN ClassSubjects cs ON c.class_id = cs.aClass.class_id " +
            "JOIN Subject s ON cs.subject.subject_id = s.subject_id " +
            "WHERE u.email = :email")
    List<Object[]> findClassAndSubjectsByEmail(@Param("email") String email);

}
