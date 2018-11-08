package hu.iit.me.util;

import java.time.LocalDate;
import java.util.Date;
import java.util.Map;

public class DateFilter extends Filter {

    public DateFilter() {
    }

    public DateFilter(String fieldName, Object fieldValue) {
        super(fieldName, fieldValue);
    }

    public LocalDate getMinValue() {
        Map<String, String> valueMap = (Map<String, String>) this.getFieldValue();
        return LocalDate.parse(valueMap.get("min"));
    }

    public LocalDate getMaxValue() {
        Map<String, String> valueMap = (Map<String, String>) this.getFieldValue();
        return LocalDate.parse(valueMap.get("max"));
    }
}
