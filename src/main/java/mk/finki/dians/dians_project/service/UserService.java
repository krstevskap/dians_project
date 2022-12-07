package mk.finki.dians.dians_project.service;

import mk.finki.dians.dians_project.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> listAllUsers();

    Optional<User> findByUsername(String username);

//    User addUser(String name,String surname, String username, String password, String email);

//    Optional<User> addUser(String name, String surname, String username, String password, String email);

    void deleteUser(String username);

    User save(String name, String surname, String username, String password, String email);

}
