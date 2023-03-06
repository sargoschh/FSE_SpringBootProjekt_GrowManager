package at.itkolleg.growmanager.exceptions.user;

import at.itkolleg.growmanager.exceptions.FormValidationExceptionDTO;

public class UserValidationFailed extends Exception {

    private FormValidationExceptionDTO errors;

    public UserValidationFailed(String message){
        super(message);
    }

    public UserValidationFailed(FormValidationExceptionDTO errors){
        this.errors = errors;
    }

    public FormValidationExceptionDTO getErrorMap(){
        return errors;
    }
}
