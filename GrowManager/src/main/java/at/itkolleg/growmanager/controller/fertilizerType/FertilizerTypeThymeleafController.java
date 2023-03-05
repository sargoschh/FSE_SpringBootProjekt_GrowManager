package at.itkolleg.growmanager.controller.fertilizerType;

import at.itkolleg.growmanager.domain.FertilizerType;
import at.itkolleg.growmanager.services.fertilizerType.FertilizerTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
        model.addAttribute("fertilizerTypes", this.fertilizerTypeService.allFertilizerTypes());
        return "fertilizerType/allFertilizerTypes";
    }

    @GetMapping("insert")
    public String insertFertilizerTypeForm(Model model){
        FertilizerType fertilizerType = new FertilizerType();
        model.addAttribute("fertilizerType", fertilizerType);
        return "fertilizerType/insertFertilizerType";
    }



}
