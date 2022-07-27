package br.edu.ifrs.restinga.cinevip.api.v1.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifrs.restinga.cinevip.api.v1.dto.SessionDTO;
import br.edu.ifrs.restinga.cinevip.domain.orm.Session;
import br.edu.ifrs.restinga.cinevip.service.SessionServiceImpl;

@Controller
@RequestMapping("/session")
public class SessionController {
        
    @Autowired
    private SessionServiceImpl sessionServiceImpl;

    @PostMapping
    public ResponseEntity<Session> create(@RequestBody Session session) throws URISyntaxException {
        URI location = new URI("/session");
        return ResponseEntity.created(location).body(this.sessionServiceImpl.create(session));
    }

    @GetMapping
    public ResponseEntity<List<SessionDTO>> findAll() {
        return ResponseEntity.ok().body(this.sessionServiceImpl.findAll());
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<SessionDTO> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(this.sessionServiceImpl.findById(id));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<SessionDTO> update(@RequestBody Session session, @PathVariable("id") Long id) {
        return ResponseEntity.ok().body(this.sessionServiceImpl.update(session, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        return ResponseEntity.ok().body(this.sessionServiceImpl.delete(id));
    }
}
