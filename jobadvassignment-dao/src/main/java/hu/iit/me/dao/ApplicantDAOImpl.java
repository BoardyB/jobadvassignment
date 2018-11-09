package hu.iit.me.dao;

import hu.iit.me.model.Applicant;
import hu.iit.me.util.filter.Filter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

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
    public List<Applicant> findBy(List<Filter> filters) {
        logger.debug("Querying applicants with matching filters: {}", filters);
        Session session = this.sessionFactory.getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Applicant> query = criteriaBuilder.createQuery(Applicant.class);
        Root<Applicant> root = query.from(Applicant.class);
        query.select(root);
        List<Predicate> predicates = createPredicatesFromFilters(filters, criteriaBuilder, root);
        try {
            query.where(predicates.toArray(new Predicate[]{}));
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Invalid filters were provided.");
        }
        List<Applicant> applicants = session.createQuery(query).list();
        logger.debug("Applicants retrieved: {}", applicants);
        return applicants;
    }

    private List<Predicate> createPredicatesFromFilters(List<Filter> filters, CriteriaBuilder criteriaBuilder, Root<Applicant> root) {
        List<Predicate> predicates = newArrayList();
        filters.forEach((Filter filter) -> {
            predicates.addAll(filter.createPredicates(criteriaBuilder, root));
        });
        return predicates;
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
