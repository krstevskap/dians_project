package mk.finki.dians.dians_project.service.impl;

import mk.finki.dians.dians_project.model.User;

public interface AuthService {
    User login(String username, String password);
}
