package at.itkolleg.growmanager.controller.water;


import at.itkolleg.growmanager.domain.Fertilizer;
import at.itkolleg.growmanager.domain.Grow;
import at.itkolleg.growmanager.domain.Water;
import at.itkolleg.growmanager.exceptions.fertilizer.FertilizerNotFound;
import at.itkolleg.growmanager.exceptions.grow.GrowNotFound;
import at.itkolleg.growmanager.exceptions.water.DuplicatedWaterException;
import at.itkolleg.growmanager.exceptions.water.WaterNotFound;
import at.itkolleg.growmanager.services.fertilizer.FertilizerService;
import at.itkolleg.growmanager.services.grow.GrowService;
import at.itkolleg.growmanager.services.water.WaterService;
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
@RequestMapping("/growmanager/v1/waters")
public class WaterThymeLeafController {

    private WaterService waterService;

    private GrowService growService;

    private FertilizerService fertilizerService;

    public WaterThymeLeafController(WaterService waterService, GrowService growService, FertilizerService fertilizerService){
        this.waterService = waterService;
        this.growService = growService;
        this.fertilizerService = fertilizerService;
    }

    @GetMapping
    public String getAllWaters(Model model){
        model.addAttribute("allWaters", this.waterService.allWaters());
        return "water/allWaters";
    }

    @GetMapping("/{id}")
    public String getAllWatersForGrow(@PathVariable Long id, Model model){
        try {
            List<Water> watersForGrow = this.waterService.allWatersWithGrows(this.growService.growWithId(id));
            model.addAttribute("watersForGrows", watersForGrow);
            model.addAttribute("growId", id);
            return "water/allWatersForGrow";
        } catch (GrowNotFound e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }

    @GetMapping("/insert/{id}")
    public String insertWaterFormForGrow(@PathVariable Long id, Model model){
        try {
            Water water = new Water();
            water.setGrow(this.growService.growWithId(id));
            model.addAttribute("water", water);
            List<Fertilizer> listFertilizer = this.fertilizerService.allFertilizer();
            model.addAttribute("allFertilizers", listFertilizer);
            return "water/insertWater";
        } catch (GrowNotFound e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }



    @GetMapping("/insert")
    public String insertWaterForm(Model model){
        Water water = new Water();
        model.addAttribute("water", water);
        List<Grow> allGrows = this.growService.allGrows();
        model.addAttribute("allGrows", allGrows);
        List<Fertilizer> listFertilizer = this.fertilizerService.allFertilizer();
        model.addAttribute("allFertilizers", listFertilizer);
        return "water/insertWater";
    }



    @PostMapping("/insert")
    public String insertWater(@Valid Water water, BindingResult bindingResult, Model model){
        try{
            if(bindingResult.hasErrors()){
                return "water/insertWater";
            } else {
                Fertilizer fertilizer = this.fertilizerService.fertilizerWithId(water.getFertilizer().getId());
                water.setDosageFertilizer(fertilizer.getDosage() * water.getAmountOfWater());
                this.waterService.insertWater(water);
                return "redirect:/growmanager/v1/waters";
            }
        } catch (FertilizerNotFound | DuplicatedWaterException e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }

    @GetMapping("/update/{id}")
    public String updateWaterForm(@PathVariable Long id, Model model){
        try {
            Water water = this.waterService.waterWithId(id);
            model.addAttribute("water", water);
            return "water/updateWater";
        } catch (WaterNotFound e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }

    @PostMapping("/update")
    public String updateWater(@Valid Water water, BindingResult bindingResult, Model model){
        try{
            if(bindingResult.hasErrors()){
                return "water/updateWater";
            } else {
                this.waterService.updateWater(water);
                return "redirect:/growmanager/v1/waters";
            }
        }catch(WaterNotFound | DuplicatedWaterException e){
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteRepot(@PathVariable Long id, Model model){
        try{
            this.waterService.deleteWaterWithId(id);
            return "redirect:/growmanager/v1/waters";
        }catch(WaterNotFound e){
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }


}
