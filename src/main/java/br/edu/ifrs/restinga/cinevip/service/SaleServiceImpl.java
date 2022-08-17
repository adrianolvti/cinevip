package br.edu.ifrs.restinga.cinevip.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.ifrs.restinga.cinevip.domain.orm.Sale;
import br.edu.ifrs.restinga.cinevip.domain.repository.SaleRepository;
import br.edu.ifrs.restinga.cinevip.service.interfaces.SaleService;

@Service
public class SaleServiceImpl implements SaleService {

    @Autowired
    private SaleRepository saleRepository;

    @Transactional
    @Override
    public Sale create(Sale sale) {
        return this.saleRepository.save(sale);
    }

    @Override
    public List<Sale> findAll() {
        return (List<Sale>) this.saleRepository.findAll();
    }

    @Override
    public Sale findById(Long id) {
        Optional<Sale> optional = this.saleRepository.findById(id);
        Sale sale = optional.get();
        return sale;
    }

    @Transactional
    @Override
    public String delete(Long id) {
        this.saleRepository.deleteById(id);
        return String.format("Venda de id %s foi deletada com sucesso", id);
    }
    
}
