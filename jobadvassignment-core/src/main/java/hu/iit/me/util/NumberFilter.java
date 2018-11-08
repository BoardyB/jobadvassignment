package hu.iit.me.util;

import java.util.Map;

public class NumberFilter extends Filter {

    public NumberFilter() {
    }

    public NumberFilter(String fieldName, Object fieldValue) {
        super(fieldName, fieldValue);
    }

    public Integer getMinValue() {
        Map<String, Integer> valueMap = (Map<String, Integer>) this.getFieldValue();
        return valueMap.get("min");
    }

    public Integer getMaxValue() {
        Map<String, Integer> valueMap = (Map<String, Integer>) this.getFieldValue();
        return valueMap.get("max");
    }
}
