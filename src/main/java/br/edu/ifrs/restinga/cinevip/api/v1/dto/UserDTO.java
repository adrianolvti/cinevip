package br.edu.ifrs.restinga.cinevip.api.v1.dto;

import org.springframework.beans.BeanUtils;

import br.edu.ifrs.restinga.cinevip.domain.orm.User;
import lombok.Data;

@Data
public class UserDTO {
    
    private Long id;
    private String name;

    public UserDTO convert(User user) {
        BeanUtils.copyProperties(user, this, "cpf", "password");
        return this;
    }
}
