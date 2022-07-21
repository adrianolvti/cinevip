package br.edu.ifrs.restinga.cinevip.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.ifrs.restinga.cinevip.models.User;
import br.edu.ifrs.restinga.cinevip.repository.UserRepository;
import br.edu.ifrs.restinga.cinevip.services.interfaces.UserServiceInterface;

@Service
public class UserService implements UserServiceInterface {
    
    @Autowired
    private UserRepository userRepository; 

    @Transactional
    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Transactional
    @Override
    public void update(User user_update, Long id) {
        Optional<User> optional = userRepository.findById(id);
        User user = optional.get();

        if(user_update.getName() != null) user.setName(user_update.getName());
        if(user_update.getCpf() != null) user.setCpf(user_update.getCpf());
        if(user_update.getPassword() != null) user.setPassword(user_update.getPassword());
        
        userRepository.save(user);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }    
}
