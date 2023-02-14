package mk.finki.dians.dians_project.service.impl;

import mk.finki.dians.dians_project.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;
public interface UserService  extends UserDetailsService {
      User register(String username, String password, String name, String surname,String confirmPassword, String email);
      User login(String username, String password);

}
