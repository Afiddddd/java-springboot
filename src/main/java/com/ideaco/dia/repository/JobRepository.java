package com.ideaco.dia.repository;


import com.ideaco.dia.model.JobModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface JobRepository  extends JpaRepository<JobModel, Integer>{
    Optional<JobModel> findByJobName(String jobName);

    Optional<JobModel> findByJobNameAndJobSalary(String jobName, int salary);

    @Query(value = "select j from JobModel j " + "where j.jobSalary >= :salary")
    List<JobModel> filterJob(@Param("salary")int jobSalary);
}
