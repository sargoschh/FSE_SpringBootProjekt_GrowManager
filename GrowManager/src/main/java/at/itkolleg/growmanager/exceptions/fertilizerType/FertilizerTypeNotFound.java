package at.itkolleg.growmanager.exceptions.fertilizerType;

import at.itkolleg.growmanager.exceptions.fertilizer.FertilizerNotFound;

public class FertilizerTypeNotFound extends Exception{

    public FertilizerTypeNotFound(String message){
        super(message);
    }
}
