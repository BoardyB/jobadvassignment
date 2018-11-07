package hu.iit.me.service;

import hu.iit.me.model.Job;

import java.util.Collection;

public interface JobService {

    Collection<Job> listAllJobs();

    Collection<Job> findBy(String fieldName, String fieldValue);

    void save(Job job);
}
