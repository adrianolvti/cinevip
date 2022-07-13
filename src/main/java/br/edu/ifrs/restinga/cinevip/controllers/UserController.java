package br.edu.ifrs.restinga.cinevip.controllers;

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

import br.edu.ifrs.restinga.cinevip.models.User;
import br.edu.ifrs.restinga.cinevip.services.UserService;

@Controller
// @AllArgsConstructor
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
  
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value ="/", method = RequestMethod.POST)
    public void save(@RequestBody User user) {
        userService.save(user);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Optional<User> findById(@PathVariable("id") int id) {
       return userService.findById(id);
    }
}
