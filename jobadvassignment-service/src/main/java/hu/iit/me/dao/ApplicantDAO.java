package hu.iit.me.dao;

import java.util.List;

import hu.iit.me.model.Applicant;

public interface ApplicantDAO {

    List<Applicant> findAll();
    List<Applicant> findByField(String fieldName, String fieldValue);

}
