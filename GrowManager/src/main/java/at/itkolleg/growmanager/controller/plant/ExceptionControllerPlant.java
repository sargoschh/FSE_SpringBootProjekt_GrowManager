package at.itkolleg.growmanager.controller.plant;

import at.itkolleg.growmanager.exceptions.ExceptionsDTO;
import at.itkolleg.growmanager.exceptions.FormValidationExceptionDTO;
import at.itkolleg.growmanager.exceptions.plant.DuplicatedPlantException;
import at.itkolleg.growmanager.exceptions.plant.PlantNotFound;
import at.itkolleg.growmanager.exceptions.plant.PlantValidationFailed;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionControllerPlant {

    @ExceptionHandler(PlantNotFound.class)
    public ResponseEntity<ExceptionsDTO> plantNotFound(PlantNotFound plantNotFound) {
        return new ResponseEntity<>(new ExceptionsDTO("1000", plantNotFound.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PlantValidationFailed.class)
    public ResponseEntity<FormValidationExceptionDTO> plantValidationFailed(PlantValidationFailed plantValidationFailed) {
        return new ResponseEntity<>(plantValidationFailed.getErrorMap(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DuplicatedPlantException.class)
    public ResponseEntity<ExceptionsDTO> duplicatedPlantException(DuplicatedPlantException duplicatedPlantException) {
        return new ResponseEntity<>(new ExceptionsDTO("1500", duplicatedPlantException.getMessage()), HttpStatus.CONFLICT);
    }
}
