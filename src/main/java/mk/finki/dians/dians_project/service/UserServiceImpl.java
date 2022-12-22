package mk.finki.dians.dians_project.service;

import mk.finki.dians.dians_project.model.exception.*;
import mk.finki.dians.dians_project.model.User;
import mk.finki.dians.dians_project.repository.jpa.UserRepositoryJPA;
import mk.finki.dians.dians_project.service.impl.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepositoryJPA userRepository;
    private final PasswordEncoder passwordEncoder;


    public UserServiceImpl(UserRepositoryJPA userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }



    @Override
    public User register(String name, String surname, String username, String password, String confirmPassword, String email) {
        if (username == null || username.isEmpty() || password == null || password.isEmpty())
            throw new InvalidUsernameOrPasswordException();
        if (!password.equals(confirmPassword))
            throw new PasswordsDoNotMatchException();
        if (this.userRepository.findByUsername(username).isPresent())
            throw new UsernameAlreadyExistsException(username);
       User u = new User(name, surname, username, passwordEncoder.encode(password), email);
        return this.userRepository.save(u);
    }

    @Override
    public User login(String username, String password) {
        if( username==null || username.isEmpty() || password==null || password.isEmpty()){
            throw new InvalidCredentialException();
        }
        return userRepository.findByUsernameOrPassword(username,password).orElseThrow(InvalidUserCredentialsException::new);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElseThrow(()-> new
                UsernameNotFoundException(username));
    }
}
