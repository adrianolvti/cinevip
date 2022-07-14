package br.edu.ifrs.restinga.cinevip.services.interfaces;

import java.util.List;
import java.util.Optional;

import br.edu.ifrs.restinga.cinevip.models.User;

public interface UserServiceInterface {
    void save(User user);

    List<User> findAll();

    Optional<User> findById(int id);
    
    void update(User user, int id);
}
