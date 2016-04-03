package ro.ase.events.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="EVENT")
public class Event {

	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private int id;
	
	
	@Column(name="TITLE",nullable=false)
	private String title;
	
	@Column(name="DESCRIPTION",nullable=false)
	private String description;
	
	@Column(name="START_DATE",nullable=false)
	private Date startDate;
	
	@Column(name="END_DATE",nullable=false)
	private Date endDate;
	
	@Column(name="DEADLINE",nullable=false)
	private Date deadline;
	
	@Column(name="AVAILABLE_TICKETS",nullable=false)
	private int availableTickets;
	
	@Column(name="COVER_URL",nullable=false)
	private String coverURL;
	
	@Column(name="PRICE",nullable=false)
	private Double price;
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="ORGANIZER_ID")
	private User organizer;
	
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="EVENT_TYPE_ID")
	private EventType type;
	

	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="LOCATION_ID")
	private Location location;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "events")
	private Set<User> participants=new HashSet<>();
	
}
