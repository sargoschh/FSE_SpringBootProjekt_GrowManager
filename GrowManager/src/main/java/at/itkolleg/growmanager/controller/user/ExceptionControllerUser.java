package at.itkolleg.growmanager.controller.user;

import at.itkolleg.growmanager.exceptions.ExceptionsDTO;
import at.itkolleg.growmanager.exceptions.FormValidationExceptionDTO;
import at.itkolleg.growmanager.exceptions.user.DuplicatedUserException;
import at.itkolleg.growmanager.exceptions.user.UserNotFound;
import at.itkolleg.growmanager.exceptions.user.UserValidationFailed;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionControllerUser {

    @ExceptionHandler(UserNotFound.class)
    public ResponseEntity<ExceptionsDTO> UserNotFound(UserNotFound userNotFound) {
        return new ResponseEntity<>(new ExceptionsDTO("1000", userNotFound.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserValidationFailed.class)
    public ResponseEntity<FormValidationExceptionDTO> UserValidationFailed(UserValidationFailed userValidationFailed) {
        return new ResponseEntity<>(userValidationFailed.getErrorMap(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DuplicatedUserException.class)
    public ResponseEntity<ExceptionsDTO> duplicatedUserException(DuplicatedUserException duplicatedUserException) {
        return new ResponseEntity<>(new ExceptionsDTO("1500", duplicatedUserException.getMessage()), HttpStatus.CONFLICT);
    }
}
