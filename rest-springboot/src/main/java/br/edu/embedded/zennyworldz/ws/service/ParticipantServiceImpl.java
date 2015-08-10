package br.edu.embedded.zennyworldz.ws.service;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import br.edu.embedded.zennyworldz.ws.domain.Participant;
import br.edu.embedded.zennyworldz.ws.repository.ParticipantRepository;
import br.edu.embedded.zennyworldz.ws.service.exception.ParticipantAlreadyExistsException;

@Service
@Validated
public class ParticipantServiceImpl implements ParticipantService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ParticipantServiceImpl.class);
    private final ParticipantRepository repository;

    @Inject
    public ParticipantServiceImpl(final ParticipantRepository repository) {
        this.repository = repository;
    }

    @Override
    public Participant findByMailCampaign(String mail, String capaign) {
    	return repository.findOne(mail);
    }
    
    @Override
    public Participant findByMail(String mail) {    
    	return repository.findByMail(mail);
    }
    
    @Override
    @Transactional
    public Participant save(@NotNull @Valid final Participant participant) {
    	
        LOGGER.debug("Creating {}", participant);
        Participant existing = repository.findOne(participant.getEmail());
        
        if (existing != null) {
            throw new ParticipantAlreadyExistsException(String.format("There already exists a participant with email=%s", participant.getEmail()));
        }
        
        return repository.save(participant);
    }

}
