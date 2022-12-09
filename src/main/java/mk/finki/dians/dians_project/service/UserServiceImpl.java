package mk.finki.dians.dians_project.service;

import mk.finki.dians.dians_project.exceptions.InvalideUsernameOrPasswordException;
import mk.finki.dians.dians_project.exceptions.PasswordsDoNotMatchException;
import mk.finki.dians.dians_project.exceptions.UsernameAlreadyExistsException;
import mk.finki.dians.dians_project.model.User;
import mk.finki.dians.dians_project.repository.UserRepository;
import mk.finki.dians.dians_project.service.impl.UserService;

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
    public User register(String username, String password, String repeatPassword, String name, String surname) {
        if (username==null|| username.isEmpty() || password==null || password.isEmpty())
         throw new InvalideUsernameOrPasswordException();
        if(!password.equals(repeatPassword))
         throw new PasswordsDoNotMatchException();
        if(this.userRepository.findByUsername(username).isPresent())
         throw new UsernameAlreadyExistsException();
        return userRepository.save(username, password, repeatPassword, name, surname);
    }
}
