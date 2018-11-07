package hu.iit.me.dao;

import hu.iit.me.model.Applicant;
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

@Repository("applicantDAO")
public class ApplicantDAOImpl implements ApplicantDAO {

    private static final Logger logger = LoggerFactory.getLogger(ApplicantDAOImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<Applicant> findAll() {
        logger.debug("Querying all stored applicants...");
        Session session = this.sessionFactory.getCurrentSession();
        List<Applicant> applicants = session.createQuery("FROM " + Applicant.class.getSimpleName(), Applicant.class).list();
        logger.debug("Applicants retrieved: {}", applicants);
        return applicants;
    }

    @Override
    @Transactional
    public List<Applicant> findByField(String fieldName, String fieldValue) {
        logger.debug("Querying applicants with [{}] = [{}]", fieldName, fieldValue);
        Session session = this.sessionFactory.getCurrentSession();
        CriteriaQuery<Applicant> query = createQueryForField(fieldName, fieldValue, session);
        List<Applicant> applicants = session.createQuery(query).list();
        logger.debug("Applicants retrieved: {}", applicants);
        return applicants;
    }

    private CriteriaQuery<Applicant> createQueryForField(String fieldName, String fieldValue, Session session) {
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Applicant> query = criteriaBuilder.createQuery(Applicant.class);
        Root<Applicant> root = query.from(Applicant.class);
        try {
            query.select(root).where(criteriaBuilder.equal(root.get(fieldName), fieldValue));
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Field [" + fieldName + "] does not exist on type [" + Applicant.class.getSimpleName() + "]");
        }
        return query;
    }

    @Override
    @Transactional
    public void save(Applicant applicant) {
        logger.debug("Saving applicant to database {}", applicant);
        Session session = this.sessionFactory.getCurrentSession();
        session.save(applicant);
        logger.debug("Applicant saved to database");
    }

}
