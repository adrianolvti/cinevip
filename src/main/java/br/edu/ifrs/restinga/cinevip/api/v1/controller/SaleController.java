package br.edu.ifrs.restinga.cinevip.api.v1.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifrs.restinga.cinevip.domain.orm.Sale;
import br.edu.ifrs.restinga.cinevip.service.SaleServiceImpl;

@RestController
@RequestMapping("api/sale")
public class SaleController {
    
    @Autowired
    private SaleServiceImpl saleServiceImpl;

    @PostMapping
    public ResponseEntity<Sale> create(@Valid @RequestBody Sale sale) throws URISyntaxException {
        URI location = new URI("/sale");
        return ResponseEntity.created(location).body(this.saleServiceImpl.create(sale));
    }

    @GetMapping
    public ResponseEntity<List<Sale>> findAll() {
        return ResponseEntity.ok().body(saleServiceImpl.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Sale> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(saleServiceImpl.findById(id));
    }    

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        return ResponseEntity.ok().body(this.saleServiceImpl.delete(id));
    }
}
