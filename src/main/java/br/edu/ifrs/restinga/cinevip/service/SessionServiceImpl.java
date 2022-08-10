package br.edu.ifrs.restinga.cinevip.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import br.edu.ifrs.restinga.cinevip.domain.orm.Session;
import br.edu.ifrs.restinga.cinevip.domain.repository.SessionRepository;
import br.edu.ifrs.restinga.cinevip.service.interfaces.SessionService;

@Service
public class SessionServiceImpl implements SessionService{
    
    @Autowired
    private SessionRepository sessionRepository;

    @Transactional
    @Override
    public Session create(@RequestBody Session session) {
        return this.sessionRepository.save(session);
    }

    @Override
    public List<Session> findAll() {
        return (List<Session>) this.sessionRepository.findAll();
    }

    @Override
    public Session findById(Long id) {
        Optional<Session> optional = this.sessionRepository.findById(id);
        Session session = optional.get();
        return session;
    }

    @Transactional
    @Override
    public Session update(Session updateSession, Long id) {
        Optional<Session> optional = this.sessionRepository.findById(id);
        Session session = optional.get();
        
        session.setSessionHour(updateSession.getSessionHour());
        
        this.sessionRepository.save(session);
        return session;
    }

    @Transactional
    @Override
    public String delete(Long id) {
        this.sessionRepository.deleteById(id);
        return String.format("A sessão com id %s foi deletada com sucesso", id);
    } 
}
