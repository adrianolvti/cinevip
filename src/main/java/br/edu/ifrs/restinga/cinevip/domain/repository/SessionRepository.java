package br.edu.ifrs.restinga.cinevip.domain.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifrs.restinga.cinevip.domain.orm.Session;

@Repository
public interface SessionRepository extends CrudRepository<Session, Long> {
    
}
