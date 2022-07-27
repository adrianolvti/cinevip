package br.edu.ifrs.restinga.cinevip.service.interfaces;

import java.util.List;

import br.edu.ifrs.restinga.cinevip.api.v1.dto.SessionDTO;
import br.edu.ifrs.restinga.cinevip.domain.orm.Session;

public interface SessionService {
    
    public Session create(Session session);

    public List<SessionDTO> findAll();

    public SessionDTO findById(Long id);
    
    public SessionDTO update(Session session, Long id);

    public String delete(Long id);
}
