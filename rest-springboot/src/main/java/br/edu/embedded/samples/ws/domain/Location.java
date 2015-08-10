package br.edu.embedded.samples.ws.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Location implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -734850655363029835L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String as;
	private String city;
	private String country;
	private String countryCode;
	private String isp;
	private Double lat;
	private Double lon;
	private String org;
	private String query;
	private String region;
	private String regionName;
	private String status;
	private String timezone;
	private String zip;

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 
	 * @return The as
	 */
	public String getAs() {
		return as;
	}

	/**
	 * 
	 * @param as
	 *            The as
	 */
	public void setAs(String as) {
		this.as = as;
	}

	/**
	 * 
	 * @return The city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * 
	 * @param city
	 *            The city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * 
	 * @return The country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * 
	 * @param country
	 *            The country
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * 
	 * @return The countryCode
	 */
	public String getCountryCode() {
		return countryCode;
	}

	/**
	 * 
	 * @param countryCode
	 *            The countryCode
	 */
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	/**
	 * 
	 * @return The isp
	 */
	public String getIsp() {
		return isp;
	}

	/**
	 * 
	 * @param isp
	 *            The isp
	 */
	public void setIsp(String isp) {
		this.isp = isp;
	}

	/**
	 * 
	 * @return The lat
	 */
	public Double getLat() {
		return lat;
	}

	/**
	 * 
	 * @param lat
	 *            The lat
	 */
	public void setLat(Double lat) {
		this.lat = lat;
	}

	/**
	 * 
	 * @return The lon
	 */
	public Double getLon() {
		return lon;
	}

	/**
	 * 
	 * @param lon
	 *            The lon
	 */
	public void setLon(Double lon) {
		this.lon = lon;
	}

	/**
	 * 
	 * @return The org
	 */
	public String getOrg() {
		return org;
	}

	/**
	 * 
	 * @param org
	 *            The org
	 */
	public void setOrg(String org) {
		this.org = org;
	}

	/**
	 * 
	 * @return The query
	 */
	public String getQuery() {
		return query;
	}

	/**
	 * 
	 * @param query
	 *            The query
	 */
	public void setQuery(String query) {
		this.query = query;
	}

	/**
	 * 
	 * @return The region
	 */
	public String getRegion() {
		return region;
	}

	/**
	 * 
	 * @param region
	 *            The region
	 */
	public void setRegion(String region) {
		this.region = region;
	}

	/**
	 * 
	 * @return The regionName
	 */
	public String getRegionName() {
		return regionName;
	}

	/**
	 * 
	 * @param regionName
	 *            The regionName
	 */
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	/**
	 * 
	 * @return The status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * 
	 * @param status
	 *            The status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * 
	 * @return The timezone
	 */
	public String getTimezone() {
		return timezone;
	}

	/**
	 * 
	 * @param timezone
	 *            The timezone
	 */
	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	/**
	 * 
	 * @return The zip
	 */
	public String getZip() {
		return zip;
	}

	/**
	 * 
	 * @param zip
	 *            The zip
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}
}