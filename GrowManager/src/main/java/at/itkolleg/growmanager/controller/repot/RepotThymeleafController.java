package at.itkolleg.growmanager.controller.repot;

import at.itkolleg.growmanager.domain.Grow;
import at.itkolleg.growmanager.domain.Repot;
import at.itkolleg.growmanager.exceptions.grow.GrowNotFound;
import at.itkolleg.growmanager.exceptions.repot.DuplicatedRepotException;
import at.itkolleg.growmanager.exceptions.repot.RepotNotFound;
import at.itkolleg.growmanager.services.grow.GrowService;
import at.itkolleg.growmanager.services.repot.RepotService;
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
            model.addAttribute("growId", id);
            return "repot/allRepotsForGrow";
        } catch (GrowNotFound e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }

    @GetMapping("/insert/{id}")
    public String insertRepotFormForGrow(@PathVariable Long id, Model model) {
        try {
            Repot repot = new Repot();
            repot.setGrow(this.growService.growWithId(id));
            model.addAttribute("repot", repot);
            return "repot/insertRepot";
        } catch (GrowNotFound e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }

    @GetMapping("/insert")
    public String insertRepotForm(Model model) {

        Repot repot = new Repot();
        model.addAttribute("repot", repot);
        List<Grow> allGrows = this.growService.allGrows();
        model.addAttribute("allGrows", allGrows);
        return "repot/insertRepot";
    }

    @PostMapping("/insert")
    public String insertRepot(@Valid Repot repot, BindingResult bindingResult, Model model) {
        try {
            if (bindingResult.hasErrors()) {
                return "repot/insertRepot";
            } else {
                this.repotService.insertRepot(repot);
                return "redirect:/growmanager/v1/repots/" + repot.getGrow().getId();
            }
        } catch (DuplicatedRepotException e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }

    @GetMapping("/update/{id}")
    public String updateRepotForm(@PathVariable Long id, Model model) {
        try {
            Repot repot = this.repotService.repotWithId(id);
            model.addAttribute("repot", repot);
            return "repot/updateRepot";
        } catch (RepotNotFound e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }

    @PostMapping("/update")
    public String updateRepot(@Valid Repot repot, BindingResult bindingResult, Model model) {
        try {
            if(bindingResult.hasErrors()) {
                return "repot/updateRepot";
            } else {
                this.repotService.updateRepot(repot);
                return "redirect:/growmanager/v1/repots";
            }
        } catch (RepotNotFound | DuplicatedRepotException e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteRepot(@PathVariable Long id, Model model) {
        try {
            this.repotService.deleteRepotWithId(id);
            return "redirect:/growmanager/v1/repots";
        } catch (RepotNotFound e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }
}
