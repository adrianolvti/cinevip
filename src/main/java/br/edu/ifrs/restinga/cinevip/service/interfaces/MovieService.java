package br.edu.ifrs.restinga.cinevip.service.interfaces;

import java.util.List;

import br.edu.ifrs.restinga.cinevip.api.v1.dto.MovieDTO;
import br.edu.ifrs.restinga.cinevip.domain.orm.Movie;

public interface MovieService {

    public MovieDTO create(Movie user);

    public List<MovieDTO> findAll();

    public MovieDTO findById(Long id);
    
    public MovieDTO update(Movie user, Long id);

    public String delete(Long id);
}
