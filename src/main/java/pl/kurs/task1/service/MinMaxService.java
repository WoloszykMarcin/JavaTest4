package pl.kurs.task1.service;

import pl.kurs.task1.model.MinMax;

import java.util.List;
import java.util.Objects;

public class MinMaxService {

    public static <T extends Comparable<T>> MinMax<T> getMinAndMax(List<T> elements) {
        if (elements == null || elements.isEmpty())
            throw new IllegalArgumentException("List must contain at least one element");

        T min = elements.stream()
                .filter(Objects::nonNull)
                .min(Comparable::compareTo)
                .orElse(null);
        T max = elements.stream()
                .filter(Objects::nonNull)
                .max(Comparable::compareTo)
                .orElse(null);

        return new MinMax<>(min, max);
    }
}
