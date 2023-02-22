package at.itkolleg.growmanager.controller;

import at.itkolleg.growmanager.domain.PlantType;
import at.itkolleg.growmanager.exceptions.DuplicatedPlantTypeException;
import at.itkolleg.growmanager.exceptions.PlantTypeNotFound;
import at.itkolleg.growmanager.services.PlantTypeService;
import at.itkolleg.growmanager.services.PlantTypeServiceImpl;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/growmanager/v1/plantTypes")
public class PlantTypeThymeleafController {

    private PlantTypeService plantTypeService;

    public PlantTypeThymeleafController(PlantTypeService plantTypeService) {
        this.plantTypeService = plantTypeService;
    }

    @GetMapping
    public String getAllPlantTypes(Model model) {
        model.addAttribute("allPlantTypes", this.plantTypeService.allPlantTypes());
        return "allPlantTypes";
    }

    @GetMapping("/insert")
    public String insertPlantTypeForm(Model model) {
        PlantType plantType = new PlantType();
        model.addAttribute("plantType", plantType);
        return "insertPlantType";
    }

    @PostMapping("/insert")
    public String insertPlantType(@Valid PlantType plantType, BindingResult bindingResult, Model model) {
        try {
            if(bindingResult.hasErrors()) {
                return "insertPlantType";
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
            return "updatePlantType";
        } catch (PlantTypeNotFound plantTypeNotFound) {
            model.addAttribute("error", plantTypeNotFound.getMessage());
            return "error";
        }
    }

    @PostMapping("/update")
    public String updatePlantType(@Valid PlantType plantType, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "updatePlantType";
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
        } catch (PlantTypeNotFound plantTypeNotFound) {
            model.addAttribute("error", plantTypeNotFound.getMessage());
            return "error";
        }
    }
}
