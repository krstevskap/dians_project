package mk.finki.dians.dians_project.model.exception;

public class UsernameAlreadyExistsException extends RuntimeException {
    public UsernameAlreadyExistsException(String username) {
        super(String.format("This %s username already exists",username));
    }
}