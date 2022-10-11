package com.srs.common.domain;

import java.io.Serializable;
import java.util.List;

public class Page<T> implements Serializable {
    private List<T> items;
    private long total;

    public Page() {
    }

    protected Page(List<T> items, long total) {
        this.items = items;
        this.total = total;
    }

    public static <T> Page<T> from(List<T> items, long count) {
        return new Page<>(items, count);
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
