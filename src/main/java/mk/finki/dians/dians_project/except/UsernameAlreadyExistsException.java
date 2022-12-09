package mk.finki.dians.dians_project.except;

public class UsernameAlreadyExistsException extends RuntimeException {
    public UsernameAlreadyExistsException() {
        super("This username already exists");
    }
}