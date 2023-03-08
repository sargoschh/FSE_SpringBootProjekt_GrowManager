package at.itkolleg.growmanager;

import jakarta.validation.ValidationException;

import java.sql.Date;
import java.time.LocalDate;

public class Assert {

    public static boolean validationDateBeforeToday(LocalDate localDate) {
        if(localDate!=null) {
            LocalDate localDate1 = LocalDate.now();
            if(localDate.isBefore(localDate1)) {
                return true;
            } else {
                throw new ValidationException("Datum darf nicht nach dem aktuellen Datum liegen!");
            }
        } else {
            throw new ValidationException("Datum darf nicht null / leer sein!");
        }
    }

    public static boolean validationDateAfterToday(LocalDate localDate) {
        if(localDate!=null) {
            LocalDate localDate1 = LocalDate.now();
            if(localDate.isAfter(localDate1)) {
                return true;
            } else {
                throw new ValidationException("Datum darf nicht vor dem aktuellen Datum liegen!");
            }
        } else {
            throw new ValidationException("Datum darf nicht null / leer sein!");
        }
    }
}
