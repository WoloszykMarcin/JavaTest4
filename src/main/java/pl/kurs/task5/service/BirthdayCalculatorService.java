package pl.kurs.task5.service;

import pl.kurs.task5.exception.InvalidBirthDateException;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;
import java.util.stream.Stream;

public class BirthdayCalculatorService {

    public static void calculateBirthDate() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter your date of birth in the format yyyy-MM-dd: ");
            LocalDate birthDate = LocalDate.parse(scanner.nextLine());

            if (birthDate.isAfter(LocalDate.now())) {
                throw new InvalidBirthDateException("Invalid birth date!");
            }

            calculateDaysMonthsAndYears(birthDate);
            System.out.println(calculateFirstFridayThe13th(birthDate));
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format!");
        } catch (InvalidBirthDateException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void calculateDaysMonthsAndYears(LocalDate birthDate) {
        long daysAlive = ChronoUnit.DAYS.between(birthDate, LocalDate.now());
        long monthsAlive = ChronoUnit.MONTHS.between(birthDate, LocalDate.now());
        long yearsAlive = ChronoUnit.YEARS.between(birthDate, LocalDate.now());
        DayOfWeek dayOfWeek = birthDate.getDayOfWeek();

        System.out.println("You have been living for " + daysAlive + " days.");
        System.out.println("You have been living " + monthsAlive + " months.");
        System.out.println("You have been living for " + yearsAlive + " years.");
        System.out.println("You were born on a " + dayOfWeek + ".");
    }

    public static LocalDate calculateFirstFridayThe13th(LocalDate birthDate) {
            return Stream.iterate(birthDate.withDayOfMonth(13), date -> date.plusMonths(1))
                    .filter(date -> date.getDayOfWeek() == DayOfWeek.FRIDAY)
                    .findFirst()
                    .orElse(null);
    }
}

