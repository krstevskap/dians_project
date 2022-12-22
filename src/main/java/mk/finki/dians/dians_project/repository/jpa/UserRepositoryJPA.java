package mk.finki.dians.dians_project.repository.jpa;

import mk.finki.dians.dians_project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepositoryJPA extends JpaRepository<User,String> {

    Optional<User> findByUsername(String username);

    Optional<User> findByUsernameOrPassword(String username, String password);
}

