package hu.iit.me.service;

import hu.iit.me.model.Applicant;
import hu.iit.me.util.SearchRequest;

import java.util.Collection;

public interface ApplicantService {

    Collection<Applicant> listAllApplicants();

    Collection<Applicant> findBy(SearchRequest request);

    void save(Applicant applicant);

}
