package mk.finki.dians.dians_project.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.finki.dians.dians_project.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {

    public static List<User> users = new ArrayList<>();

    @PostConstruct
    public void init() {
        users.add(new User("Tea", "Krstevska", "tea", "tk", "tea.krstevska@gmail.com"));
        users.add(new User("Darko", "Krstevski", "darko", "dk", "darko.krstevski@gmail.com"));
        users.add(new User("Angela", "Jonoska", "angela", "aj", "angela.jonoska@gmail.com"));
        users.add(new User("Petrana", "Krstevska", "petrana", "pk", "petrana.krstevska@gmail.com"));
    }
}
