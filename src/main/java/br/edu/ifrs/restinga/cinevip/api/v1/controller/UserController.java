package br.edu.ifrs.restinga.cinevip.api.v1.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifrs.restinga.cinevip.api.v1.dto.UserDTO;
import br.edu.ifrs.restinga.cinevip.domain.orm.User;
import br.edu.ifrs.restinga.cinevip.service.UserServiceImpl;

@RestController
// @CrossOrigin(origins="http://localhost:3000")
@CrossOrigin(origins="*")
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;
  
    @PostMapping
    public ResponseEntity<UserDTO> create(@Valid @RequestBody User user) throws URISyntaxException {
        URI location = new URI("/room");
        return ResponseEntity.created(location).body(this.userServiceImpl.create(user));
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        return ResponseEntity.ok().body(this.userServiceImpl.findAll());
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(this.userServiceImpl.findById(id));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<UserDTO> update(@Valid @RequestBody User user, @PathVariable("id") Long id) {
        return ResponseEntity.ok().body(this.userServiceImpl.update(user, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        return ResponseEntity.ok().body(this.userServiceImpl.delete(id));
    }
}
