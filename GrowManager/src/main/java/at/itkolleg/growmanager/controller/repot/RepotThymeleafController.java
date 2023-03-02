package at.itkolleg.growmanager.controller.repot;

import at.itkolleg.growmanager.domain.Repot;
import at.itkolleg.growmanager.exceptions.grow.GrowNotFound;
import at.itkolleg.growmanager.services.grow.GrowService;
import at.itkolleg.growmanager.services.repot.RepotService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/growmanager/v1/repots")
public class RepotThymeleafController {

    private RepotService repotService;

    private GrowService growService;

    public RepotThymeleafController(RepotService repotService, GrowService growService) {
        this.repotService = repotService;
        this.growService = growService;
    }

    @GetMapping
    public String getAllRepots(Model model) {
        model.addAttribute("allRepots", this.repotService.allRepots());
        return "repot/allRepots";
    }

    @GetMapping("/{id}")
    public String getAllRepotsForGrow(@PathVariable Long id, Model model) {
        try {
            List<Repot> repotsForGrow = this.repotService.allRepotsWithGrows(this.growService.growWithId(id));
            model.addAttribute("repotsForGrows", repotsForGrow);
            return "repot/allRepotsForGrow";
        } catch (GrowNotFound e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    //<i class="material-icons eco">&#xea35;</i>
    //<i class="material-icons cloudy_snowing">&#xe810;</i>
    }
}
