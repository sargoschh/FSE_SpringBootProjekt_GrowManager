package at.itkolleg.growmanager.controller.benutzer;

import at.itkolleg.growmanager.exceptions.ExceptionsDTO;
import at.itkolleg.growmanager.exceptions.FormValidationExceptionDTO;
import at.itkolleg.growmanager.exceptions.benutzer.DuplicatedBenutzerException;
import at.itkolleg.growmanager.exceptions.benutzer.BenutzerNotFound;
import at.itkolleg.growmanager.exceptions.benutzer.BenutzerValidationFailed;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionControllerBenutzer {

    @ExceptionHandler(BenutzerNotFound.class)
    public ResponseEntity<ExceptionsDTO> UserNotFound(BenutzerNotFound userNotFound) {
        return new ResponseEntity<>(new ExceptionsDTO("1000", userNotFound.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BenutzerValidationFailed.class)
    public ResponseEntity<FormValidationExceptionDTO> UserValidationFailed(BenutzerValidationFailed userValidationFailed) {
        return new ResponseEntity<>(userValidationFailed.getErrorMap(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DuplicatedBenutzerException.class)
    public ResponseEntity<ExceptionsDTO> duplicatedUserException(DuplicatedBenutzerException duplicatedUserException) {
        return new ResponseEntity<>(new ExceptionsDTO("1500", duplicatedUserException.getMessage()), HttpStatus.CONFLICT);
    }
}
