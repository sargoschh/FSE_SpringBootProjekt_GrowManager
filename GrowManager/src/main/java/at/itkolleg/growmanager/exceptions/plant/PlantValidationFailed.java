package at.itkolleg.growmanager.exceptions.plant;

import at.itkolleg.growmanager.exceptions.FormValidationExceptionDTO;

public class PlantValidationFailed extends Exception {


    private FormValidationExceptionDTO errors;

    public PlantValidationFailed(String message) {
        super(message);
    }

    public PlantValidationFailed(FormValidationExceptionDTO errors) {
        this.errors = errors;
    }

    public FormValidationExceptionDTO getErrorMap() {
        return errors;
    }
}
