package com.srs.common.dto;

import java.io.Serializable;
import java.util.Objects;


public class Pair<L, R> implements Serializable {
    protected L first;
    protected R second;

    public Pair() {
    }

    protected Pair(L first, R second) {
        this.first = first;
        this.second = second;
    }

    public static <L, R> Pair<L, R> from(L first, R second) {
        return new Pair<>(first, second);
    }

    public L getFirst() {
        return first;
    }

    public void setFirst(L first) {
        this.first = first;
    }

    public R getSecond() {
        return second;
    }

    public void setSecond(R second) {
        this.second = second;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Pair<?, ?> pair = (Pair<?, ?>) o;

        if (!Objects.equals(first, pair.first)) {
            return false;
        }
        return Objects.equals(second, pair.second);
    }

    @Override
    public int hashCode() {
        int result = first != null ? first.hashCode() : 0;
        result = 31 * result + (second != null ? second.hashCode() : 0);
        return result;
    }
}
