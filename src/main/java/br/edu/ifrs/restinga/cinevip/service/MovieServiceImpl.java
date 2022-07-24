package br.edu.ifrs.restinga.cinevip.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifrs.restinga.cinevip.api.v1.dto.MovieDTO;
import br.edu.ifrs.restinga.cinevip.domain.orm.Movie;
import br.edu.ifrs.restinga.cinevip.domain.repository.MovieRepository;

import static java.util.Objects.isNull;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Transactional
    @Override
    public MovieDTO create(Movie movie) {
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.convert(movie);
        this.movieRepository.save(movie);
        return movieDTO;
    }

    @Override
    public Iterable<Movie> findAll() {
        return this.movieRepository.findAll();
    }

    @Override
    public MovieDTO findById(Long id) {
        Optional<Movie> optional = this.movieRepository.findById(id);
        Movie movie = optional.get();
        
        if (isNull(movie)) {
            throw new RuntimeException("Movie not found");
        }

        MovieDTO movieDTO = new MovieDTO();
        movieDTO.convert(movie);
        return movieDTO;
    }

    @Transactional
    @Override
    public MovieDTO update(Movie updateMovie, Long id) {
        Optional<Movie> optional = this.movieRepository.findById(id);
        Movie movie = optional.get();
        MovieDTO userDTO = new MovieDTO();

        if(updateMovie.getName() != null) movie.setName(updateMovie.getName());
        if(updateMovie.getGenre() != null) movie.setGenre(updateMovie.getGenre());
        if(updateMovie.getSynopsis() != null) movie.setSynopsis(updateMovie.getSynopsis());
        
        this.movieRepository.save(movie);
        return userDTO.convert(movie);
    }

    @Transactional
    @Override
    public String delete(Long id) {
        this.movieRepository.deleteById(id);
        return String.format("O filme com id %s foi deletado com sucesso", id);
    } 
}
