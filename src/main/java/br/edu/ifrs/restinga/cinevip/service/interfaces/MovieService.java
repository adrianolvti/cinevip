package br.edu.ifrs.restinga.cinevip.service.interfaces;

import br.edu.ifrs.restinga.cinevip.api.v1.dto.MovieDTO;
import br.edu.ifrs.restinga.cinevip.domain.orm.Movie;

public interface MovieService {

    public MovieDTO create(Movie user);

    public Iterable<Movie> findAll();

    public MovieDTO findById(Long id);
    
    public MovieDTO update(Movie user, Long id);

    public String delete(Long id);
}
