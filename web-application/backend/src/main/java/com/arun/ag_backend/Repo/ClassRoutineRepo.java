package com.arun.ag_backend.Repo;

import com.arun.ag_backend.Entities.ClassRoutine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRoutineRepo extends JpaRepository<ClassRoutine , Long> {


}
