package hu.iit.me.service;

import hu.iit.me.dao.ApplicantDAO;
import hu.iit.me.model.Applicant;
import hu.iit.me.util.SearchRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service("applicantService")
public class BasicApplicantService implements ApplicantService {

    @Autowired
    private ApplicantDAO applicantDAO;

    @Override
    public Collection<Applicant> listAllApplicants() {
        return applicantDAO.findAll();
    }

    @Override
    public Collection<Applicant> findBy(SearchRequest request) {
        return applicantDAO.findByField(request.getFilters());
    }


    @Override
    public void save(Applicant applicant) {
        this.applicantDAO.save(applicant);
    }
}
