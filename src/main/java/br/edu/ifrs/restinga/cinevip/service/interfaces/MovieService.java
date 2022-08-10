package br.edu.ifrs.restinga.cinevip.service.interfaces;

import java.util.List;

import br.edu.ifrs.restinga.cinevip.domain.orm.Movie;

public interface MovieService {

    public Movie create(Movie user);

    public List<Movie> findAll();

    public Movie findById(Long id);
    
    public Movie update(Movie user, Long id);

    public String delete(Long id);
}
