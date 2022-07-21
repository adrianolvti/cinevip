package br.edu.ifrs.restinga.cinevip.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifrs.restinga.cinevip.models.Movie;
import br.edu.ifrs.restinga.cinevip.repository.MovieRepository;
import br.edu.ifrs.restinga.cinevip.services.interfaces.MovieServiceInterface;

@Service
public class MovieService implements MovieServiceInterface {

    @Autowired
    private MovieRepository movieRepository;

    @Transactional
    @Override
    public void save(Movie movie) {
        movieRepository.save(movie);
    }

    @Override
    public List<Movie> findAll() {
        return (List<Movie>) movieRepository.findAll();
    }

    @Override
    public Optional<Movie> findById(Long id) {
        return movieRepository.findById(id);
    }

    @Override
    public void update(Movie movie_update, Long id) {
        Optional<Movie> optional = movieRepository.findById(id);
        Movie movie = optional.get();
        movie.setName("teste");
        movieRepository.save(movie);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        movieRepository.deleteById(id);
    }
}
