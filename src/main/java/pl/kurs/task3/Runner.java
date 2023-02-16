package pl.kurs.task3;

import java.util.*;
import java.util.stream.Collectors;

public class Runner {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3, null,4,5,6,7,8,9,10, null);
        List<Integer> list2 = Arrays.asList(1,2,3,5);
        System.out.println(getTop5FromTheList(list));
    }

    public static List<Integer> getTop5FromTheList(List<Integer> list) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .sorted(Comparator.reverseOrder())
                .limit(5)
                .collect(Collectors.collectingAndThen(Collectors.toList(), l -> l.size() >= 5 ? l : Collections.emptyList()));
        }
}
