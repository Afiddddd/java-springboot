package com.ideaco.dia;

import org.springframework.stereotype.Service;

@Service
public class FirstService {

    private JobRepository jobRepository;

    public FirstService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }


    public  String sendMessage(String message){
        return "Sending message" + message;
    }

    public JobModel getJobById(int jobId){
        return jobRepository.findById(jobId).get();
    }

    public JobModel createJob(String jobName,
                              String jobDesc,
                              int jobSalary){
        JobModel newJob = new JobModel();
        newJob.setJobName(jobName);
        newJob.setJobDesc(jobDesc);
        newJob.setJobSalary(jobSalary);
        return jobRepository.save(newJob);
    };


}
