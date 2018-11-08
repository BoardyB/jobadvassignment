package hu.iit.me.controller;

import hu.iit.me.model.Applicant;
import hu.iit.me.service.ApplicantService;
import hu.iit.me.util.SearchRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/applicant")
public class ApplicantController {

    private ApplicantService applicantService;

    public ApplicantController(ApplicantService applicantService) {
        this.applicantService = applicantService;
    }

    @GetMapping(value = "/all")
    public ResponseEntity getAllApplicants() {
        return ResponseEntity.ok(this.applicantService.listAllApplicants());
    }

    @PostMapping(value = "/by")
    public ResponseEntity getApplicantsBy(@RequestBody SearchRequest request) {
        try {
            Collection<Applicant> applicants = this.applicantService.findBy(request);
            return ResponseEntity.ok(applicants);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body("Search request " + request.toString() + " does not have a valid field name.");
        }
    }

    @PostMapping()
    public ResponseEntity save(@RequestBody Applicant applicant) {
        this.applicantService.save(applicant);
        return ResponseEntity.ok("Applicant saved successfully");
    }
}
