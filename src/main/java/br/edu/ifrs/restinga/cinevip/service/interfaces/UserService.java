package br.edu.ifrs.restinga.cinevip.service.interfaces;

import java.util.List;

import br.edu.ifrs.restinga.cinevip.api.v1.dto.UserDTO;
import br.edu.ifrs.restinga.cinevip.domain.orm.User;


public interface UserService {

    public UserDTO create(User user);

    public List<UserDTO> findAll();

    public UserDTO findById(Long id);
    
    public UserDTO update(User user, Long id);

    public String delete(Long id);
}
