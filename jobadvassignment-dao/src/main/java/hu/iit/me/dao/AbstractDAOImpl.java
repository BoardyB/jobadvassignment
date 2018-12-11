package hu.iit.me.dao;

import com.google.common.reflect.TypeToken;
import hu.iit.me.model.PersistableEntity;
import hu.iit.me.util.filter.Filter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class AbstractDAOImpl<T extends PersistableEntity> {

    private static final Logger logger = LoggerFactory.getLogger(AbstractDAOImpl.class);

    private final TypeToken<T> type = new TypeToken<T>(getClass()) {
    };

    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    @Transactional
    public List<T> findAll() {
        logger.debug("Querying all stored entities...");
        Session session = this.sessionFactory.getCurrentSession();
        List entities = session.createQuery("FROM " + type.getRawType().getSimpleName(), type.getRawType()).list();
        logger.debug("Entities retrieved: {}", entities);
        return entities;
    }

    @SuppressWarnings("unchecked")
    @Transactional
    public List<T> findBy(List<Filter> filters) {
        logger.debug("Querying entities with matching filters: {}", filters);
        Session session = this.sessionFactory.getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = criteriaBuilder.createQuery((Class<T>) type.getRawType());
        Root<T> root = query.from((Class<T>) type.getRawType());
        List<Predicate> predicates = createPredicatesFromFilters(filters, criteriaBuilder, root);
        query.select(root).where(predicates.toArray(new Predicate[]{}));
        List<T> entities = session.createQuery(query).list();
        logger.debug("Entities retrieved: {}", entities);
        return entities;
    }

    private List<Predicate> createPredicatesFromFilters(List<Filter> filters, CriteriaBuilder criteriaBuilder, Root<T> root) {
        List<Predicate> predicates = newArrayList();
        filters.forEach((Filter filter) -> {
            predicates.addAll(filter.createPredicates(criteriaBuilder, root));
        });
        return predicates;
    }

    @Transactional
    public void save(T entity) {
        logger.debug("Saving entity to database {}", entity);
        Session session = this.sessionFactory.getCurrentSession();
        session.save(entity);
        logger.debug("Entity saved to database");
    }

}
