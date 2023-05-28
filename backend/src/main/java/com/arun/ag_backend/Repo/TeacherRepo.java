package com.arun.ag_backend.Repo;

import com.arun.ag_backend.Entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeacherRepo extends JpaRepository<Teacher, Integer > {

    @Query("select u from Teacher u where u.email = :email")
    Optional<Teacher> findByEmail(@Param("email") String email);

}
