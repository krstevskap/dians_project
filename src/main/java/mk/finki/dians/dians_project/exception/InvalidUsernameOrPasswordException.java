package mk.finki.dians.dians_project.exception;

public class InvalidUsernameOrPasswordException extends RuntimeException {
    public InvalidUsernameOrPasswordException() {
        super("Invalid username or password. Username or password must be filled out ");
    }
}
