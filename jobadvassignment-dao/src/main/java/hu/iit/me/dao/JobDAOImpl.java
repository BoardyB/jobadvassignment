package hu.iit.me.dao;

import hu.iit.me.model.Job;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository("jobDAO")
public class JobDAOImpl implements JobDAO {

    private static final Logger logger = LoggerFactory.getLogger(JobDAOImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<Job> findAll() {
        logger.debug("Querying all stored jobs...");
        Session session = this.sessionFactory.getCurrentSession();
        List<Job> jobs = session.createQuery("FROM " + Job.class.getSimpleName(), Job.class).list();
        logger.debug("Jobs retrieved: {}", jobs);
        return jobs;
    }

    @Override
    @Transactional
    public List<Job> findByField(String fieldName, String fieldValue) {
        logger.debug("Querying jobs with [{}] = [{}]", fieldName, fieldValue);
        Session session = this.sessionFactory.getCurrentSession();
        CriteriaQuery<Job> query = createQueryForField(fieldName, fieldValue, session);
        List<Job> jobs = session.createQuery(query).list();
        logger.debug("Jobs retrieved: {}", jobs);
        return jobs;
    }

    private CriteriaQuery<Job> createQueryForField(String fieldName, String fieldValue, Session session) {
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Job> query = criteriaBuilder.createQuery(Job.class);
        Root<Job> root = query.from(Job.class);
        try {
            query.select(root).where(criteriaBuilder.equal(root.get(fieldName), fieldValue));
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Field [" + fieldName + "] does not exist on type [" + Job.class.getSimpleName() + "]");
        }
        return query;
    }

    @Override
    @Transactional
    public void save(Job job) {
        logger.debug("Saving job to database {}", job);
        Session session = this.sessionFactory.getCurrentSession();
        session.save(job);
        logger.debug("Job saved to database");
    }


}
