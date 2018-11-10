package hu.iit.me.util.filter;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class ExactMatchFilter extends Filter {

    @Override
    public List<Predicate> createPredicates(CriteriaBuilder criteriaBuilder, Root root) {
        Path path = root.get(this.getFieldName());
        return path.getJavaType().isEnum() ?
                newArrayList(criteriaBuilder.equal(path.as(String.class), this.getValuesAsStringList().get(0))) :
                newArrayList(criteriaBuilder.equal(path, this.getValuesAsStringList().get(0)));
    }

}
