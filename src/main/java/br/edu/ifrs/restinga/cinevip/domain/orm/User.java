package br.edu.ifrs.restinga.cinevip.domain.orm;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import lombok.Data;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "não deve ser nulo, vazio ou em branco")
    @Length(max = 50)
    private String name;

    @CPF
    private String cpf;

    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{4,8}$", message = "A senha deve ter pelo menos 4 caracteres, não mais que 8 caracteres e deve incluir pelo menos uma letra maiúscula, uma letra minúscula e um dígito numérico.")
    private String password;

    @Email(regexp = "[\\w-]+@([\\w-]+\\.)+[\\w-]+")
    @NotNull
    private String email;
}