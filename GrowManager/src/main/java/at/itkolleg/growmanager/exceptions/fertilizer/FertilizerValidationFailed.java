package at.itkolleg.growmanager.exceptions.fertilizer;

import at.itkolleg.growmanager.exceptions.FormValidationExceptionDTO;

public class FertilizerValidationFailed extends Exception{

    private FormValidationExceptionDTO errors;

    public FertilizerValidationFailed(String message){
        super(message);
    }

    public FertilizerValidationFailed(FormValidationExceptionDTO errors){
        this.errors = errors;
    }

    public FormValidationExceptionDTO getErrorMap(){
        return errors;
    }


}
