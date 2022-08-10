package br.edu.ifrs.restinga.cinevip.service.interfaces;

import java.util.List;

import br.edu.ifrs.restinga.cinevip.domain.orm.Sale;

public interface SaleService {
    
    public Sale create(Sale sale);

    public List<Sale> findAll();

    public Sale findById(Long id);

    public String delete(Long id);
}
