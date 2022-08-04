package br.edu.ifrs.restinga.cinevip.api.v1.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.edu.ifrs.restinga.cinevip.domain.orm.Sale;
import br.edu.ifrs.restinga.cinevip.domain.orm.Seat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeatDTO {
    
    private Long id;
    private int seatNumber;
    private List<Sale> sale;

    public SeatDTO(Seat seat) {
        this.id         = seat.getId();
        this.seatNumber = seat.getSeatNumber();
        this.sale       = seat.getSale();
    }

    public static List<SeatDTO> convertList(List<Seat> seat) {
        return seat.stream().map(SeatDTO::new).collect(Collectors.toList());
    }
}
