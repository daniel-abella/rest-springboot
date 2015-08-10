package br.edu.embedded.samples.ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.edu.embedded.samples.ws.domain.Participant;

public interface ParticipantRepository extends JpaRepository<Participant, String> {
	
	public final static String FIND_BY_MAIL_CAMPAIGN = "SELECT p FROM Participant p WHERE p.email = :email and p.campaign_id = :campaign_id";

	public final static String FIND_BY_MAIL = "SELECT p FROM Participant p WHERE p.email = :email";

	@Query(FIND_BY_MAIL_CAMPAIGN)
	public Participant findByMailCampaign(@Param("email") String email, @Param("campaign_id")Integer campaingId);

	@Query(FIND_BY_MAIL)
	public Participant findByMail(@Param("email") String email);

}
