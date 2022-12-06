package mk.finki.dians.dians_project.repository;

import mk.finki.dians.dians_project.bootstrap.DataHolder;
import mk.finki.dians.dians_project.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {

    public List<User> findAllUsers(){
        return DataHolder.users;
    }

    public Optional<User> findByUsername(String username){
        return DataHolder.users.stream().filter(user->user.getUsername().equals(username)).findFirst();
    }


}
