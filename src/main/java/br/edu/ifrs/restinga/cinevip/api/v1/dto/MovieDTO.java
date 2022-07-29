package br.edu.ifrs.restinga.cinevip.api.v1.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.edu.ifrs.restinga.cinevip.domain.orm.Movie;
import br.edu.ifrs.restinga.cinevip.domain.orm.Session;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDTO {

    private Long id;
    private String name;
    private String genre;
    private String synopsis;
    private List<Session> sessions;

    public MovieDTO(Movie movie) {
        this.id         = movie.getId();
        this.name       = movie.getName();
        this.genre      = movie.getGenre();
        this.synopsis   = movie.getSynopsis();
        this.sessions   = movie.getSessions();
    }

    public static List<MovieDTO> convertList(List<Movie> movies) {
        return movies.stream().map(MovieDTO::new).collect(Collectors.toList());
    }
}
