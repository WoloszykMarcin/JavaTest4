package pl.kurs.task2.app;

import pl.kurs.task2.exception.InvalidPeselException;
import pl.kurs.task2.service.PeselService;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InvalidPeselException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        Integer nameLength = Optional.ofNullable(name)
                .map(String::length)
                .orElse(0);

        System.out.println("Length of your name: " + nameLength);

        System.out.print("Enter your PESEL: ");
        String pesel = scanner.nextLine();
        scanner.close();

        LocalDate date = PeselService.extractDate(pesel).orElseThrow(() -> new InvalidPeselException("Invalid PESEL"));
        System.out.println("Date of birth: " + date);
    }
}
