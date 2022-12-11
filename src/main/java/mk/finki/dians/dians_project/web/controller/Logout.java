package mk.finki.dians.dians_project.web.controller;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("logout")
public class Logout {

    @GetMapping
    public String logOut (HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/login";
    }
}
