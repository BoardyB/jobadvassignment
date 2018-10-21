package hu.iit.me.controller;

import hu.iit.me.model.Job;
import hu.iit.me.service.JobService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/job")
public class JobController {

    private JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Collection<Job> add() {
        return jobService.listAllJobs();
    }
}
