package mk.finki.dians.dians_project.except;

public class InvalidUserCredentialsException extends RuntimeException {
    public InvalidUserCredentialsException() {
        super("Username or password not valid. Please try again");

    }
}
