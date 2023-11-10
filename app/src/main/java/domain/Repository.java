package domain;

import domain.entety.User;

public interface Repository {
    User loadUser();
    boolean saveUser(User user);
}
