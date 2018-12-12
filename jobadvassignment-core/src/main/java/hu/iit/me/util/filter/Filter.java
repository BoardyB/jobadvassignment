package hu.iit.me.util.filter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = NumberFilter.class, name = "NUMBER"),
        @JsonSubTypes.Type(value = DateFilter.class, name = "DATE"),
        @JsonSubTypes.Type(value = ExactMatchFilter.class, name = "EXACTMATCH"),
        @JsonSubTypes.Type(value = PartialMatchFilter.class, name = "PARTIALMATCH")
})
public abstract class Filter {

    private String fieldName;
    private Object fieldValue;

    public Filter() {
    }

    public Filter(String fieldName, Object fieldValue) {
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    @JsonIgnore
    public List<String> getValuesAsStringList() {
        if (fieldValue instanceof Collection) {
            List<String> valuesAsStrings = newArrayList();
            Collection values = (Collection) this.fieldValue;
            values.forEach(value -> valuesAsStrings.add(String.valueOf(value)));
            return valuesAsStrings;
        }
        return Collections.singletonList(String.valueOf(fieldValue));
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public Object getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(Object fieldValue) {
        this.fieldValue = fieldValue;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Filter{");
        sb.append("fieldName='").append(fieldName).append('\'');
        sb.append(", fieldValue=").append(fieldValue);
        sb.append('}');
        return sb.toString();
    }

    public abstract List<Predicate> createPredicates(CriteriaBuilder criteriaBuilder, Root root);

}
