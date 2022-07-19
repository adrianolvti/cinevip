package br.edu.ifrs.restinga.cinevip.services.interfaces;

import java.util.List;
import java.util.Optional;

import br.edu.ifrs.restinga.cinevip.models.User;

public interface UserServiceInterface {
    public void save(User user);

    public List<User> findAll();

    public Optional<User> findById(int id);
    
    public void update(User user, int id);

    public void deleteById(int id);
}
