package ro.ase.events.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EVENT_TYPE")
public class EventType {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ID")
	private int id;
	
	@Column(name = "TITLE",nullable=false)
	private String title;
	
	@Column(name = "DESCRIPTION",nullable=false)
	private String description;
	
	
}
