package hu.iit.me.dao;

import hu.iit.me.model.Applicant;
import hu.iit.me.util.DateFilter;
import hu.iit.me.util.Filter;
import hu.iit.me.util.FilterType;
import hu.iit.me.util.NumberFilter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static java.util.Objects.isNull;

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

    @SuppressWarnings("unchecked")
    @Override
    @Transactional
    public List<Applicant> findByField(List<Filter> filters) {
        logger.debug("Querying applicants with matching filters: {}", filters);
        Session session = this.sessionFactory.getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Applicant> query = criteriaBuilder.createQuery(Applicant.class);
        Root<Applicant> root = query.from(Applicant.class);
        query.select(root);
        List<Predicate> predicates = newArrayList();
        filters.forEach((Filter filter) -> {
            Path fieldName = root.get(filter.getFieldName());
            if (filter.getType().equals(FilterType.EXACTMATCH)) {
                predicates.add(criteriaBuilder.equal(fieldName, filter.getValuesAsStringList().get(0)));
            }
            if (filter.getType().equals(FilterType.PARTIALMATCH)) {
                predicates.add(criteriaBuilder.like(fieldName, "%" + filter.getValuesAsStringList().get(0) + "%"));
            }
            if (filter instanceof NumberFilter) {
                Integer min = ((NumberFilter) filter).getMinValue();
                Integer max = ((NumberFilter) filter).getMaxValue();
                predicates.add(criteriaBuilder.between(fieldName, min, max));
            }
            if (filter instanceof DateFilter) {
                LocalDate min = ((DateFilter) filter).getMinValue();
                LocalDate max = ((DateFilter) filter).getMaxValue();
                predicates.add(criteriaBuilder.between(fieldName, min, max));
            }
        });
        try {
            query.where(
                    predicates.toArray(new Predicate[]{})
            );
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Invalid filters were provided.");
        }
        List<Applicant> applicants = session.createQuery(query).list();
        logger.debug("Applicants retrieved: {}", applicants);
        return applicants;
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
