package com.SampleProject.ProjectRepo;

import com.SampleProject.Entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepo extends JpaRepository<Question, Integer> {

}
