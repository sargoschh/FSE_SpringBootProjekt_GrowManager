package at.itkolleg.growmanager.controller.fertilizer;


import at.itkolleg.growmanager.domain.Fertilizer;
import at.itkolleg.growmanager.domain.FertilizerType;
import at.itkolleg.growmanager.exceptions.fertilizer.DuplicatedFertilizerException;
import at.itkolleg.growmanager.exceptions.fertilizer.FertilizerNotFound;
import at.itkolleg.growmanager.services.fertilizer.FertilizerService;
import at.itkolleg.growmanager.services.fertilizerType.FertilizerTypeService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/growmanager/v1/fertilizers")
public class FertilizerThymeleafController {

    private FertilizerService fertilizerService;

    private FertilizerTypeService fertilizerTypeService;

    public FertilizerThymeleafController(FertilizerService fertilizerService, FertilizerTypeService fertilizerTypeService){
        this.fertilizerService = fertilizerService;
        this.fertilizerTypeService = fertilizerTypeService;
    }

    @GetMapping
    public String getAllFertilizers(Model model){
        model.addAttribute("allFertilizers", this.fertilizerService.allFertilizer());
        return "fertilizer/allFertilizers";
    }

    @GetMapping("/insert")
    public String insertFertilizerForm(Model model){
        Fertilizer fertilizer = new Fertilizer();
        model.addAttribute("fertilizer", fertilizer);
        List<FertilizerType> fertilizerTypes = this.fertilizerTypeService.allFertilizerTypes();
        model.addAttribute("fertilizerTypes", fertilizerTypes);
        return "fertilizer/insertFertilizer";
    }

    @PostMapping("/insert")
    public String insertFertilizer(@Valid Fertilizer fertilizer, BindingResult bindingResult, Model model){
        try{
            if(bindingResult.hasErrors()){
                return "fertilizer/insertFertilizer";
            }else{
                this.fertilizerService.insertFertilizer(fertilizer);
                return "redirect:/growmanager/v1/fertilizers";
            }
        }catch(DuplicatedFertilizerException e){
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }

    @GetMapping("/update/{id}")
    public String updateFertilizerForm(@PathVariable Long id, Model model){
        try {
            Fertilizer fertilizer = this.fertilizerService.fertilizerWithId(id);
            model.addAttribute("fertilizer", fertilizer);
            List<FertilizerType> fertilizerTypes = this.fertilizerTypeService.allFertilizerTypes();
            model.addAttribute("fertilizerTypes", fertilizerTypes);
            return "fertilizer/updateFertilizer";
        } catch (FertilizerNotFound e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }

    @PostMapping("/update")
    public String updateFertilizer(@Valid Fertilizer fertilizer, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "fertilizer/updateFertilzer";
        }else{
            try{
                this.fertilizerService.updateFertilizer(fertilizer);
                return "redirect:/growmanager/v1/fertilizers";
            }catch(Exception e){
                return "redirect:/growmanager/v1/fertilizers";
            }
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteFertilizer(Long id, Model model){
        try{
            this.fertilizerService.deleteFertilizerWithid(id);
            return "redirect:/growmanger/v1/fertilizers";
        }catch(FertilizerNotFound e){
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }

}
