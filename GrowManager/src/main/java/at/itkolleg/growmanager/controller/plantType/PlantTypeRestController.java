package at.itkolleg.growmanager.controller.plantType;

import at.itkolleg.growmanager.domain.PlantType;
import at.itkolleg.growmanager.exceptions.FormValidationExceptionDTO;
import at.itkolleg.growmanager.exceptions.plantType.DuplicatedPlantTypeException;
import at.itkolleg.growmanager.exceptions.plantType.PlantTypeNotFound;
import at.itkolleg.growmanager.exceptions.plantType.PlantTypeValidationFailed;
import at.itkolleg.growmanager.services.plantType.PlantTypeService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/growmanager/v1/plantTypes")
//Erlaubt alle Anfragen von 127.0.0.1:5500!
@CrossOrigin(origins = {"http://127.0.0.1:5500", "http://localhost:5500"})
public class PlantTypeRestController {

    private PlantTypeService plantTypeService;

    public PlantTypeRestController(PlantTypeService plantTypeService) {
        this.plantTypeService = plantTypeService;
    }

    @GetMapping
    //CURL-Call zum Testen: curl -H "Accept: application/json" localhost:8080/api/v1/studenten
    public ResponseEntity<List<PlantType>> gibAlleStudenten() {
        return ResponseEntity.ok(this.plantTypeService.allPlantTypes());
    }

    @PostMapping
    //CURL-Call zum Testen: curl -X POST -H "Accept: application/json" -H "Content-Type: application/json" -d '{"name":"Günter Hasi 2","plz":"3322"}' http://localhost:8080/api/v1/studenten
    public ResponseEntity<PlantType> insertPlantType(@Valid @RequestBody PlantType plantType, BindingResult bindingResult) throws PlantTypeValidationFailed, DuplicatedPlantTypeException {
        //    String errors = "";
        FormValidationExceptionDTO formValidationErrors = new FormValidationExceptionDTO("9000");

        if (bindingResult.hasErrors()) {
            for (ObjectError error : bindingResult.getAllErrors()) {
                formValidationErrors.addFormValidationError(((FieldError) error).getField(), error.getDefaultMessage());
            }
            throw new PlantTypeValidationFailed(formValidationErrors);
        } else {
            System.out.println("NAME: " + plantType.getName());
            return ResponseEntity.ok(this.plantTypeService.insertPlantType(plantType));
        }
    }

    @PutMapping
    //CURL-Call zum Testen: curl -X PUT -H "Accept: application/json" -H "Content-Type: application/json" -d '{"name":"Günter Hasi","plz":"3322"}' http://localhost:8080/api/v1/studenten
    public ResponseEntity<PlantType> updatePlantType(@Valid @RequestBody PlantType plantType, BindingResult bindingResult) throws PlantTypeValidationFailed, PlantTypeNotFound, DuplicatedPlantTypeException {
        //    String errors = "";
        FormValidationExceptionDTO formValidationErrors = new FormValidationExceptionDTO("9000");

        if (plantType.getId() == null)
            throw new PlantTypeNotFound("PlantType-Update mit PlantType ohne ID nicht möglich!");

        if (bindingResult.hasErrors()) {
            for (ObjectError error : bindingResult.getAllErrors()) {
                formValidationErrors.addFormValidationError(((FieldError) error).getField(), error.getDefaultMessage());
            }
            throw new PlantTypeValidationFailed(formValidationErrors);
        } else {
            return ResponseEntity.ok(this.plantTypeService.updatePlantType(plantType));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PlantType> deletePlantType(@PathVariable Long id) throws PlantTypeNotFound {
        return ResponseEntity.ok(this.plantTypeService.deletePlantTypeWithId(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlantType> plantTypeWithId(@PathVariable Long id) throws PlantTypeNotFound {
        return ResponseEntity.ok(this.plantTypeService.plantTypeWithId(id));
    }
}
