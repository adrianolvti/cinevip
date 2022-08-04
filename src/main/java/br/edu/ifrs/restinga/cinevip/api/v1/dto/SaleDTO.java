package br.edu.ifrs.restinga.cinevip.api.v1.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.edu.ifrs.restinga.cinevip.domain.orm.Movie;
import br.edu.ifrs.restinga.cinevip.domain.orm.Room;
import br.edu.ifrs.restinga.cinevip.domain.orm.Sale;
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
    private Movie movie;
    private Session session;
    private Room room;

    public SaleDTO(Sale sale) {
        this.id =  sale.getId();
        this.user = sale.getUser();
        this.movie = sale.getMovie();
        this.session = sale.getSession();
        this.room = sale.getRoom();
    }

    public static List<SaleDTO> convertList(List<Sale> sales) {
        return sales.stream().map(SaleDTO::new).collect(Collectors.toList());
    }
}
