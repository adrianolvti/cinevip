package br.edu.ifrs.restinga.cinevip.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import br.edu.ifrs.restinga.cinevip.models.User;

public interface UserRepository extends CrudRepository<User, String>{
    Optional<User> findById(int id);
    
    Optional<User> save(Optional<User> user);
}
