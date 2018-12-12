package hu.iit.me.controller;

import hu.iit.me.dto.JobDTO;
import hu.iit.me.exception.DTOConversionException;
import hu.iit.me.exception.InvalidSearchFiltersException;
import hu.iit.me.model.Job;
import hu.iit.me.service.JobService;
import hu.iit.me.util.SearchRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/job")
public class JobController {

    private JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity getAllJobs() {
        Collection<Job> jobs = jobService.listAllJobs();
        return ResponseEntity.ok(jobs.stream().map(JobDTO::convertModelToDTO).collect(toList()));
    }

    @PostMapping(value = "/by")
    public ResponseEntity getJobsBy(@RequestBody SearchRequest request) {
        Collection<Job> jobs = this.jobService.findBy(request);
        return ResponseEntity.ok(jobs.stream().map(JobDTO::convertModelToDTO).collect(toList()));
    }

    @ExceptionHandler(InvalidSearchFiltersException.class)
    public ResponseEntity invalidSearchFiltersExceptionHandler(InvalidSearchFiltersException e) {
        return ResponseEntity.badRequest().body("Search request filters are not valid.\n" + e.getLocalizedMessage());
    }

    @PostMapping()
    public ResponseEntity save(@RequestBody JobDTO job) {
        Job jobModel = job.toJob();
        this.jobService.save(jobModel);
        return ResponseEntity.ok("Job saved successfully");
    }

    @ExceptionHandler(DTOConversionException.class)
    public ResponseEntity dtoConversionExceptionHandler(DTOConversionException e) {
        return ResponseEntity.badRequest().body("Job fields are not valid.");
    }

}
