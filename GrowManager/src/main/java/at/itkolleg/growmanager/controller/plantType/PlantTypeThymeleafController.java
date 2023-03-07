package at.itkolleg.growmanager.controller.plantType;

import at.itkolleg.growmanager.domain.PlantType;
import at.itkolleg.growmanager.exceptions.plantType.DuplicatedPlantTypeException;
import at.itkolleg.growmanager.exceptions.plantType.PlantTypeNotFound;
import at.itkolleg.growmanager.services.plantType.PlantTypeService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/growmanager/v1/plantTypes")
public class PlantTypeThymeleafController {

    private PlantTypeService plantTypeService;

    public PlantTypeThymeleafController(PlantTypeService plantTypeService) {
        this.plantTypeService = plantTypeService;
    }

    @GetMapping
    public String getAllPlantTypes(Model model) {
        model.addAttribute("plantTypes", this.plantTypeService.allPlantTypes());
        return "plantType/allPlantTypes";
    }

    /*@GetMapping
    public String showPlantTypesPage(Model model, @PageableDefault(size = 5) Pageable pageable) {
        Page<PlantType> page = this.plantTypeService.allPlantTypes(pageable);
        List<PlantType> plantTypes = page.getContent();

        model.addAttribute("plantTypes", plantTypes);
        model.addAttribute("currentPage", page.getNumber());
        model.addAttribute("totalPages", page.getTotalPages());

        return "plantType/allPlantTypes";
    }*/

    @GetMapping("/insert")
    public String insertPlantTypeForm(Model model) {
        PlantType plantType = new PlantType();
        model.addAttribute("plantType", plantType);
        return "plantType/insertPlantType";
    }

    @PostMapping("/insert")
    public String insertPlantType(@Valid PlantType plantType, BindingResult bindingResult, Model model) {
        try {
            if(bindingResult.hasErrors()) {
                return "plantType/insertPlantType";
            } else {
                this.plantTypeService.insertPlantType(plantType);
                return "redirect:/growmanager/v1/plantTypes";
            }
        } catch (DuplicatedPlantTypeException e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }

    }

    @GetMapping("/update/{id}")
    public String updatePlantTypeForm(@PathVariable Long id, Model model) {
        try {
            PlantType plantType = this.plantTypeService.plantTypeWithId(id);
            model.addAttribute("plantType", plantType);
            return "plantType/updatePlantType";
        } catch (PlantTypeNotFound plantTypeNotFound) {
            model.addAttribute("error", plantTypeNotFound.getMessage());
            return "error";
        }
    }

    @PostMapping("/update")
    public String updatePlantType(@Valid PlantType plantType, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "plantType/updatePlantType";
        } else {
            try {
                this.plantTypeService.updatePlantType(plantType);
                return "redirect:/growmanager/v1/plantTypes";
            } catch (Exception e) {
                return "redirect:/growmanager/v1/plantTypes";
            }
        }
    }

    @GetMapping("/delete/{id}")
    public String deletePlantType(@PathVariable Long id, Model model) {
        try {
            this.plantTypeService.deletePlantTypeWithId(id);
            return "redirect:/growmanager/v1/plantTypes";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            String meldung = "Pflanzentyp kann nicht gelöscht werden, solange er einer Pflanze zugeordnet ist!";
            model.addAttribute("meldung", meldung);
            return "error";
        }
    }
}
