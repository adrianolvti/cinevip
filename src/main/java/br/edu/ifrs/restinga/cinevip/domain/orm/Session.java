package br.edu.ifrs.restinga.cinevip.domain.orm;

import java.sql.Time;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Entity
@Data
public class Session {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // @NotEmpty
    // @NotNull
    @JsonFormat(pattern = "HH:mm")
    private LocalTime sessionHour;

    // @NotEmpty
    // @NotNull
    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    // @NotEmpty
    // @NotNull
    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;
}
