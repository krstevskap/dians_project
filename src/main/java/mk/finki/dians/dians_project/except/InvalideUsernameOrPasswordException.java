package mk.finki.dians.dians_project.except;

public class InvalideUsernameOrPasswordException extends RuntimeException {
    public InvalideUsernameOrPasswordException() {
        super("Invalid username or password. Username or password mus be filled out ");
    }
}