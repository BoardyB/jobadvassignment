package hu.iit.me.dao;

import hu.iit.me.model.Applicant;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class ApplicantDAOImpl implements ApplicantDAO {

    private static final Logger logger = LoggerFactory.getLogger(ApplicantDAOImpl.class);
    private SessionFactory sessionFactory;

    public ApplicantDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public List<Applicant> findAll() {
        logger.debug("Querying all stored applicants...");
        Session session = this.sessionFactory.getCurrentSession();
        List<Applicant> applicants = session.createQuery("FROM Applicant", Applicant.class).list();
        logger.debug("Applicants retrieved: {}", applicants);
        return applicants;
    }

	@Override
	public List<Applicant> findByField(String fieldName, String fieldValue) {
		return null;
	}

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
