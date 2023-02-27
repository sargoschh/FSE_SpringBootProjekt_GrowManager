package at.itkolleg.growmanager.controller.grow;

import at.itkolleg.growmanager.domain.Grow;
import at.itkolleg.growmanager.domain.Plant;
import at.itkolleg.growmanager.exceptions.grow.DuplicatedGrowException;
import at.itkolleg.growmanager.services.grow.GrowService;
import at.itkolleg.growmanager.services.plant.PlantService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.function.BinaryOperator;

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
                grow.setEstimatedEndDate(grow.getStartDate().plusDays(10));
                grow.setHarvested(false);
                grow.setActualEndDate(null);
                this.growService.insertGrow(grow);
                return "redirect:/growmanager/v1/grows";
            }
        } catch (DuplicatedGrowException e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }
}
