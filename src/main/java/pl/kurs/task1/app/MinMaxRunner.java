package pl.kurs.task1.app;

import pl.kurs.task1.model.Employee;
import pl.kurs.task1.model.MinMax;
import pl.kurs.task1.service.MinMaxService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinMaxRunner {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1,2,3,4,5,6, null);
        List<String> stringList = Arrays.asList("cat", "dog", "elephant", "tortoise", "crocodile", "dinosaur", null);
        List<Employee> people = new ArrayList<>();
        people.add(new Employee("Jan", "Kowalski", 6000.0));
        people.add(new Employee("Ludwik", "Makowski", 8000.0));
        people.add(new Employee("Anna", "Bąk", 8000.0));
        people.add(new Employee("Maciej", "Segment", 15000.0));
        people.add(null);

        // zwraca min oraz max pod względem salary
        MinMax<Employee> minMax = MinMaxService.getMinAndMax(people);
        System.out.println("Min: " + minMax.getMin());
        System.out.println("Max: " + minMax.getMax());

//        System.out.println(MinMaxService.getMinAndMax(null));

        try {
            System.out.println(MinMaxService.getMinAndMax(integers));
            System.out.println(MinMaxService.getMinAndMax(stringList));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }


    }
}
