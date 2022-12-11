package mk.finki.dians.dians_project.service.impl;

import mk.finki.dians.dians_project.model.User;

import java.util.Optional;

public interface UserService {

//    List<User> listAllUsers();

      Optional<User> findByUsername(String username);


      User register(String name, String surname, String username, String password,String confirmPassword, String email);

//    void deleteUser(String username);


}
