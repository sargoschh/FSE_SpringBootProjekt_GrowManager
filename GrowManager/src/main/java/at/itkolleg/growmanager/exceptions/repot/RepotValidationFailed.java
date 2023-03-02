package at.itkolleg.growmanager.exceptions.repot;

import at.itkolleg.growmanager.exceptions.FormValidationExceptionDTO;

public class RepotValidationFailed extends Exception {

    private FormValidationExceptionDTO errors;

    public RepotValidationFailed(String message) {
        super(message);
    }

    public RepotValidationFailed(FormValidationExceptionDTO errors) {
        this.errors = errors;
    }

    public FormValidationExceptionDTO getErrorMap() {
        return errors;
    }
}
