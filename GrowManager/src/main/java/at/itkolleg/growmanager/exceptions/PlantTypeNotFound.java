package at.itkolleg.growmanager.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


public class PlantTypeNotFound extends Exception {
    public PlantTypeNotFound(String message) {
        super(message);
    }
}
