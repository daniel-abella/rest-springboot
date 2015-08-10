package br.edu.embedded.zennyworldz.ws.service;

import br.edu.embedded.zennyworldz.ws.domain.Participant;

public interface ParticipantService {

	Participant save(Participant participant);

	Participant findByMailCampaign(String mail, String capaign);

	Participant findByMail(String mail);
}
