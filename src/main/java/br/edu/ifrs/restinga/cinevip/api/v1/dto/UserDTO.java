package br.edu.ifrs.restinga.cinevip.api.v1.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.edu.ifrs.restinga.cinevip.domain.orm.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    
    private Long id;
    private String name;
    private String cpf;
    private String email;

    public UserDTO(User user) {
        this.id     = user.getId();
        this.name   = user.getName();
        this.cpf    = user.getCpf();
        this.email  = user.getEmail();
    }

    public static List<UserDTO> convertList(List<User> users) {
        return users.stream().map(UserDTO::new).collect(Collectors.toList());
    }
}
