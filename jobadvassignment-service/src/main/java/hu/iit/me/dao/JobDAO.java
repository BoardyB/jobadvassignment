package hu.iit.me.dao;

import java.util.List;

import hu.iit.me.model.Job;

public interface JobDAO {

    List<Job> findAll();
    List<Job> findByField(String fieldName, String fieldValue);

}
