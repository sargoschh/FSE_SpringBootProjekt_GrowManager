package at.itkolleg.growmanager.exceptions.water;

import at.itkolleg.growmanager.exceptions.FormValidationExceptionDTO;

public class WaterValidiationFailed extends Exception{

    private FormValidationExceptionDTO errors;

    public WaterValidiationFailed(String message){
        super(message);
    }

    public WaterValidiationFailed(FormValidationExceptionDTO errors){
        this.errors = errors;
    }

    public FormValidationExceptionDTO getErrorMap(){
        return errors;
    }


}
