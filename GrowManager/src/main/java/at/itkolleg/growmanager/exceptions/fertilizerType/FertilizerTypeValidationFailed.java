package at.itkolleg.growmanager.exceptions.fertilizerType;

import at.itkolleg.growmanager.exceptions.FormValidationExceptionDTO;

public class FertilizerTypeValidationFailed extends Exception{

    private FormValidationExceptionDTO errors;

    public FertilizerTypeValidationFailed(String message){
        super(message);
    }
    public FertilizerTypeValidationFailed(FormValidationExceptionDTO errors){
        this.errors = errors;
    }

    public FormValidationExceptionDTO getErrorMap(){
        return errors;
    }

}
