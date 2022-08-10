package br.edu.ifrs.restinga.cinevip.api.v1.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifrs.restinga.cinevip.domain.orm.Movie;
import br.edu.ifrs.restinga.cinevip.service.MovieServiceImpl;

@RestController
@RequestMapping("api/movie")
public class MovieController {
    
    @Autowired
    private MovieServiceImpl movieServiceImpl;

    @PostMapping
    public ResponseEntity<Movie> create(@Valid @RequestBody Movie movie) throws URISyntaxException {
        URI location = new URI("/room");
        return ResponseEntity.created(location).body(this.movieServiceImpl.create(movie));
    }

    @GetMapping
    public ResponseEntity<List<Movie>> findAll() {
        return ResponseEntity.ok().body(this.movieServiceImpl.findAll());
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<Movie> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(this.movieServiceImpl.findById(id));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Movie> update(@Valid @RequestBody Movie movie, @PathVariable("id") Long id) {
        return ResponseEntity.ok().body(this.movieServiceImpl.update(movie, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        return ResponseEntity.ok().body(this.movieServiceImpl.delete(id));
    }
}
