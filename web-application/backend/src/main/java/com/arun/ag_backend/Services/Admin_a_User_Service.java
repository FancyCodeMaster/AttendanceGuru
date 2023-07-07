package com.arun.ag_backend.Services;

import com.arun.ag_backend.Entities.Admin_assigned_Users;
import com.arun.ag_backend.Repo.Admin_a_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Admin_a_User_Service {

    @Autowired
    private Admin_a_Repo repo;

    public Optional<Admin_assigned_Users> findByEmail(String email){

        return repo.findByEmail(email);
    }
}
