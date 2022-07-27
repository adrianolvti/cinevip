package br.edu.ifrs.restinga.cinevip.domain.orm;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotEmpty
    @NotNull
    private String name;

    @NotEmpty
    @NotNull
    private String cpf;

    @NotEmpty
    @NotNull
    private String password;
}