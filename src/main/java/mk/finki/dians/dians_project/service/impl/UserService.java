package mk.finki.dians.dians_project.service.impl;

import mk.finki.dians.dians_project.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface UserService  extends UserDetailsService {




      User register(String name, String surname, String username, String password,String confirmPassword, String email);

      User login(String username, String password);


//    void deleteUser(String username);


}
