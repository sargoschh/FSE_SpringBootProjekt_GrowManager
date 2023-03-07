package at.itkolleg.growmanager.controller.water;

import at.itkolleg.growmanager.exceptions.ExceptionsDTO;
import at.itkolleg.growmanager.exceptions.FormValidationExceptionDTO;
import at.itkolleg.growmanager.exceptions.water.DuplicatedWaterException;
import at.itkolleg.growmanager.exceptions.water.WaterNotFound;
import at.itkolleg.growmanager.exceptions.water.WaterValidiationFailed;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionControllerWater {

    @ExceptionHandler(WaterNotFound.class)
    public ResponseEntity<ExceptionsDTO> waterNotFound(WaterNotFound waterNotFound){
        return new ResponseEntity<>(new ExceptionsDTO("1000", waterNotFound.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(WaterValidiationFailed.class)
    public ResponseEntity<FormValidationExceptionDTO> waterValidationFailder(WaterValidiationFailed waterValidiationFailed){
        return new ResponseEntity<>(waterValidiationFailed.getErrorMap(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DuplicatedWaterException.class)
    public ResponseEntity<ExceptionsDTO> duplicatedWaterException(DuplicatedWaterException duplicatedWaterException){
        return new ResponseEntity<>(new ExceptionsDTO("1500", duplicatedWaterException.getMessage()), HttpStatus.CONFLICT);
    }


}
