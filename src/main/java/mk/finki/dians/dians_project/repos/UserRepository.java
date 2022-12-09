package mk.finki.dians.dians_project.repos;

import mk.finki.dians.dians_project.bootstrap.DataHolder;
import mk.finki.dians.dians_project.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {

    public List<User> findAllUsers() {
        return DataHolder.users;
    }

    public Optional<User> findByUsernameOrPassword(String username,String password) {
        return DataHolder.users.stream().filter(user -> user.getUsername().equals(username) && user.getPassword().equals(password)).findFirst();
    }

    public Optional<User> findByUsername(String username) {
        return DataHolder.users.stream().filter(user -> user.getUsername().equals(username)).findFirst();
    }
    public User save(String name, String surname, String username, String password, String email) {
        DataHolder.users.removeIf(user -> user.getUsername().equals(username));
        User u = new User(name, surname, username, password, email);
        DataHolder.users.add(u);
        return u;
    }

    public Optional<User> saveUser(String name, String surname, String username, String password, String email) {
        DataHolder.users.removeIf(user -> user.getUsername().equals(username));
        User u = new User(name, surname, username, password, email);
        DataHolder.users.add(u);
        return Optional.of(u);
    }

    public void delete(String username) {
        DataHolder.users.removeIf(user -> user.getUsername().equals(username));
    }
}
