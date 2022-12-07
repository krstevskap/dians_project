package mk.finki.dians.dians_project.service;

import mk.finki.dians.dians_project.model.User;
import mk.finki.dians.dians_project.repository.UserRepository;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> listAllUsers() {
        return userRepository.findAllUsers();
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }


    @Override
    public void deleteUser(String username) {
        userRepository.delete(username);
    }

    @Override
    public User save(String name, String surname, String username, String password, String email) {
        return userRepository.save(name, surname, username, password, email);
    }
}
