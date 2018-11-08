package hu.iit.me.dao;

import hu.iit.me.model.Applicant;

import java.util.List;

public interface ApplicantDAO {

    List<Applicant> findAll();
    List<Applicant> findByField(String fieldName, String fieldValue);

    void save(Applicant applicant);

}
