package hu.iit.me.controller;

import hu.iit.me.dto.ApplicantDTO;
import hu.iit.me.exception.DTOConversionException;
import hu.iit.me.exception.InvalidSearchFiltersException;
import hu.iit.me.model.Applicant;
import hu.iit.me.service.ApplicantService;
import hu.iit.me.util.SearchRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/applicant")
public class ApplicantController {

    private ApplicantService applicantService;

    public ApplicantController(ApplicantService applicantService) {
        this.applicantService = applicantService;
    }

    @GetMapping(value = "/all")
    public ResponseEntity getAllApplicants() {
        Collection<Applicant> applicants = this.applicantService.listAllApplicants();
        return ResponseEntity.ok(applicants.stream().map(ApplicantDTO::convertModelToDTO).collect(toList()));
    }

    @PostMapping(value = "/by")
    public ResponseEntity getApplicantsBy(@RequestBody SearchRequest request) {
        Collection<Applicant> applicants = this.applicantService.findBy(request);
        return ResponseEntity.ok(applicants.stream().map(ApplicantDTO::convertModelToDTO).collect(toList()));
    }

    @ExceptionHandler(InvalidSearchFiltersException.class)
    public ResponseEntity invalidSearchFiltersExceptionHandler(InvalidSearchFiltersException e) {
        return ResponseEntity.badRequest().body("Search request filters are not valid.\n" + e.getLocalizedMessage());
    }

    @PostMapping()
    public ResponseEntity save(@RequestBody ApplicantDTO applicant) {
        Applicant applicantModel = applicant.toApplicant();
        this.applicantService.save(applicantModel);
        return ResponseEntity.ok("Applicant saved successfully");
    }

    @ExceptionHandler(DTOConversionException.class)
    public ResponseEntity dtoConversionExceptionHandler(DTOConversionException e) {
        return ResponseEntity.badRequest().body("Applicant fields are not valid.");
    }
}
