package hu.iit.me.service;

import hu.iit.me.model.Job;
import hu.iit.me.util.SearchRequest;

import java.util.Collection;

public interface JobService {

    Collection<Job> listAllJobs();

    Collection<Job> findBy(SearchRequest request);

    void save(Job job);
}
