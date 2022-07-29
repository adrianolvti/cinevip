package br.edu.ifrs.restinga.cinevip.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.ifrs.restinga.cinevip.api.v1.dto.MovieDTO;
import br.edu.ifrs.restinga.cinevip.domain.orm.Movie;
import br.edu.ifrs.restinga.cinevip.domain.repository.MovieRepository;
import br.edu.ifrs.restinga.cinevip.service.interfaces.MovieService;

import static java.util.Objects.isNull;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Transactional
    @Override
    public MovieDTO create(Movie movie) {
        this.movieRepository.save(movie);
        MovieDTO movieDTO = new MovieDTO(movie);
        return movieDTO;
    }

    @Override
    public List<MovieDTO> findAll() {
        List<Movie> movies = (List<Movie>) this.movieRepository.findAll();
        return MovieDTO.convertList(movies);
    }

    @Override
    public MovieDTO findById(Long id) {
        Optional<Movie> optional = this.movieRepository.findById(id);
        Movie movie = optional.get();
        
        if (isNull(movie)) {
            throw new RuntimeException("Movie not found");
        }

        MovieDTO movieDTO = new MovieDTO(movie);
        return movieDTO;
    }

    @Transactional
    @Override
    public MovieDTO update(Movie updateMovie, Long id) {
        Optional<Movie> optional = this.movieRepository.findById(id);
        Movie movie = optional.get();

        if(updateMovie.getName() != null) movie.setName(updateMovie.getName());
        if(updateMovie.getGenre() != null) movie.setGenre(updateMovie.getGenre());
        if(updateMovie.getSynopsis() != null) movie.setSynopsis(updateMovie.getSynopsis());
        
        this.movieRepository.save(movie);

        MovieDTO userDTO = new MovieDTO(movie);
        return userDTO;
    }

    @Transactional
    @Override
    public String delete(Long id) {
        this.movieRepository.deleteById(id);
        return String.format("O filme com id %s foi deletado com sucesso", id);
    } 
}
