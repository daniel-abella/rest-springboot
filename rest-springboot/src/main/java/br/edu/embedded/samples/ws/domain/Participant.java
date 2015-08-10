package br.edu.embedded.samples.ws.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.common.base.Objects;

@Entity
@Table
public class Participant implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7799369695818057571L;

	
	private Integer campaign_id;
	
	@Id
	private String email;
	private String gpg_id;
	private String location;

	
	@Override
	public String toString() {
		return Objects.toStringHelper(this).add("campaign_id", getCampaign_id()).toString();
	}

	public Integer getCampaign_id() {
		return campaign_id;
	}




	public void setCampaign_id(Integer campaign_id) {
		this.campaign_id = campaign_id;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getGpg_id() {
		return gpg_id;
	}




	public void setGpg_id(String gpg_id) {
		this.gpg_id = gpg_id;
	}




	public String getLocation() {
		return location;
	}




	public void setLocation(String location) {
		this.location = location;
	}




	
	
}
