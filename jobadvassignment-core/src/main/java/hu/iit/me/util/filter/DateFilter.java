package hu.iit.me.util.filter;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.google.common.collect.Lists.newArrayList;
import static java.util.Objects.isNull;

@SuppressWarnings("unchecked")
public class DateFilter extends Filter {

    @Override
    public List<Predicate> createPredicates(CriteriaBuilder criteriaBuilder, Root root) {
        List<Predicate> predicates = newArrayList();
        Path path = root.get(this.getFieldName());
        LocalDate min = this.getMinValue();
        if (!isNull(min)) {
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(path, min));
        }
        LocalDate max = this.getMaxValue();
        if (!isNull(max)) {
            predicates.add(criteriaBuilder.lessThanOrEqualTo(path, max));
        }
        return predicates;
    }

    private LocalDate getMinValue() {
        Map<String, String> valueMap = (Map<String, String>) this.getFieldValue();
        String minValueString = valueMap.get("min");
        return isNullOrEmpty(minValueString) ? null : LocalDate.parse(minValueString);
    }

    private LocalDate getMaxValue() {
        Map<String, String> valueMap = (Map<String, String>) this.getFieldValue();
        String maxValueString = valueMap.get("max");
        return isNullOrEmpty(maxValueString) ? null : LocalDate.parse(maxValueString);
    }
}
