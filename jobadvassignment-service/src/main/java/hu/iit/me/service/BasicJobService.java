package hu.iit.me.service;

import hu.iit.me.dao.JobDAO;
import hu.iit.me.model.Job;
import hu.iit.me.util.SearchRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service("jobService")
public class BasicJobService implements JobService {

    @Autowired
    private JobDAO jobDAO;


    @Override
    public Collection<Job> listAllJobs() {
        return jobDAO.findAll();
    }


    @Override
    public Collection<Job> findBy(SearchRequest request) {
        return jobDAO.findBy(request.getFilters());
    }


    @Override
    public void save(Job job) {
        this.jobDAO.save(job);
    }
}
