package com.arun.ag_backend.Repo;

import com.arun.ag_backend.Entities.Student;
import com.arun.ag_backend.Entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepo extends JpaRepository<Student , Integer> {
    @Query("select s from Student s where s.email = :email")
    Optional<Student> findByEmail(@Param("email") String email);
    @Query("select s from Student s where s.college_roll = :college_roll")
    Optional<Student> findByRoll(@Param("college_roll") int college_roll);

}
