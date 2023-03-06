package at.itkolleg.growmanager.exceptions.benutzer;

import at.itkolleg.growmanager.exceptions.FormValidationExceptionDTO;

public class BenutzerValidationFailed extends Exception {

    private FormValidationExceptionDTO errors;

    public BenutzerValidationFailed(String message){
        super(message);
    }

    public BenutzerValidationFailed(FormValidationExceptionDTO errors){
        this.errors = errors;
    }

    public FormValidationExceptionDTO getErrorMap(){
        return errors;
    }
}
