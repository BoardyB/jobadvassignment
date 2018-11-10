package hu.iit.me.controller;

import hu.iit.me.model.Job;
import hu.iit.me.service.JobService;
import hu.iit.me.util.SearchRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

    @PostMapping(value = "/by")
    public ResponseEntity getApplicantsBy(@RequestBody SearchRequest request) {
        try {
            Collection<Job> jobs = this.jobService.findBy(request);
            return ResponseEntity.ok(jobs);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Search request filters are not valid." + request.toString());
        }
    }

    @PostMapping()
    public ResponseEntity save(@RequestBody Job job) {
        this.jobService.save(job);
        return ResponseEntity.ok("Job saved successfully");
    }

}
