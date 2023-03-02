package at.itkolleg.growmanager.controller.grow;

import at.itkolleg.growmanager.domain.Grow;
import at.itkolleg.growmanager.domain.Plant;
import at.itkolleg.growmanager.exceptions.grow.DuplicatedGrowException;
import at.itkolleg.growmanager.exceptions.grow.GrowNotFound;
import at.itkolleg.growmanager.exceptions.plant.PlantNotFound;
import at.itkolleg.growmanager.services.grow.GrowService;
import at.itkolleg.growmanager.services.plant.PlantService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/growmanager/v1/grows")
public class GrowThymeleafController {

    private GrowService growService;

    private PlantService plantService;

    public GrowThymeleafController(GrowService growService, PlantService plantService) {
        this.growService = growService;
        this.plantService = plantService;
    }

    @GetMapping
    public String getAllGrows(Model model) {
        model.addAttribute("allGrows", this.growService.allGrows());
        return "grow/allGrows";
    }

    @GetMapping("/insert")
    public String insertGrowForm(Model model) {
        Grow grow = new Grow();
        model.addAttribute("grow", grow);
        List<Plant> plants = this.plantService.allPlants();
        model.addAttribute("plants", plants);
        return "grow/insertGrow";
    }

    @PostMapping("/insert")
    public String insertGrow(@Valid Grow grow, BindingResult bindingResult, Model model) {
        try {
            if(bindingResult.hasErrors()) {
                return "grow/insertGrow";
            } else {
                Plant plant = this.plantService.plantWithId(grow.getPlant().getId());
                grow.setEstimatedEndDate(grow.getStartDate().plusDays(plant.getGrowthPeriod()));
                grow.setHarvested(false);
                grow.setActualEndDate(null);
                this.growService.insertGrow(grow);
                return "redirect:/growmanager/v1/grows";
            }
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }

    @GetMapping("/update/{id}")
    public String updateGrowForm(@PathVariable Long id, Model model) {
        try {
            Grow grow = this.growService.growWithId(id);
            model.addAttribute("grow", grow);
            List<Plant> plants = this.plantService.allPlants();
            model.addAttribute("plants", plants);
            return "grow/updateGrow";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }

    @PostMapping("/update")
    public String updateGrow(@Valid Grow grow, BindingResult bindingResult, Model model) {
        try {
            if(bindingResult.hasErrors()) {
                return "grow/updateGrow";
            } else {
                Plant plant = this.plantService.plantWithId(grow.getPlant().getId());
                grow.setEstimatedEndDate(grow.getStartDate().plusDays(plant.getGrowthPeriod()));
                if(grow.getActualEndDate() == null && grow.getHarvested()) {
                    grow.setActualEndDate(LocalDate.now());
                }
                this.growService.insertGrow(grow);
                return "redirect:/growmanager/v1/grows";
            }
        } catch (PlantNotFound | DuplicatedGrowException e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteGrow(@PathVariable Long id, Model model) {
        try {
            this.growService.deleteGrowWithId(id);
            return "redirect:/growmanager/v1/grows";
        } catch (GrowNotFound growNotFound) {
            model.addAttribute("error", growNotFound.getMessage());
            return "error";
        }
    }
}
