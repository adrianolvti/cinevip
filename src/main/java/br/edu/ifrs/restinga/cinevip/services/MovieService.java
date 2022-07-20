package br.edu.ifrs.restinga.cinevip.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifrs.restinga.cinevip.models.Movie;
import br.edu.ifrs.restinga.cinevip.repository.MovieRepository;
import br.edu.ifrs.restinga.cinevip.services.interfaces.MovieServiceInterface;

@Service
public class MovieService implements MovieServiceInterface {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public void save(Movie movie) {
        movieRepository.save(movie);
    }

    @Override
    public List<Movie> findAll() {
        return (List<Movie>) movieRepository.findAll();
    }

    @Override
    public Optional<Movie> findById(int id) {
        // TODO Auto-generated method stub
        return Optional.empty();
    }

    @Override
    public void update(Movie movie, int id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteById(int id) {
        // TODO Auto-generated method stub
        
    }
    
}
