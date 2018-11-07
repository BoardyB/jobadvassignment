package hu.iit.me.service;

import hu.iit.me.model.Applicant;

import java.util.Collection;

public interface ApplicantService {

    Collection<Applicant> listAllApplicants();

    Collection<Applicant> findBy(String fieldName, String fieldValue);

    void save(Applicant applicant);

}
