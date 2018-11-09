package hu.iit.me.dao;

import hu.iit.me.model.Applicant;
import hu.iit.me.util.filter.Filter;

import java.util.List;

public interface ApplicantDAO {

    List<Applicant> findAll();
    List<Applicant> findBy(List<Filter> filters);

    void save(Applicant applicant);

}
