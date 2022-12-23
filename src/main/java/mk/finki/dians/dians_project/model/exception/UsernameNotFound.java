package mk.finki.dians.dians_project.model.exception;

public class UsernameNotFound extends RuntimeException{

    public UsernameNotFound(String username) {
        super(String.format("This %s username already exists",username));
    }
}
