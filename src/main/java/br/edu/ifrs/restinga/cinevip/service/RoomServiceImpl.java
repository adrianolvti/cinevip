package br.edu.ifrs.restinga.cinevip.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.ifrs.restinga.cinevip.api.v1.dto.RoomDTO;
import br.edu.ifrs.restinga.cinevip.domain.orm.Room;
import br.edu.ifrs.restinga.cinevip.domain.repository.RoomRepository;
import br.edu.ifrs.restinga.cinevip.service.interfaces.RoomService;

import static java.util.Objects.isNull;

import java.util.List;
import java.util.Optional;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Transactional
    @Override
    public RoomDTO create(Room room) {
        // this.validateFields(room);
        this.roomRepository.save(room);
        RoomDTO roomDTO = new RoomDTO(room);
        return roomDTO;
    }

    @Override
    public List<RoomDTO> findAll() {
        List<Room> roomList = (List<Room>) this.roomRepository.findAll();
        // RoomDTO roomDTO = new RoomDTO();
        return RoomDTO.convertList(roomList);
    }

    @Override
    public RoomDTO findById(Long id) {
        Optional<Room> optional = this.roomRepository.findById(id);
        Room room = optional.get();
        
        if (isNull(room)) {
            throw new RuntimeException("Room not found");
        }

        RoomDTO roomDTO = new RoomDTO(room);
        return roomDTO;
    }  

    @Transactional
    @Override
    public RoomDTO update(Room updateRoom, Long id) {
        Optional<Room> optional = this.roomRepository.findById(id);
        Room room = optional.get();

        if(updateRoom.getNumber() != null) room.setNumber(updateRoom.getNumber());;
        if(updateRoom.getSeats() != null) room.setSeats(updateRoom.getSeats());

        this.roomRepository.save(room);

        RoomDTO roomDTO = new RoomDTO(room);
        return roomDTO;
    }

    @Transactional
    @Override
    public String delete(Long id) {
        this.roomRepository.deleteById(id);
        return String.format("Sala de id %s foi deletada com sucesso", id);
    }

    // private void validateFields(Room room) {

    //     if (room.getNumber() == null) {
    //         throw new ValidateFieldsException("O campo n??rero da sala precisa ser preenchido");
    //     }
    //     if (room.getSeats() == null) {
    //         throw new ValidateFieldsException("O campo quandidade de ascentos precisa ser preenchido");
    //     }
    // }
}
