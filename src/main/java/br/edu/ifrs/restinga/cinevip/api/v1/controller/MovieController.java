package br.edu.ifrs.restinga.cinevip.api.v1.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.edu.ifrs.restinga.cinevip.api.v1.dto.MovieDTO;
import br.edu.ifrs.restinga.cinevip.domain.orm.Movie;
import br.edu.ifrs.restinga.cinevip.service.MovieServiceImpl;

@Controller
@RequestMapping("/movie")
public class MovieController {
    
    @Autowired
    private MovieServiceImpl movieServiceImpl;

    @PostMapping
    public ResponseEntity<MovieDTO> create(@RequestBody Movie movie) throws URISyntaxException {
        URI location = new URI("/room");
        return ResponseEntity.created(location).body(this.movieServiceImpl.create(movie));
    }

    @GetMapping
    public ResponseEntity<Iterable<Movie>> findAll() {
        return ResponseEntity.ok().body(this.movieServiceImpl.findAll());
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<MovieDTO> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(this.movieServiceImpl.findById(id));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<MovieDTO> update(@RequestBody Movie movie, @PathVariable("id") Long id) {
        return ResponseEntity.ok().body(this.movieServiceImpl.update(movie, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        return ResponseEntity.ok().body(this.movieServiceImpl.delete(id));
    }
}
