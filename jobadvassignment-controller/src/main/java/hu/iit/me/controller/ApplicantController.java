package hu.iit.me.controller;

import hu.iit.me.model.Applicant;
import hu.iit.me.service.ApplicantService;
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

    @GetMapping(value = "/by")
    public ResponseEntity getApplicantsBy(@RequestParam String fieldName, @RequestParam String fieldValue) {
        try {
            Collection<Applicant> applicants = this.applicantService.findBy(fieldName, fieldValue);
            return ResponseEntity.ok(applicants);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body("Property [" + fieldName + "] does not exist on entity [" + Applicant.class.getSimpleName() + "].");
        }
    }

    @PostMapping()
    public ResponseEntity save(@RequestBody Applicant applicant) {
        this.applicantService.save(applicant);
        return ResponseEntity.ok("Applicant saved successfully");
    }
}
