package br.edu.ifrs.restinga.cinevip.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifrs.restinga.cinevip.models.User;
import br.edu.ifrs.restinga.cinevip.repository.UserRepository;
import br.edu.ifrs.restinga.cinevip.services.interfaces.UserServiceInterface;

@Service

public class UserService implements UserServiceInterface{
    
    @Autowired
    private UserRepository userRepository; 

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public Optional<User> findById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public void update(User user_update, int id) {
        User user = userRepository.find(id);
        user = user_update;
        userRepository.save(user);
    }    
}
