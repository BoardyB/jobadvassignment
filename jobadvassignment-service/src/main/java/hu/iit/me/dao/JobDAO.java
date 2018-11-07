package hu.iit.me.dao;

import hu.iit.me.model.Job;

import java.util.List;

public interface JobDAO {

    List<Job> findAll();

    List<Job> findByField(String fieldName, String fieldValue);

    void save(Job job);

}
