package at.itkolleg.growmanager.controller.benutzer;

import at.itkolleg.growmanager.domain.Benutzer;
import at.itkolleg.growmanager.exceptions.benutzer.BenutzerNotFound;
import at.itkolleg.growmanager.exceptions.benutzer.DuplicatedBenutzerException;
import at.itkolleg.growmanager.services.benutzer.BenutzerService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;


@Controller
@RequestMapping("/growmanager")
public class BenutzerThymeleafController {

    private BenutzerService benutzerService;

    public BenutzerThymeleafController(BenutzerService userService) {
        this.benutzerService = userService;
    }

    @GetMapping("/allUsers")
    public String getAllUser(Model model) {
        model.addAttribute("allUser", this.benutzerService.allBenutzer());
        return "user/allUser";
    }

    @GetMapping
    public String userLoginForm(Model model) {
        Benutzer user = new Benutzer();
        model.addAttribute("user", user);
        return "user/login";
    }


    @PostMapping("/login")
    public String userLogin(@Valid Benutzer benutzer, Model model) {
        try {
            if(this.benutzerService.isBenutzerAlreadyInDb(benutzer)) {
                return "redirect:/growmanager/v1";
            } else {
                return "user/login";
            }
        } catch (BenutzerNotFound e) {
            model.addAttribute("error", e.getMessage());
            String meldung = "Benutzer unbekannt. Bitte überprüfen Sie Ihre " +
                    "Zugangsdaten oder führen Sie eine Regestrierung durch!";
            model.addAttribute("meldung", meldung);
            return "error";
        }
    }

    @GetMapping("/login/insert")
    public String insertBenutzerForm(Model model) {
        Benutzer benutzer = new Benutzer();
        model.addAttribute("benutzer", benutzer);
        return "user/insertBenutzer";
    }

    @PostMapping("/login/insert")
    public String insertBenutzer(@Valid Benutzer benutzer, BindingResult bindingResult, Model model) {
        try {
            if(bindingResult.hasErrors()) {
                return "user/insertBenutzer";
            } else {
                this.benutzerService.insertBenutzer(benutzer);
                return "redirect:/growmanager";
            }
        } catch (DuplicatedBenutzerException e) {
            model.addAttribute("error", e.getMessage());
            String meldung = "Benutzer kann nicht eingefügt werden!";
            model.addAttribute("meldung", meldung);
            return "error";
        }
    }
}
