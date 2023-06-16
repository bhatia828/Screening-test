package com.SampleProject.ProjectRepo;

import com.SampleProject.Entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepo extends JpaRepository<Question, Integer> {
    @Query(value = "select q from Question q where q.id>:id ORDER BY q.id ASC LIMIT 1")
    public Question findFirstByIdGreaterThanOrderByIdAsc(@Param("id") int id);

}
