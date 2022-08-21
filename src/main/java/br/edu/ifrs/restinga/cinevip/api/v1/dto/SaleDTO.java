package br.edu.ifrs.restinga.cinevip.api.v1.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.edu.ifrs.restinga.cinevip.domain.orm.Room;
import br.edu.ifrs.restinga.cinevip.domain.orm.Sale;
import br.edu.ifrs.restinga.cinevip.domain.orm.Seat;
import br.edu.ifrs.restinga.cinevip.domain.orm.Session;
import br.edu.ifrs.restinga.cinevip.domain.orm.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleDTO {
    
    private Long id;
    private User user;
    private Session session;
    private Room room;
    private List<SeatDTO> seats;

    public SaleDTO(Sale sale) {
        this.id         = sale.getId();
        this.user       = sale.getUser();
        this.session    = sale.getSession();
        this.room       = sale.getRoom();
        this.seats      = returnSeatDTO(sale.getSeats());
    }

    public static List<SaleDTO> convertList(List<Sale> sales) {
        return sales.stream().map(SaleDTO::new).collect(Collectors.toList());
    }

    private List<SeatDTO> returnSeatDTO(List<Seat> seat) {
        List<Seat> seats = seat;
        List<SeatDTO> seatsDTO = SeatDTO.convertList(seats);
        return seatsDTO;
    }
}

