package hu.iit.me.util.filter;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Map;

import static com.google.common.collect.Lists.newArrayList;
import static java.util.Objects.isNull;

@SuppressWarnings("unchecked")
public class NumberFilter extends Filter {

    public NumberFilter() {
    }

    public NumberFilter(String fieldName, Object fieldValue) {
        super(fieldName, fieldValue);
    }

    @Override
    public List<Predicate> createPredicates(CriteriaBuilder criteriaBuilder, Root root) {
        List<Predicate> predicates = newArrayList();
        Path path = root.get(this.getFieldName());
        Integer min = this.getMinValue();
        if (!isNull(min)) {
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(path, min));
        }
        Integer max = this.getMaxValue();
        if (!isNull(max)) {
            predicates.add(criteriaBuilder.lessThanOrEqualTo(path, max));
        }
        return predicates;
    }

    private Integer getMinValue() {
        Map<String, Integer> valueMap = (Map<String, Integer>) this.getFieldValue();
        return valueMap.get("min");
    }

    private Integer getMaxValue() {
        Map<String, Integer> valueMap = (Map<String, Integer>) this.getFieldValue();
        return valueMap.get("max");
    }
}
