package hu.iit.me.util;

import hu.iit.me.util.filter.Filter;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class SearchRequest {

    private List<Filter> filters = newArrayList();

    public SearchRequest() {
    }

    public SearchRequest(List<Filter> filters) {
        this.filters = filters;
    }

    public List<Filter> getFilters() {
        return filters;
    }

    public void setFilters(List<Filter> filters) {
        this.filters = filters;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SearchRequest{");
        sb.append("filters=").append(filters);
        sb.append('}');
        return sb.toString();
    }
}
