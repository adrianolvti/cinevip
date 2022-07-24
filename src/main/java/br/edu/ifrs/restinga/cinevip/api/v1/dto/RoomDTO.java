package br.edu.ifrs.restinga.cinevip.api.v1.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import br.edu.ifrs.restinga.cinevip.domain.orm.Room;
import lombok.Data;

@Data
public class RoomDTO {
    
    private Integer number;
    private Integer seats;

    public RoomDTO convert(Room room) {
        BeanUtils.copyProperties(room, this, "id");
        return this;
    }

    public List<RoomDTO> convertList(List<Room> listRoom) {
        RoomDTO roomDTO = new RoomDTO();
        List<RoomDTO> roomDTOList = new ArrayList<>();
        listRoom.forEach(room -> {
            roomDTOList.add(roomDTO.convert(room));
        });
        return roomDTOList;
    }
}
