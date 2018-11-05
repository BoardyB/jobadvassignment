package hu.iit.me.dao;

import hu.iit.me.model.Job;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JobDAOImpl implements JobDAO {

    private static final Logger logger = LoggerFactory.getLogger(JobDAOImpl.class);
    private SessionFactory sessionFactory;

    @Override
    public List<Job> findAll() {
        logger.debug("Querying all stored jobs...");
        Session session = this.sessionFactory.getCurrentSession();
        List<Job> applicants = session.createQuery("from job", Job.class).list();
        logger.debug("Jobs retrieved: {}", applicants);
        return applicants;
    }

    @Override
    public List<Job> findByField(String fieldName, String fieldValue) {
        return null;
    }


}
