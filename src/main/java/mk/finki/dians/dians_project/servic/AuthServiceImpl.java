package mk.finki.dians.dians_project.servic;

import mk.finki.dians.dians_project.except.InvalidCredentialException;
import mk.finki.dians.dians_project.except.InvalidUserCredentialsException;
import mk.finki.dians.dians_project.model.User;
import mk.finki.dians.dians_project.repos.UserRepository;
import mk.finki.dians.dians_project.servic.impl.AuthService;

public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User login(String username, String password) {
      if( username==null || username.isEmpty() || password==null || password.isEmpty()){
         throw new InvalidCredentialException();
      }
      return userRepository.findByUsernameOrPassword(username,password).orElseThrow(InvalidUserCredentialsException::new);
    }
}
