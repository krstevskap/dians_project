package mk.finki.dians.dians_project.servic.impl;

import mk.finki.dians.dians_project.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> listAllUsers();

    Optional<User> findByUsername(String username);

    User register(String username, String password, String repeatPassword, String name, String surname);
    void deleteUser(String username);


}
