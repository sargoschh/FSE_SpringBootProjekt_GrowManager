package at.itkolleg.growmanager.controller.fertilizerType;


import at.itkolleg.growmanager.exceptions.ExceptionsDTO;
import at.itkolleg.growmanager.exceptions.FormValidationExceptionDTO;
import at.itkolleg.growmanager.exceptions.fertilizerType.DuplicatedFertilizerTypeException;
import at.itkolleg.growmanager.exceptions.fertilizerType.FertilizerTypeNotFound;
import at.itkolleg.growmanager.exceptions.fertilizerType.FertilizerTypeValidationFailed;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionControllerFertilizerType {

    @ExceptionHandler(FertilizerTypeNotFound.class)
    public ResponseEntity<ExceptionsDTO> fertilizerTypeNotFound(FertilizerTypeNotFound fertilizerTypeNotFound){
        return new ResponseEntity<>(new ExceptionsDTO("1000", fertilizerTypeNotFound.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(FertilizerTypeValidationFailed.class)
    public ResponseEntity<FormValidationExceptionDTO> fertilizerTypeValidationFailed(FertilizerTypeValidationFailed fertilizerTypeValidationFailed){
        return new ResponseEntity<>(fertilizerTypeValidationFailed.getErrorMap(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<ExceptionsDTO> duplicatedFertilizerType(DuplicatedFertilizerTypeException duplicatedFertilizerTypeException){
        return new ResponseEntity<>(new ExceptionsDTO("1500", duplicatedFertilizerTypeException.getMessage()), HttpStatus.CONFLICT);
    }

}
