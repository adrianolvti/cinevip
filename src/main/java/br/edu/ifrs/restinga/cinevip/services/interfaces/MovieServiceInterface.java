package br.edu.ifrs.restinga.cinevip.services.interfaces;

import java.util.List;
import java.util.Optional;

import br.edu.ifrs.restinga.cinevip.models.Movie;

public interface MovieServiceInterface {
    public void save(Movie movie);

    public List<Movie> findAll();

    public Optional<Movie> findById(Long id);
    
    public void update(Movie movie, Long id);

    public void deleteById(Long id);
}
