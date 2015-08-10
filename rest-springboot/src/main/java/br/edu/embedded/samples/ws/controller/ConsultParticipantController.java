package br.edu.embedded.samples.ws.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.embedded.samples.ws.domain.Participant;
import br.edu.embedded.samples.ws.service.ParticipantService;
import br.edu.embedded.samples.ws.service.exception.ParticipantAlreadyExistsException;

@RestController
@RequestMapping("/campaign/{campaign_id}/participant/{email}")
public class ConsultParticipantController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ConsultParticipantController.class);

	private final ParticipantService participantService;

	@Inject
	public ConsultParticipantController(final ParticipantService participantService) {
		this.participantService = participantService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<String> consultParticipant(@RequestHeader(value = "promoasusapitoken") String token,
			@PathVariable("campaign_id") String campaignId, @PathVariable("email") String email) {

		if (!token.equalsIgnoreCase("AiodsopiAi897123=!g456")) {
			LOGGER.debug("401 (Unauthorized): se o token não existir ou não estiver correto ");
			return new ResponseEntity<String>(HttpStatus.UNAUTHORIZED);
		}

		try {

			Participant participant = participantService.findByMailCampaign(email, campaignId);

			if (participant == null) {
				LOGGER.debug("404 (Not found): se o usuário não existe");
				return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
			}

			LOGGER.debug("302 (Found): se o usuário existe");
			return new ResponseEntity<String>(HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.debug("500 (Internal Server Error): erro interno no serviço");
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
