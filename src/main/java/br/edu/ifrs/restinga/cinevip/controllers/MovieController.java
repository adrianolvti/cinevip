package br.edu.ifrs.restinga.cinevip.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.edu.ifrs.restinga.cinevip.models.Movie;
import br.edu.ifrs.restinga.cinevip.services.MovieService;

@Controller
@RequestMapping("/movie")
public class MovieController {
    
    @Autowired
    private MovieService movieService;

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST)
    public void create(@RequestBody Movie movie) {
        movieService.save(movie);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Movie> index() {
       return movieService.findAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Optional<Movie> show(@PathVariable("id") Long id) {
       return movieService.findById(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(value = "/{id}"
    // , method = RequestMethod.PUT
    )
    @ResponseBody
    public void update(@RequestBody Movie movie, @PathVariable("id") Long id) {
        movieService.update(movie, id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void delete(@PathVariable("id") Long id) {
        movieService.deleteById(id);
    }
}
