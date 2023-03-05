package at.itkolleg.growmanager.controller.fertilizerType;

import at.itkolleg.growmanager.domain.FertilizerType;
import at.itkolleg.growmanager.exceptions.fertilizerType.DuplicatedFertilizerTypeException;
import at.itkolleg.growmanager.exceptions.fertilizerType.FertilizerTypeNotFound;
import at.itkolleg.growmanager.services.fertilizerType.FertilizerTypeService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/growmanager/v1/fertilizerTypes")
public class FertilizerTypeThymeleafController {

    private FertilizerTypeService fertilizerTypeService;

    public FertilizerTypeThymeleafController(FertilizerTypeService fertilizerTypeService){
        this.fertilizerTypeService = fertilizerTypeService;
    }

    @GetMapping
    public String getAllFertilizerTypes(Model model){
        model.addAttribute("allFertilizerTypes", this.fertilizerTypeService.allFertilizerTypes());
        return "fertilizerType/allFertilizerTypes";
    }

    @GetMapping("/insert")
    public String insertFertilizerTypeForm(Model model){
        FertilizerType fertilizerType = new FertilizerType();
        model.addAttribute("fertilizerType", fertilizerType);
        return "fertilizerType/insertFertilizerType";
    }

    @PostMapping("/insert")
    public String insertFertilizerType(@Valid FertilizerType fertilizerType, BindingResult bindingResult, Model model){
        try{
            if(bindingResult.hasErrors()){
                return "fertilizerType/insertFertilizerType";
            }else{
                this.fertilizerTypeService.insertFertilizerType(fertilizerType);
                return "redirect:/growmanager/v1/fertilizerTypes";
            }
        }catch(DuplicatedFertilizerTypeException e){
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }

    @PostMapping("/update/{id}")
    public String updatePlantTypeForm(@PathVariable Long id, Model model){
        try {
            FertilizerType fertilizerType = this.fertilizerTypeService.fertilizerTypeWithId(id);
            model.addAttribute("fertilizerType", fertilizerType);
            return "fertilizerType/updateFertilizerType";
        } catch (FertilizerTypeNotFound e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }

    @PostMapping("/update")
    public String updateFertilizerType(@Valid FertilizerType fertilizerType, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "fertilizerType/updateFertilizerType";
        }else{
            try {
                this.fertilizerTypeService.updateFertilizerType(fertilizerType);
                return "redirect:/growmanager/v1/fertilizerTypes";
            } catch (Exception e){
                return "redirect:/growmanager/v1/fertilizerTypes";
            }
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteFertilizerType(@PathVariable Long id, Model model){
        try {
            this.fertilizerTypeService.deleteFertilizerTypeWithId(id);
            return "redirect:/growmanager/v1/fertilizerTypes";
        } catch (FertilizerTypeNotFound e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }



}
