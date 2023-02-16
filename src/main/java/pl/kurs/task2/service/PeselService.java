package pl.kurs.task2.service;

import java.time.LocalDate;
import java.util.Optional;

public class PeselService {

    public static Optional<LocalDate> extractDate(String pesel) {
        if (pesel == null || pesel.length() != 11 || pesel.isEmpty()) {
            return Optional.empty();
        }
        String dateStr = pesel.substring(0, 6);
        try {
            int year = Integer.parseInt(dateStr.substring(0, 2));
            int month = Integer.parseInt(dateStr.substring(2, 4));
            int day = Integer.parseInt(dateStr.substring(4, 6));
            year += (month > 12) ? 2000 : 1900;
            month = (month > 12) ? month - 20 : month;
            return Optional.of(LocalDate.of(year, month, day));
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            return Optional.empty();
        }
    }
}
