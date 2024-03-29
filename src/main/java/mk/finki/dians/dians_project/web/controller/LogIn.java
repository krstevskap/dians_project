package mk.finki.dians.dians_project.web.controller;

import mk.finki.dians.dians_project.model.exception.InvalidUserCredentialsException;
import mk.finki.dians.dians_project.model.User;
import mk.finki.dians.dians_project.service.impl.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/login")
public class LogIn {

    private final UserService userService;

    public LogIn(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getLogInPage() {
        return "logIn";
    }

    @PostMapping
    public String login(HttpServletRequest request, Model model) {

        try {
            User user = this.userService.login(request.getParameter("username"), request.getParameter("password"));
            request.getSession().setAttribute("user", user);
            return "redirect:/home/maps";

        }catch (InvalidUserCredentialsException exception) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", exception.getMessage());
            return "logIn";

        }
    }
}
