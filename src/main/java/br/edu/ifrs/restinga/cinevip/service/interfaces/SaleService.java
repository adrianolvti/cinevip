package br.edu.ifrs.restinga.cinevip.service.interfaces;

import java.util.List;

import br.edu.ifrs.restinga.cinevip.api.v1.dto.SaleDTO;
import br.edu.ifrs.restinga.cinevip.domain.orm.Sale;

public interface SaleService {
    
    public SaleDTO create(Sale sale);

    public List<SaleDTO> findAll();

    public SaleDTO findById(Long id);

    public String delete(Long id);
}
