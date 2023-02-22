package at.itkolleg.growmanager.exceptions;

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
