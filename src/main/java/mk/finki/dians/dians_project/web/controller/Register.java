package mk.finki.dians.dians_project.web.controller;

import mk.finki.dians.dians_project.model.exception.InvalidUsernameOrPasswordException;
import mk.finki.dians.dians_project.model.exception.PasswordsDoNotMatchException;
import mk.finki.dians.dians_project.model.exception.UsernameAlreadyExistsException;
import mk.finki.dians.dians_project.service.impl.AuthService;
import mk.finki.dians.dians_project.service.impl.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/register")
public class Register {

    private final UserService userService;

    public Register(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getRegisterPage(@RequestParam(required = false) String error, Model model) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        return "register";

    }

    @PostMapping
    public String register(@RequestParam String name,
                           @RequestParam String surname,
                           @RequestParam String username,
                           @RequestParam String email,
                           @RequestParam String password,
                           @RequestParam String confirmPass) {
        try {
            this.userService.register(username, password, name, surname, confirmPass, email);
            return "redirect:/login";

        } catch (InvalidUsernameOrPasswordException | PasswordsDoNotMatchException | UsernameAlreadyExistsException exception) {

            return "redirect:/register?error=" + exception.getMessage();
        }

    }
}
