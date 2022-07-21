package br.edu.ifrs.restinga.cinevip.services.interfaces;

import java.util.List;
import java.util.Optional;

import br.edu.ifrs.restinga.cinevip.models.User;

public interface UserServiceInterface {
    public void save(User user);

    public List<User> findAll();

    public Optional<User> findById(Long id);
    
    public void update(User user, Long id);

    public void deleteById(Long id);
}
