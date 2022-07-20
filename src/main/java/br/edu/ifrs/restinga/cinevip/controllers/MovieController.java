package br.edu.ifrs.restinga.cinevip.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
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
}
