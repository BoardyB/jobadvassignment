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
public class ApplicantDAOImpl extends AbstractDAOImpl<Applicant> implements ApplicantDAO {
}
