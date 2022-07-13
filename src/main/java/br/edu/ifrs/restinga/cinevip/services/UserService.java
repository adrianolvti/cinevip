package br.edu.ifrs.restinga.cinevip.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifrs.restinga.cinevip.models.User;
import br.edu.ifrs.restinga.cinevip.repository.UserRepository;

@Service
public class UserService implements UserServiceInterface{
    
    @Autowired
    private UserRepository userRepository; 

    public UserService() {

    }

    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public Optional<User> findById(int id) {
        return userRepository.findById(id);
    }
}
