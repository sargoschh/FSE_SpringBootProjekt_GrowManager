package at.itkolleg.growmanager.exceptions;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

@Getter
@Setter
public class PlantTypeValidationFailed extends Exception {

    private FormValidationExceptionDTO errors;

    public PlantTypeValidationFailed(String message) {
        super(message);
    }

    public PlantTypeValidationFailed(FormValidationExceptionDTO errors) {
        this.errors = errors;
    }

    public FormValidationExceptionDTO getErrorMap() {
        return errors;
    }
}
