package br.edu.ifrs.restinga.cinevip.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.ifrs.restinga.cinevip.api.v1.dto.SaleDTO;
import br.edu.ifrs.restinga.cinevip.domain.orm.Sale;
import br.edu.ifrs.restinga.cinevip.domain.repository.SaleRepository;
import br.edu.ifrs.restinga.cinevip.service.interfaces.SaleService;

@Service
public class SaleServiceImpl implements SaleService {

    @Autowired
    private SaleRepository saleRepository;

    @Transactional
    @Override
    public SaleDTO create(Sale sale) {
        this.saleRepository.save(sale);
        SaleDTO saleDTO = new SaleDTO();
        return saleDTO;
    }

    @Override
    public List<SaleDTO> findAll() {
        List<Sale> sales = (List<Sale>) this.saleRepository.findAll();
        return SaleDTO.convertList(sales);
    }

    @Override
    public SaleDTO findById(Long id) {
        Optional<Sale> optional = this.saleRepository.findById(id);
        Sale sale = optional.get();

        SaleDTO saleDTO = new SaleDTO(sale);
        return saleDTO;
    }

    @Transactional
    @Override
    public String delete(Long id) {
        this.saleRepository.deleteById(id);
        return String.format("Venda de id %s foi deletada com sucesso", id);
    }
    
}
