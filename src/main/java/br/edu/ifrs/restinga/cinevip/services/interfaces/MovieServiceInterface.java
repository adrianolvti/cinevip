package br.edu.ifrs.restinga.cinevip.services.interfaces;

import java.util.List;
import java.util.Optional;

import br.edu.ifrs.restinga.cinevip.models.Movie;

public interface MovieServiceInterface {
    public void save(Movie movie);

    public List<Movie> findAll();

    public Optional<Movie> findById(int id);
    
    public void update(Movie movie, int id);

    public void deleteById(int id);
}
