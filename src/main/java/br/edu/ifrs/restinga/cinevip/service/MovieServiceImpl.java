package br.edu.ifrs.restinga.cinevip.service;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.ifrs.restinga.cinevip.domain.orm.Movie;
import br.edu.ifrs.restinga.cinevip.domain.orm.Session;
import br.edu.ifrs.restinga.cinevip.domain.repository.MovieRepository;
import br.edu.ifrs.restinga.cinevip.service.interfaces.MovieService;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @PersistenceContext
    private EntityManager manager;


    @Transactional
    @Override
    public Movie create(Movie movie) {
        return this.movieRepository.save(movie);
    }

    @Override
    public List<Movie> findAll() {
        return (List<Movie>) this.movieRepository.findAll();
    }

    @Override
    public Movie findById(Long id) {
        Optional<Movie> optional = this.movieRepository.findById(id);
        Movie movie = optional.get();
        return movie;
    }

    @Transactional
    @Override
    public Movie update(Movie updateMovie, Long id) {
        Optional<Movie> optional = this.movieRepository.findById(id);
        Movie movie = optional.get();

        if(updateMovie.getName() != null) movie.setName(updateMovie.getName());
        if(updateMovie.getGenre() != null) movie.setGenre(updateMovie.getGenre());
        if(updateMovie.getSynopsis() != null) movie.setSynopsis(updateMovie.getSynopsis());
        
        this.movieRepository.save(movie);
        return movie;
    }

    @Transactional
    @Override
    public String delete(Long id) {
        this.movieRepository.deleteById(id);
        return String.format("O filme com id %s foi deletado com sucesso", id);
    } 

    public List<Movie> searchBySessionHour(LocalTime hour) {
        List<Movie> moviesBySession = null;

        try {
            CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
            CriteriaQuery<Movie> criteriaQuery = criteriaBuilder.createQuery(Movie.class);  
            Root<Movie> movie = criteriaQuery.from(Movie.class);
            Join<Movie, Session> joinSession = movie.join("sessions", JoinType.INNER);

            TypedQuery<Movie> typedQuery = manager.createQuery(
                criteriaQuery.select(movie).where(criteriaBuilder.equal(joinSession.get("hours"), hour))
            );
            moviesBySession = typedQuery.getResultList();
        
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return moviesBySession;
    }
}
