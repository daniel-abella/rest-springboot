package br.edu.embedded.samples.ws.service;

import br.edu.embedded.samples.ws.domain.Participant;

public interface ParticipantService {

	Participant save(Participant participant);

	Participant findByMailCampaign(String mail, String capaign);

	Participant findByMail(String mail);
}
