package at.itkolleg.growmanager.controller.plant;

import at.itkolleg.growmanager.domain.Plant;
import at.itkolleg.growmanager.domain.PlantType;
import at.itkolleg.growmanager.exceptions.plant.DuplicatedPlantException;
import at.itkolleg.growmanager.exceptions.plant.PlantNotFound;
import at.itkolleg.growmanager.services.plant.PlantService;
import at.itkolleg.growmanager.services.plantType.PlantTypeService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/growmanager/v1/plants")
public class PlantThymeleafController {

    private PlantService plantService;
    private PlantTypeService plantTypeService;

    public PlantThymeleafController(PlantService plantService, PlantTypeService plantTypeService) {
        this.plantService = plantService;
        this.plantTypeService = plantTypeService;
    }

    @GetMapping
    public String getAllPlants(Model model) {
        model.addAttribute("allPlants", this.plantService.allPlants());
        return "plant/allPlants";
    }

    @GetMapping("/insert")
    public String insertPlantForm(Model model) {
        Plant plant = new Plant();
        model.addAttribute("plant", plant);
        return "plant/insertPlant";
    }

    @PostMapping("/insert")
    public String insertPlant(@Valid Plant plant, BindingResult bindingResult, Model model) {
        try {
            if(bindingResult.hasErrors()) {
                return "plant/insertPlant";
            } else {
                //Plant plant1 = new Plant(plant.getName(), plant.getType(), plant.getGrowthPeriod());
                this.plantService.insertPlant(plant);
                return "redirect:/growmanager/v1/plants";
            }
        } catch (DuplicatedPlantException e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }

    /*@GetMapping("/update/{id}")
    public String updatePlantForm(@PathVariable Long id, Model model) {
        try {
            Plant plant = this.plantService.plantWithId(id);
            model.addAttribute("plant", plant);
            List<PlantType> plantTypes = this.plantTypeService.allPlantTypes();
            model.addAttribute("plantTypes", plantTypes);
            return "plant/updatePlant";
        } catch (PlantNotFound plantNotFound) {
            model.addAttribute("error", plantNotFound.getMessage());
            return "error";
        }
    }*/

    @PostMapping("/update")
    public String updatePlant(@Valid Plant plant, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "plant/updatePlant";
        } else {
            try {
                this.plantService.updatePlant(plant);
                return "redirect:/growmanager/v1/plants";
            } catch (Exception e) {
                return "redirect:/growmanager/v1/plants";
            }
        }
    }

    @GetMapping("/delete/{id}")
    public String deletePlant(@PathVariable Long id, Model model) {
        try {
            this.plantService.deletePlantWithId(id);
            return "redirect:/growmanager/v1/plants";
        } catch (PlantNotFound plantNotFound) {
            model.addAttribute("error", plantNotFound.getMessage());
            return "error";
        }
    }
}
