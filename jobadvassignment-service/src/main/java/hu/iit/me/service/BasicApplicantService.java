package hu.iit.me.service;

import hu.iit.me.model.Applicant;
import hu.iit.me.model.Gender;

import java.util.*;

public class BasicApplicantService implements ApplicantService {

    @Override
    public Collection<Applicant> listAllApplicants() {
        List<Applicant> list = new ArrayList<>();
        list.add(new Applicant(UUID.randomUUID().toString(), "Test", "Elek", new Date(), "5555555555", "123456789", Gender.MAN, "Here & There"));
        return list;
    }
}
