package com.arun.ag_backend.Repo;

import com.arun.ag_backend.Entities.Admin_assigned_Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Admin_a_Repo extends JpaRepository<Admin_assigned_Users , Integer> {

    @Query("select  u from  Admin_assigned_Users u where u.email = :email")
    Optional<Admin_assigned_Users> findByEmail(@Param("email") String email);
}
