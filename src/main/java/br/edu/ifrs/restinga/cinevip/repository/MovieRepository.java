package br.edu.ifrs.restinga.cinevip.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import br.edu.ifrs.restinga.cinevip.models.Movie;

public interface MovieRepository extends CrudRepository<Movie, String> {
    public Optional<Movie> findById(Long id);
    
    public Optional<Movie> save(Optional<Movie> movie);

    public void deleteById(Long id);
}
