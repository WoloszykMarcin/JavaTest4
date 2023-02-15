package pl.kurs.task1.model;

import java.util.Objects;

public class MinMax<T extends Comparable> {
    private final T min;
    private final T max;

    public MinMax(T min, T max) {
        this.min = min;
        this.max = max;
    }

    public T getMin() {
        return min;
    }

    public T getMax() {
        return max;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MinMax)) return false;
        MinMax<?> minMax = (MinMax<?>) o;
        return Objects.equals(min, minMax.min) && Objects.equals(max, minMax.max);
    }

    @Override
    public int hashCode() {
        return Objects.hash(min, max);
    }

    @Override
    public String toString() {
        return "MinMax{" +
                "min=" + min +
                ", max=" + max +
                '}';
    }
}
