package br.edu.embedded.zennyworldz.ws.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.embedded.zennyworldz.ws.domain.Participant;
import br.edu.embedded.zennyworldz.ws.service.ParticipantService;
import br.edu.embedded.zennyworldz.ws.service.exception.ParticipantAlreadyExistsException;

@RestController
@RequestMapping("/participant")
public class CreateParticipantController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CreateParticipantController.class);
    
    private final ParticipantService participantService;

    @Inject
    public CreateParticipantController(final ParticipantService participantService) {
        this.participantService = participantService;
    }

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<String> createParticipant(@RequestHeader(value = "promoasusapitoken") String token, @RequestBody Participant participant) {

		if (!token.equalsIgnoreCase("AiodsopiAi897123=!g456")) {
			LOGGER.debug("401 (Unauthorized): se o token não existir ou não estiver correto");
			return new ResponseEntity<String>(HttpStatus.UNAUTHORIZED);
		}

    	try {
    		LOGGER.debug("201 (Created): se o usuário ainda não existia e foi cadastrado");
        	participantService.save(participant);
    		return new ResponseEntity<String>(HttpStatus.CREATED);

		} catch (ParticipantAlreadyExistsException e) {
			LOGGER.debug("409 (Conflict): se o usuário já existe e não foi cadastrado");
    		return new ResponseEntity<String>(HttpStatus.CONFLICT);
		} catch (Exception e) {
    		e.printStackTrace();
    		return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
            
    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    public String handleUserAlreadyExistsException(ParticipantAlreadyExistsException e) {
    	return e.getMessage();
    }

	public ParticipantService getParticipantService() {
		return participantService;
	}
}
