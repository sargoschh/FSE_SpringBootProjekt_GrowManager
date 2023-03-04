package at.itkolleg.growmanager.controller.fertilizer;


import at.itkolleg.growmanager.services.fertilizer.FertilizerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/growmanger/v1/fertilizers")
public class FertilizerThymeleafController {

    private FertilizerService fertilizerService;

    //private FertilizerTypeService fertilizerTypeService;

}
