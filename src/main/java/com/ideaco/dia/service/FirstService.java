package com.ideaco.dia.service;

import com.ideaco.dia.model.JobModel;
import com.ideaco.dia.repository.JobRepository;
import com.ideaco.dia.dto.JobDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FirstService {

    @Autowired
    private JobRepository jobRepository;


    public  String sendMessage(String message){
        return "Sending message" + message;
    }

    public JobDTO getJobById(int jobId){
        return convertJob(jobRepository.findById(jobId).get());
    }
    private JobDTO convertJob(JobModel jobModel){
        JobDTO jobDTO = new JobDTO();
        jobDTO.setJobName(jobModel.getJobName());
        jobDTO.setJobSalary(jobDTO.getJobSalary());
        return jobDTO;
    }


    // Create Data
    public JobModel createJob(String jobName,
                              String jobDesc,
                              int jobSalary){
        JobModel newJob = new JobModel();
        newJob.setJobName(jobName);
        newJob.setJobDesc(jobDesc);
        newJob.setJobSalary(jobSalary);
        return jobRepository.save(newJob);
    };

    // Read All Data
    public List<JobModel> getAllJobs(){
        return jobRepository.findAll();
    }

    // Read Data by Name
    public JobModel getJobByName(String jobName){
        Optional<JobModel> jobOpt = jobRepository.findByJobName((jobName));
        if (jobOpt.isEmpty()){
            return null;
        }
        return jobOpt.get();
    }

    // Read Data by Salary and Name
    public JobModel getJobBySalaryAndName(String jobName, int salary){
        Optional<JobModel> jobOpt = jobRepository.findByJobNameAndJobSalary(jobName, salary);
        if (jobOpt.isEmpty()){
            return null;
        }
        return jobOpt.get();
    }

    // Create Data with Body
    public JobModel createJobWithBody(JobModel jobModel){
        return jobRepository.save(jobModel);
    }

    // Create Multiple Data List
    public List<JobModel> createMultipleJob(List<JobModel> jobModels){
        return jobRepository.saveAll(jobModels);
    }

    public List<JobModel> filterJob(int jobSalary){
        return jobRepository.filterJob(jobSalary);
    }

    // Put Update
    public JobModel updateJob(int jobId, JobModel jobModel){
        Optional<JobModel> currentJobOpt = jobRepository.findById(jobId);
        if (currentJobOpt.isEmpty()){
            return null;
        }
        return jobRepository.save(jobModel);
    }
    // Patch Update
    public JobModel updateJobName(int jobId, String jobName){
        Optional<JobModel> currentJobOpt = jobRepository.findById(jobId);
        if (currentJobOpt.isEmpty()){
            return null;
        }
        JobModel currentJob = currentJobOpt.get();
        currentJob.setJobName(jobName);
        return jobRepository.save(currentJob);
    }

    public boolean deleteJob(int jobId){
        Optional<JobModel> currentJobOpt = jobRepository.findById(jobId);
        if (currentJobOpt.isEmpty()){
            return false;
        }
        jobRepository.deleteById(jobId);
        return true;
    }


    public List<JobDTO> findAllJobs(){
        List<JobModel> jobModels = jobRepository.findAll();
        return (List<JobDTO>) jobModels.stream().map(this::convertJob);
    }

}
