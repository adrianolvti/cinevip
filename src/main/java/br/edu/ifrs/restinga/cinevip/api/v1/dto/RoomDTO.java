package br.edu.ifrs.restinga.cinevip.api.v1.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.edu.ifrs.restinga.cinevip.domain.orm.Movie;
import br.edu.ifrs.restinga.cinevip.domain.orm.Room;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomDTO {
    
    private Long id;
    private Integer number;
    private Integer seats;
    private List<Movie> movies;

    public RoomDTO(Room room) {
        this.id     = room.getId();
        this.number = room.getNumber();
        this.seats  = room.getSeats();
        this.movies = room.getMovies();
    }

    public static List<RoomDTO> convertList(List<Room> rooms) {
        return rooms.stream().map(RoomDTO::new).collect(Collectors.toList());
    }
}
