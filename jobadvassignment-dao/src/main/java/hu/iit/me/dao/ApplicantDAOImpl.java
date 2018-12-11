package hu.iit.me.dao;

import hu.iit.me.model.Applicant;
import org.springframework.stereotype.Repository;

@Repository("applicantDAO")
public class ApplicantDAOImpl extends AbstractDAOImpl<Applicant> implements ApplicantDAO {
}
