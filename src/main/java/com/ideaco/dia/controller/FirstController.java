package com.ideaco.dia.controller;

import com.ideaco.dia.model.JobModel;
import com.ideaco.dia.dto.JobDTO;
import com.ideaco.dia.service.FirstService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class FirstController {

    @Autowired
    private FirstService firstService;

    @GetMapping("/helloWorld")
    public String helloWorld(){
        return "Hello World";
    }

    @GetMapping("/sendMessage")
    public String sendMessage(@RequestParam("message") String message){
        return firstService.sendMessage(message);
    }

    @GetMapping("/job/{jobid}")
    public JobDTO getJob(@PathVariable("jobid") int jobId){
        return firstService.getJobById(jobId);
    }

    @GetMapping("job/jobs")
    public List<JobModel> getAllJobs(){
        return firstService.getAllJobs();
    }

    @GetMapping("job/name/{jobname}")
    public JobModel getJobByName(@PathVariable("jobname") String jobName){
        JobModel jobByName = firstService.getJobByName(jobName);
        if(jobByName != null){
            return jobByName;
        } else {
            return new JobModel();
        }
    }

    @GetMapping("/job/name/salary")
    public JobModel getJobByNameAndSalary(@RequestParam("jobName")String jobName,
                                          @RequestParam("jobSalary")int salary){
        JobModel jobByName = firstService.getJobBySalaryAndName(jobName, salary);
        if(jobByName != null){
            return jobByName;
        }else {
            return new JobModel();
        }
    }

    @GetMapping("/job/filter")
    public List<JobModel> filterJob(@RequestParam("jobSalary")int jobSalary){
        return firstService.filterJob(jobSalary);
    }


    @PostMapping("/job")
    public JobModel createJob(@RequestParam("jobName") String jobName,
                              @RequestParam("jobDesc") String jobDesc,
                              @RequestParam("jobSalary") int jobSalary){
        return firstService.createJob(jobName, jobDesc, jobSalary);
    }

    @PostMapping("/job/body")
    public JobModel createJobWithBody(@RequestBody JobModel jobModel){
        return firstService.createJobWithBody(jobModel);

    }

    @PostMapping("/job/jobs")
    public List<JobModel> createMultipleJob(@RequestBody List<JobModel> jobModels){
        return firstService.createMultipleJob(jobModels);
    }

    @PutMapping("/job/{jobId}")
    public JobModel updateJob(@PathVariable("jobId")int jobId,
                              @RequestBody JobModel jobModel){
        JobModel updateJob = firstService.updateJob(jobId, jobModel);
        if(updateJob != null){
            return updateJob;
        }else {
            return new JobModel();
        }
    }

    @PatchMapping("/job/update")
    public JobModel updateJobName(@RequestParam("jobId") int jobId,
                                  @RequestParam("jobName") String jobName){
        JobModel updateJob = firstService.updateJobName(jobId, jobName);
        if (updateJob != null){
            return updateJob;
        }else {
            return new JobModel();
        }
    }

    @DeleteMapping("/job/{jobId}")
    public boolean deleteJob(@PathVariable("jobId")int jobId){
        return firstService.deleteJob(jobId);
    }

}
