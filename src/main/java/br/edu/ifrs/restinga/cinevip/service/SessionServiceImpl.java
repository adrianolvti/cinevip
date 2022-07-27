package br.edu.ifrs.restinga.cinevip.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import br.edu.ifrs.restinga.cinevip.api.v1.dto.SessionDTO;
import br.edu.ifrs.restinga.cinevip.domain.orm.Session;
import br.edu.ifrs.restinga.cinevip.domain.repository.SessionRepository;
import br.edu.ifrs.restinga.cinevip.service.interfaces.SessionService;

import static java.util.Objects.isNull;

import java.util.List;

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
    public List<SessionDTO> findAll() {
        List<Session> sessions = (List<Session>) this.sessionRepository.findAll();
        return SessionDTO.convertList(sessions);
    }

    @Override
    public SessionDTO findById(Long id) {
        Optional<Session> optional = this.sessionRepository.findById(id);
        Session session = optional.get();
        
        if (isNull(session)) {
            throw new RuntimeException("Session not found");
        }

        SessionDTO sessionDTO = new SessionDTO(session);
        return sessionDTO;
    }

    @Transactional
    @Override
    public SessionDTO update(Session updateSession, Long id) {
        Optional<Session> optional = this.sessionRepository.findById(id);
        Session session = optional.get();

        if(updateSession.getSessionHour() != null) session.setSessionHour(updateSession.getSessionHour());
        if(updateSession.getMovie() != null) session.setMovie(updateSession.getMovie());
        if(updateSession.getRoom() != null) session.setRoom(updateSession.getRoom());
        
        this.sessionRepository.save(session);

        SessionDTO sessionDTO = new SessionDTO(session);
        return sessionDTO;
    }

    @Transactional
    @Override
    public String delete(Long id) {
        this.sessionRepository.deleteById(id);
        return String.format("A sessão com id %s foi deletada com sucesso", id);
    } 
}
