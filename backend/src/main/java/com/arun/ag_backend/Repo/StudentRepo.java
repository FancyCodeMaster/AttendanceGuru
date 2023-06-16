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

    @Query("SELECT s FROM Student s WHERE s.user.email = :email")
    Optional<Student> findByUserEmail(@Param("email") String email);

}
