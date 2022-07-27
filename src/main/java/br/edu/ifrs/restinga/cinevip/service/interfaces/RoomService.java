package br.edu.ifrs.restinga.cinevip.service.interfaces;

import br.edu.ifrs.restinga.cinevip.api.v1.dto.RoomDTO;
import br.edu.ifrs.restinga.cinevip.domain.orm.Room;

public interface RoomService {

    public RoomDTO create(Room room);

    public Iterable<Room> findAll();

    public RoomDTO findById(Long id);
    
    public RoomDTO update(Room room, Long id);

    public String delete(Long id);
}