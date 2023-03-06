package at.itkolleg.growmanager.controller.user;

import at.itkolleg.growmanager.domain.User;
import at.itkolleg.growmanager.exceptions.user.UserNotFound;
import at.itkolleg.growmanager.services.user.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/growmanager")
public class UserThymeleafController {

    private UserService userService;

    public UserThymeleafController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String userLoginForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "user/login";
    }

    @PostMapping("/login")
    public String userLogin(@Valid User user, Model model) {
        try {
            if(this.userService.isUserAlreadyInDb(user)) {
                return "redirect:/growmanager/v1";
            } else {
                return "user/login";
            }
        } catch (UserNotFound e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }
}
