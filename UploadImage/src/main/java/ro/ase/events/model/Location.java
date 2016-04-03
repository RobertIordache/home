package ro.ase.events.model;

import javax.persistence.Entity;

@Entity
public class Location {
	
	private int id;
	private Double latitude;
	private Double longitude;
	private String city;
	private String country;
	private String address;
	private String zipCode;
	

}
