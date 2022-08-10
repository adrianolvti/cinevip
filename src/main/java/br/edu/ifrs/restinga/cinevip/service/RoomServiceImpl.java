package br.edu.ifrs.restinga.cinevip.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.ifrs.restinga.cinevip.domain.orm.Room;
import br.edu.ifrs.restinga.cinevip.domain.repository.RoomRepository;
import br.edu.ifrs.restinga.cinevip.service.interfaces.RoomService;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Transactional
    @Override
    public Room create(Room room) {
        return this.roomRepository.save(room);
    }

    @Override
    public List<Room> findAll() {
        return (List<Room>) this.roomRepository.findAll();
    }

    @Override
    public Room findById(Long id) {
        Optional<Room> optional = this.roomRepository.findById(id);
        Room room = optional.get();
        return room;
    }  

    @Transactional
    @Override
    public Room update(Room updateRoom, Long id) {
        Optional<Room> optional = this.roomRepository.findById(id);
        Room room = optional.get();

        if(updateRoom.getNumber() != null) room.setNumber(updateRoom.getNumber());;
        if(updateRoom.getSeats() != null) room.setSeats(updateRoom.getSeats());

        this.roomRepository.save(room);
        return room;
    }

    @Transactional
    @Override
    public String delete(Long id) {
        this.roomRepository.deleteById(id);
        return String.format("Sala de id %s foi deletada com sucesso", id);
    }
}
