package mk.finki.dians.dians_project.web.controller;

import mk.finki.dians.dians_project.exception.InvalidUsernameOrPasswordException;
import mk.finki.dians.dians_project.exception.PasswordsDoNotMatchException;
import mk.finki.dians.dians_project.exception.UsernameAlreadyExistsException;
import mk.finki.dians.dians_project.service.impl.AuthService;
import mk.finki.dians.dians_project.service.impl.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/register")
public class Register {

    private final AuthService authService;
    private final UserService userService;

    public Register(AuthService authService, UserService userService) {
        this.authService = authService;
        this.userService = userService;
    }

    @GetMapping
    public String getRegisterPage(@RequestParam(required = false) String error, Model model) {
        if (error == null || error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        return "register";

    }

    @PostMapping
    public String register(@RequestParam String name,
                           @RequestParam String surname,
                           @RequestParam String email,
                           @RequestParam String username,
                           @RequestParam String password,
                           @RequestParam String confirmPassword) {
        try {
            this.userService.register(name, surname, username, password, confirmPassword, email);
            return "redirect:/login";

        } catch (InvalidUsernameOrPasswordException | PasswordsDoNotMatchException | UsernameAlreadyExistsException exception) {

            return "redirect:/register?error=" + exception.getMessage();
        }

    }
}
