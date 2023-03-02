package at.itkolleg.growmanager.controller.grow;

import at.itkolleg.growmanager.exceptions.ExceptionsDTO;
import at.itkolleg.growmanager.exceptions.FormValidationExceptionDTO;
import at.itkolleg.growmanager.exceptions.grow.DuplicatedGrowException;
import at.itkolleg.growmanager.exceptions.grow.GrowNotFound;
import at.itkolleg.growmanager.exceptions.grow.GrowValidationFailed;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionControllerGrow {

    @ExceptionHandler(GrowNotFound.class)
    public ResponseEntity<ExceptionsDTO> growNotFound(GrowNotFound growNotFound) {
        return new ResponseEntity<>(new ExceptionsDTO("1000", growNotFound.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(GrowValidationFailed.class)
    public ResponseEntity<FormValidationExceptionDTO> growValidationFailed(GrowValidationFailed growValidationFailed) {
        return new ResponseEntity<>(growValidationFailed.getErrorMap(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DuplicatedGrowException.class)
    public ResponseEntity<ExceptionsDTO> duplicatedGrowException(DuplicatedGrowException duplicatedGrowException) {
        return new ResponseEntity<>(new ExceptionsDTO("1500", duplicatedGrowException.getMessage()), HttpStatus.CONFLICT);
    }
}
