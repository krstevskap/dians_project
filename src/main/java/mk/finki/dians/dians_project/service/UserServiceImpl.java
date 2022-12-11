package mk.finki.dians.dians_project.service;

import mk.finki.dians.dians_project.exception.InvalidUsernameOrPasswordException;
import mk.finki.dians.dians_project.exception.PasswordsDoNotMatchException;
import mk.finki.dians.dians_project.exception.UsernameAlreadyExistsException;
import mk.finki.dians.dians_project.model.User;
import mk.finki.dians.dians_project.repository.UserRepository;
import mk.finki.dians.dians_project.service.impl.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//    @Override
//    public List<User> listAllUsers() {
//        return userRepository.findAllUsers();
//    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }


//    @Override
//    public void deleteUser(String username) {
//        userRepository.delete(username);
//    }


    @Override
    public User register(String name, String surname, String username, String password,String confirmPassword,String email) {
        if (username==null || username.isEmpty() || password==null || password.isEmpty())
         throw new InvalidUsernameOrPasswordException();
        if(!password.equals(confirmPassword))
         throw new PasswordsDoNotMatchException();
        if(this.userRepository.findByUsername(username).isPresent())
         throw new UsernameAlreadyExistsException(username);
        return userRepository.save(name,surname,username,password,email);
    }
}
