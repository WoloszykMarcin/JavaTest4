package pl.kurs.task4.app;

import pl.kurs.task4.exception.NoWomenException;
import pl.kurs.task4.model.Person;
import pl.kurs.task4.service.PersonService;

import java.util.ArrayList;
import java.util.List;

public class PersonRunner {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Dagmara", "Grabowska", "Warszawa", 90));
        people.add(new Person("Jadwiga", "Kowalska", "Augustów", 90));
        people.add(new Person("Elżbieta", "Nowak", "Gdynia", 76));
        people.add(new Person("Halina", "Wójcik", "Złotoryja", 76));
        people.add(new Person("Jan", "Kowalski", "Toruń", 24));
        people.add(new Person("Stanisław", "Nowak", "Warszawa", 60));
        people.add(new Person("Andrzej", "Wójcik", null, 40));
        people.add(new Person("Kazimierz", "Jankowski", "Poznań", 37));
        people.add(new Person("Kazimierz", "Janowski", "Poznań", 34));
        people.add(null);

        try {
            System.out.println(PersonService.getTheOldestWomen(people));
        } catch (NoWomenException e) {
            throw new RuntimeException(e);
        }

        System.out.println(PersonService.getAverageAge(people));
        System.out.println(PersonService.getManAverageAge(people));
        System.out.println(PersonService.getWomanAverageAge(people));
        System.out.println(PersonService.getAverageAgeByGender(people, "male")); // female or male
        System.out.println(PersonService.getCitiesWithTheMostPeople(people));
        System.out.println(PersonService.getUniqueCities(people));

    }
}
