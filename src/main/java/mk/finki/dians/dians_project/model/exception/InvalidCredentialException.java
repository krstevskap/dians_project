package mk.finki.dians.dians_project.model.exception;

public class InvalidCredentialException extends RuntimeException {
    public InvalidCredentialException() {
        super("Can not log in. Please fill in the form");
    }
}
