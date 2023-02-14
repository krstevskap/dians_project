package mk.finki.dians.dians_project.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("logout")
public class Logout {

    @GetMapping
    public String logOut (HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/login";
    }
}
