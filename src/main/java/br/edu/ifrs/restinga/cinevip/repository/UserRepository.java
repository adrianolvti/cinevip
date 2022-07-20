package br.edu.ifrs.restinga.cinevip.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import br.edu.ifrs.restinga.cinevip.models.User;

public interface UserRepository extends CrudRepository<User, String> {
    public Optional<User> findById(int id);
    
    public Optional<User> save(Optional<User> user);

    public void deleteById(int id);
}
