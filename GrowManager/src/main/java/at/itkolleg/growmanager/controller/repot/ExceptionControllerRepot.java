package at.itkolleg.growmanager.controller.repot;

import at.itkolleg.growmanager.exceptions.ExceptionsDTO;
import at.itkolleg.growmanager.exceptions.FormValidationExceptionDTO;
import at.itkolleg.growmanager.exceptions.repot.DuplicatedRepotException;
import at.itkolleg.growmanager.exceptions.repot.RepotNotFound;
import at.itkolleg.growmanager.exceptions.repot.RepotValidationFailed;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionControllerRepot {

    @ExceptionHandler(RepotNotFound.class)
    public ResponseEntity<ExceptionsDTO> repotNotFound(RepotNotFound repotNotFound) {
        return new ResponseEntity<>(new ExceptionsDTO("1000", repotNotFound.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RepotValidationFailed.class)
    public ResponseEntity<FormValidationExceptionDTO> repotValidationFailed(RepotValidationFailed repotValidationFailed) {
        return new ResponseEntity<>(repotValidationFailed.getErrorMap(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DuplicatedRepotException.class)
    public ResponseEntity<ExceptionsDTO> duplicatedRepotException(DuplicatedRepotException duplicatedRepotException) {
        return new ResponseEntity<>(new ExceptionsDTO("1500", duplicatedRepotException.getMessage()), HttpStatus.CONFLICT);
    }
}
