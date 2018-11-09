package hu.iit.me.dao;

import hu.iit.me.model.Job;
import hu.iit.me.util.filter.Filter;

import java.util.List;

public interface JobDAO {

    List<Job> findAll();

    List<Job> findBy(List<Filter> filters);

    void save(Job applicant);

}
