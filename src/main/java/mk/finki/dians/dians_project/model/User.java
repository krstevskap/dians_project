package mk.finki.dians.dians_project.model;

import lombok.Data;

@Data
public class User {
    private String name;
    private String surname;
    private String username;
    private String password;
    private String email;

    public User(String name, String surname, String username, String password, String email) {
        this.name = name;
        this.surname=surname;
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
