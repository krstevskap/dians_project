package mk.finki.dians.dians_project;

import mk.finki.dians.dians_project.model.User;
import mk.finki.dians.dians_project.model.exception.InvalidUsernameOrPasswordException;
import mk.finki.dians.dians_project.model.exception.PasswordsDoNotMatchException;
import mk.finki.dians.dians_project.model.exception.UsernameAlreadyExistsException;
import mk.finki.dians.dians_project.repository.jpa.UserRepositoryJPA;
import mk.finki.dians.dians_project.service.UserServiceImpl;
import mk.finki.dians.dians_project.service.impl.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.crypto.password.PasswordEncoder;

@RunWith(MockitoJUnitRunner.class)
public class UserRegistrationTest {

    @Mock
    private UserRepositoryJPA userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private UserService userService;


    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        User user = new User("username", "password", "name", "surname","email");
        Mockito.when(this.userRepository.save(Mockito.any(User.class))).thenReturn(user);
        Mockito.when(this.passwordEncoder.encode(Mockito.anyString())).thenReturn("password");


        this.userService = Mockito.spy(new UserServiceImpl(this.userRepository, this.passwordEncoder));
    }

    @Test
    public void testSuccessRegister() throws PasswordsDoNotMatchException, UsernameAlreadyExistsException, InvalidUsernameOrPasswordException {
        User user = this.userService.register("username", "password", "name", "surname", "password", "email");

        Mockito.verify(this.userService).register("username", "password", "name", "surname", "password", "email");
        System.out.println(user);


        Assert.assertNotNull("User is null", user);
        Assert.assertEquals("name do not mach", "name", user.getName());
        Assert.assertEquals("surname do not mach", "surname", user.getSurname());
        Assert.assertEquals("password do not mach", "password", user.getPassword());
        Assert.assertEquals("username do not mach", "username", user.getUsername());
    }


    @Test
    public void testNullUsername() throws PasswordsDoNotMatchException, UsernameAlreadyExistsException, InvalidUsernameOrPasswordException {
        Assert.assertThrows("InvalidArgumentException expected",
                InvalidUsernameOrPasswordException.class,
                () ->this.userService.register(null, "password", "name", "surname", "confirmPassword", "email"));
        Mockito.verify(this.userService).register(null, "password", "name", "surname", "confirmPassword", "email");

    }

    @Test
    public void testEmptyUsername() throws PasswordsDoNotMatchException, UsernameAlreadyExistsException, InvalidUsernameOrPasswordException {
        String username = "";
        Assert.assertThrows("InvalidArgumentException expected",
                InvalidUsernameOrPasswordException.class,
                () -> this.userService.register(username, "password","password", "surname", "confirmPassword", "email"));
        Mockito.verify(this.userService).register(username, "password","password", "surname", "confirmPassword", "email");
    }


}