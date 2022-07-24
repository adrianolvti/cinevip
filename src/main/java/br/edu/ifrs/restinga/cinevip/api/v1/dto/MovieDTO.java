package br.edu.ifrs.restinga.cinevip.api.v1.dto;

import org.springframework.beans.BeanUtils;

import br.edu.ifrs.restinga.cinevip.domain.orm.Movie;
import lombok.Data;

@Data
public class MovieDTO {

    private Long id;
    private String name;
    private String genre;
    private String synopsis;

    public MovieDTO convert(Movie moovie) {
        BeanUtils.copyProperties(moovie, this, "");
        return this;
    }
}
