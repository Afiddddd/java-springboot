package com.ideaco.dia;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class FirstController {

    private FirstService firstService;

    public FirstController(FirstService firstService) {
        this.firstService = firstService;
    }

    @GetMapping("/helloWorld")
    public String helloWorld(){
        return "Hello World";
    }

    @GetMapping("/sendMessage")
    public String sendMessage(@RequestParam("message") String message){
        return firstService.sendMessage(message);
    }

    @GetMapping("/job/{jobid}")
    public JobModel getJob(@PathVariable("jobid") int jobId){
        return firstService.getJobById(jobId);
    }

    @PostMapping("/job")
    public JobModel createJob(@RequestParam("jobName") String jobName,
                              @RequestParam("jobDesc") String jobDesc,
                              @RequestParam("jobSalary") int jobSalary){
        return firstService.createJob(jobName, jobDesc, jobSalary);
    }

}
