package at.itkolleg.growmanager.controller;

import at.itkolleg.growmanager.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

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
    public ResponseEntity<ExceptionsDTO> duplicatedPlantTypeExceptionResponseEntity(DuplicatedPlantTypeException duplicatedPlantTypeException) {
        return new ResponseEntity<>(new ExceptionsDTO("1500", duplicatedPlantTypeException.getMessage()), HttpStatus.CONFLICT);
    }
}
