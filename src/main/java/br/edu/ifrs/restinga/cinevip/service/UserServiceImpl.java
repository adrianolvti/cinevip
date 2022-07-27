package br.edu.ifrs.restinga.cinevip.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.ifrs.restinga.cinevip.api.v1.dto.UserDTO;
import br.edu.ifrs.restinga.cinevip.domain.orm.User;
import br.edu.ifrs.restinga.cinevip.domain.repository.UserRepository;
import br.edu.ifrs.restinga.cinevip.service.interfaces.UserService;

import static java.util.Objects.isNull;

@Service
public class UserServiceImpl implements UserService {
       
    @Autowired
    private UserRepository userRepository; 

    @Transactional
    @Override
    public UserDTO create(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.convert(user);
        this.userRepository.save(user);
        return userDTO;
    }

    @Override
    public Iterable<User> findAll() {
        return this.userRepository.findAll();
    }

    @Override
    public UserDTO findById(Long id) {
        Optional<User> optional = this.userRepository.findById(id);
        User user = optional.get();
        
        if (isNull(user)) {
            throw new RuntimeException("User not found");
        }

        UserDTO userDTO = new UserDTO();
        userDTO.convert(user);
        return userDTO;
    }

    @Transactional
    @Override
    public UserDTO update(User updateUser, Long id) {
        Optional<User> optional = this.userRepository.findById(id);
        User user = optional.get();
        UserDTO userDTO = new UserDTO();

        if(updateUser.getName() != null) user.setName(updateUser.getName());
        if(updateUser.getCpf() != null) user.setCpf(updateUser.getCpf());
        if(updateUser.getPassword() != null) user.setPassword(updateUser.getPassword());
        
        this.userRepository.save(user);
        return userDTO.convert(user);
    }

    @Transactional
    @Override
    public String delete(Long id) {
        this.userRepository.deleteById(id);
        return String.format("O usuário com id %s foi deletado com sucesso", id);
    } 
}
