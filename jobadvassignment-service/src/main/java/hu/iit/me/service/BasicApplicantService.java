package hu.iit.me.service;

import hu.iit.me.dao.ApplicantDAO;
import hu.iit.me.model.Applicant;
import hu.iit.me.model.Gender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

public class BasicApplicantService implements ApplicantService {

    @Autowired
    private ApplicantDAO applicantDAO;

    @Override
    public Collection<Applicant> listAllApplicants() {
        return applicantDAO.findAll();
    }
}
