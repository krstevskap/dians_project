package mk.finki.dians.dians_project.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class UserController {

//    private final UserService userService;

//    public UserController(UserService userService) {
//        this.userService = userService;
//    }

    @GetMapping
    public String getHomepage() {
        return "home";
    }

    @GetMapping("maps")
    public String getMapPage() {
        return "maps";
    }

    @GetMapping("login")
    public String getLoginPage() {
        return "logIn";
    }

//    @GetMapping("sign")
//    public String getSignInPage(){
//        return "register";
//    }
}
