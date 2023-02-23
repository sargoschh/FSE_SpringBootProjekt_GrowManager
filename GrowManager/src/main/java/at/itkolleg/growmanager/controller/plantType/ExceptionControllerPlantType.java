package at.itkolleg.growmanager.controller.plantType;

import at.itkolleg.growmanager.exceptions.*;
import at.itkolleg.growmanager.exceptions.plantType.DuplicatedPlantTypeException;
import at.itkolleg.growmanager.exceptions.plantType.PlantTypeNotFound;
import at.itkolleg.growmanager.exceptions.plantType.PlantTypeValidationFailed;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionControllerPlantType {

    @ExceptionHandler(PlantTypeNotFound.class)
    public ResponseEntity<ExceptionsDTO> plantTypeNotFound(PlantTypeNotFound plantTypeNotFound) {
        return new ResponseEntity<>(new ExceptionsDTO("1000", plantTypeNotFound.getMessage()), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(PlantTypeValidationFailed.class)
    public ResponseEntity<FormValidationExceptionDTO> plantTypeValidationFailed(PlantTypeValidationFailed plantTypeValidationFailed) {
        return new ResponseEntity<>(plantTypeValidationFailed.getErrorMap(), HttpStatus.BAD_REQUEST);
    }
//https://stackoverflow.com/questions/63352008/better-way-to-add-custom-error-message-during-unique-constrains-jpa-hibernate
    @ExceptionHandler(DuplicatedPlantTypeException.class)
    public ResponseEntity<ExceptionsDTO> duplicatedPlantTypeException(DuplicatedPlantTypeException duplicatedPlantTypeException) {
        return new ResponseEntity<>(new ExceptionsDTO("1500", duplicatedPlantTypeException.getMessage()), HttpStatus.CONFLICT);
    }
}
