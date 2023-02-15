package pl.kurs.task4.service;

import pl.kurs.task4.exception.NoWomenException;
import pl.kurs.task4.model.Person;

import java.util.*;
import java.util.stream.Collectors;

public class PersonService {
    public static List<Person> getTheOldestWomen(List<Person> list) throws NoWomenException {
        Set<Map.Entry<Integer, List<Person>>> womenEntries = Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(person -> person != null && person.getFirstName() != null && person.getFirstName().endsWith("a"))
                .collect(Collectors.groupingBy(Person::getAge))
                .entrySet();

        return womenEntries.stream()
                .max(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .orElseThrow(() -> new NoWomenException("No women found in the list."));
    }

    public static Double getAverageAge(List<Person> list) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .filter(p -> Objects.nonNull(p.getAge()))
                .mapToDouble(p -> p.getAge())
                .average()
                .orElse(0);
    }

    public static Double getManAverageAge(List<Person> list) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .filter(p -> Objects.nonNull(p.getAge()))
                .filter(p -> !p.getFirstName().endsWith("a"))
                .mapToDouble(p -> p.getAge())
                .average()
                .orElse(0);
    }

    public static Double getWomanAverageAge(List<Person> list) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .filter(p -> Objects.nonNull(p.getAge()))
                .filter(p -> p.getFirstName().endsWith("a"))
                .mapToDouble(p -> p.getAge())
                .average()
                .orElse(0);
    }

    public static Double getAverageAgeByGender(List<Person> list, String gender) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .filter(p -> Objects.nonNull(p.getAge()))
                .filter(p -> "female".equals(gender) ? p.getFirstName().endsWith("a") : !p.getFirstName().endsWith("a"))
                .mapToDouble(p -> p.getAge())
                .average()
                .orElse(Double.NaN);
    }

    public static List<String> getCitiesWithTheMostPeople(List<Person> list) {
        Set<Map.Entry<String, Long>> entries = Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .filter(p -> Objects.nonNull(p.getCity()))
                .collect(Collectors.groupingBy(Person::getCity, Collectors.counting()))
                .entrySet();

        long maxValue = entries.stream()
                .mapToLong(Map.Entry::getValue)
                .max()
                .orElse(0);

        return entries
                .stream()
                .filter(entry -> entry.getValue() == maxValue)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static List<String> getUniqueCities(List<Person> list) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .map(Person::getCity)
                .filter(Objects::nonNull)
                .distinct()
                .collect(Collectors.toList());
    }

}