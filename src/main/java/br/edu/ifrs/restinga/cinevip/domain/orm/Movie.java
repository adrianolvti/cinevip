package br.edu.ifrs.restinga.cinevip.domain.orm;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotEmpty
    @NotNull
    private String name;

    @NotEmpty
    @NotNull
    private String genre;

    @NotEmpty
    @NotNull
    @Column(columnDefinition = "VARCHAR(510)")
    private String synopsis;

    @ManyToMany()
    private List<Session> sessions;
}
