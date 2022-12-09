package mk.finki.dians.dians_project.exceptions;

public class UsernameAlreadyExistsException extends RuntimeException {
    public UsernameAlreadyExistsException() {
        super("This username already exists");
    }
}