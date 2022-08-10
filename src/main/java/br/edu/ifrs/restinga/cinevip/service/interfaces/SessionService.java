package br.edu.ifrs.restinga.cinevip.service.interfaces;

import java.util.List;

import br.edu.ifrs.restinga.cinevip.domain.orm.Session;

public interface SessionService {
    
    public Session create(Session session);

    public List<Session> findAll();

    public Session findById(Long id);
    
    public Session update(Session session, Long id);

    public String delete(Long id);
}
