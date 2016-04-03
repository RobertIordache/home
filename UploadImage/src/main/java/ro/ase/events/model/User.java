package ro.ase.events.model;

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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="USER")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private int id;
	
	@Column(name="FIRST_NAME",nullable=false)
	private String firstName;
	
	@Column(name="LAST_NAME",nullable=false)
	private String lastName;
	
	@Column(name="EMAIL",nullable=false)
	private String email;
	
	@Column(name="PASSWORD",nullable=false)
	private String password;
	
	@Column(name="AVATAR_URL",nullable=false)
	private String avatarURL;
	
	@Column(name="TYPE",nullable=false)
	private int type;
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name = "LOCATION_ID")
	private Location location;
	
	@ManyToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinTable(name="EVENTS_USERS",joinColumns={@JoinColumn(name="USER_ID",nullable=false)},
	inverseJoinColumns={@JoinColumn(name="EVENT_ID",nullable=false)})
	private Set<Event> events=new HashSet<>();
	
	
}
