package br.edu.ifrs.restinga.cinevip.service.interfaces;

import java.util.List;

import br.edu.ifrs.restinga.cinevip.domain.orm.Room;

public interface RoomService {

    public Room create(Room room);

    public List<Room> findAll();

    public Room findById(Long id);
    
    public Room update(Room room, Long id);

    public String delete(Long id);
}