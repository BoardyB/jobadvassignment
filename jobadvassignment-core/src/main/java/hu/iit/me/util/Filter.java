package hu.iit.me.util;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = NumberFilter.class, name = "NUMBER"),
        @JsonSubTypes.Type(value = DateFilter.class, name = "DATE"),
        @JsonSubTypes.Type(value = Filter.class, name = "EXACTMATCH"),
        @JsonSubTypes.Type(value = Filter.class, name = "PARTIALMATCH")
})
public class Filter {

    private String fieldName;
    private Object fieldValue;
    private FilterType type;

    public Filter() {
    }

    public Filter(String fieldName, Object fieldValue) {
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

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

    public FilterType getType() {
        return type;
    }

    public void setType(FilterType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Filter{");
        sb.append("fieldName='").append(fieldName).append('\'');
        sb.append(", fieldValue=").append(fieldValue);
        sb.append(", type=").append(type);
        sb.append('}');
        return sb.toString();
    }
}
