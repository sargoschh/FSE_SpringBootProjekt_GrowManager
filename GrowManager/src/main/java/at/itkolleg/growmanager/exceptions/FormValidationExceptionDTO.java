package at.itkolleg.growmanager.exceptions;

import java.util.HashMap;

public class FormValidationExceptionDTO {

    String code;
    private HashMap<String, String> formValidationErrors;

    public FormValidationExceptionDTO(String code) {
        this.code = code;
        this.formValidationErrors = new HashMap<>();
    }

    public void addFormValidationError(String fieldName, String fieldErrorMessage) {
        this.formValidationErrors.put(fieldName, fieldErrorMessage);
    }
}
