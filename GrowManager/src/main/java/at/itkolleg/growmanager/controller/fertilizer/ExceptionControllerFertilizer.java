package at.itkolleg.growmanager.controller.fertilizer;

import at.itkolleg.growmanager.exceptions.ExceptionsDTO;
import at.itkolleg.growmanager.exceptions.FormValidationExceptionDTO;
import at.itkolleg.growmanager.exceptions.fertilizer.DuplicatedFertilizerException;
import at.itkolleg.growmanager.exceptions.fertilizer.FertilizerNotFound;
import at.itkolleg.growmanager.exceptions.fertilizer.FertilizerValidationFailed;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionControllerFertilizer {

    @ExceptionHandler(FertilizerNotFound.class)
    public ResponseEntity<ExceptionsDTO> fertilizerNotFound(FertilizerNotFound fertilizerNotFound){
        return new ResponseEntity<>(new ExceptionsDTO("1000", fertilizerNotFound.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(FertilizerValidationFailed.class)
    public ResponseEntity<FormValidationExceptionDTO> fertilizerValidationFailed(FertilizerValidationFailed fertilizerValidationFailed){
        return new ResponseEntity<>(fertilizerValidationFailed.getErrorMap(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DuplicatedFertilizerException.class)
    public ResponseEntity<ExceptionsDTO> duplicatedFertilizer(DuplicatedFertilizerException duplicatedFertilizerException){
        return new ResponseEntity<>(new ExceptionsDTO("1500", duplicatedFertilizerException.getMessage()), HttpStatus.CONFLICT);
    }

}
