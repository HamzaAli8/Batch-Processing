package com.example.batch2.demo.controller;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/batch")
public class BatchController {

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job job;

    @Autowired
    JobExplorer jobExplorer;

    @GetMapping(value = "/job")
    public String testJob(@RequestParam(name = "id", required = false) String jobId, Model model) {
        JobParametersBuilder jobParametersBuilder = new JobParametersBuilder();
        if (StringUtils.hasLength(jobId)) {
            jobParametersBuilder.addString("jobId", jobId);
            model.addAttribute("job", job);
        }
        JobExecution jobExecution;
        try {
            jobExecution = jobLauncher.run(job, jobParametersBuilder.toJobParameters());
        } catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException | JobParametersInvalidException e) {
            e.printStackTrace();
            // return exception message
            return e.getMessage();
        }
        // return job execution status
        return "start";
    }


    @GetMapping("/")
    public String homePage(Model model){
        jobExplorer.findJobInstancesByJobName()
        model.addAttribute("job", job);


        return "start";
    }
}
