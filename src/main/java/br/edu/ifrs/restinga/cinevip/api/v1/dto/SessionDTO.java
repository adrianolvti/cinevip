package br.edu.ifrs.restinga.cinevip.api.v1.dto;

import java.sql.Time;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.edu.ifrs.restinga.cinevip.domain.orm.Movie;
import br.edu.ifrs.restinga.cinevip.domain.orm.Room;
import br.edu.ifrs.restinga.cinevip.domain.orm.Session;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SessionDTO {

    private Long id;

    @JsonFormat(pattern = "HH:mm")
    private LocalTime sessionHour;
    private Movie movie;
    private Room room;

    public SessionDTO(Session session) {
        this.id = session.getId();
        this.sessionHour = session.getSessionHour();
        this.movie = session.getMovie();
        this.room = session.getRoom();
    }

    public static List<SessionDTO> convertList(List<Session> sessions) {
        return sessions.stream().map(SessionDTO::new).collect(Collectors.toList());
    }

    // public SessionDTO convert(Session session) {
    //     BeanUtils.copyProperties(session, this, "id");
    //     return this;
    // }
}
