package br.edu.ifrs.restinga.cinevip.services;

import java.util.Optional;

import br.edu.ifrs.restinga.cinevip.models.User;

public interface UserServiceInterface {
    Optional<User> findById(int id);
}
