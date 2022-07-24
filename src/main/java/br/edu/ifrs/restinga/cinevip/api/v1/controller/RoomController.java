package br.edu.ifrs.restinga.cinevip.api.v1.controller;

import java.net.URI;
import java.net.URISyntaxException;

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

import br.edu.ifrs.restinga.cinevip.api.v1.dto.RoomDTO;
import br.edu.ifrs.restinga.cinevip.domain.orm.Room;
import br.edu.ifrs.restinga.cinevip.service.RoomServiceImpl;

@RestController
@RequestMapping("/room")
public class RoomController {
    
    @Autowired
    private RoomServiceImpl roomServiceImpl;

    @PostMapping
    public ResponseEntity<RoomDTO> create(@RequestBody Room room) throws URISyntaxException {
        URI location = new URI("/room");
        return ResponseEntity.created(location).body(this.roomServiceImpl.create(room));
    }

    @GetMapping
    public ResponseEntity<Iterable<Room>> findAll() {
        return ResponseEntity.ok().body(roomServiceImpl.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<RoomDTO> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(roomServiceImpl.findById(id));
    }    

    @PutMapping(value = "/{id}")
    public ResponseEntity<RoomDTO> update(@RequestBody Room room, @PathVariable("id") Long id) {
        return ResponseEntity.ok().body(roomServiceImpl.update(room, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        return ResponseEntity.ok().body(this.roomServiceImpl.delete(id));
    }
}
