package hu.iit.me.controller;

import hu.iit.me.model.Job;
import hu.iit.me.service.JobService;
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

    @GetMapping(value = "/by")
    public ResponseEntity getApplicantsBy(@RequestParam String fieldName, @RequestParam String fieldValue) {
        try {
            Collection<Job> jobs = this.jobService.findBy(fieldName, fieldValue);
            return ResponseEntity.ok(jobs);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body("Property [" + fieldName + "] does not exist on entity [" + Job.class.getSimpleName() + "].");
        }
    }

    @PostMapping()
    public ResponseEntity save(@RequestBody Job job) {
        this.jobService.save(job);
        return ResponseEntity.ok("Job saved successfully");
    }

}
