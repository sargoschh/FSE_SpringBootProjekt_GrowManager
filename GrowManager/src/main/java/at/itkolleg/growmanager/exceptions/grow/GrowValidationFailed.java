package at.itkolleg.growmanager.exceptions.grow;

import at.itkolleg.growmanager.exceptions.FormValidationExceptionDTO;

public class GrowValidationFailed extends Exception {


    private FormValidationExceptionDTO errors;

    public GrowValidationFailed(String message) {
        super(message);
    }

    public GrowValidationFailed(FormValidationExceptionDTO errors) {
        this.errors = errors;
    }

    public FormValidationExceptionDTO getErrorMap() {
        return errors;
    }
}
