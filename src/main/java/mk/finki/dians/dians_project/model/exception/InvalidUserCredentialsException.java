package mk.finki.dians.dians_project.model.exception;

public class InvalidUserCredentialsException extends RuntimeException {
    public InvalidUserCredentialsException() {
        super("Username or password not valid. Please try again");

    }
}
