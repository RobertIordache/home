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

	public User(String email, String password) {
		super();
		
		
		this.email = email;
		this.password = password;
		this.avatarURL =  "someCoverURL";
		this.type = 1;
		this.location = new Location("Bucharest","Romania","unknow");
		this.firstName =email;
		this.lastName = email;
	}

	public User() {
		super();
	}

	public User setId(int id) {
		this.id = id;
		return this;
	}

	public User setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public User setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public User setEmail(String email) {
		this.email = email;
		return this;
	}

	public User setPassword(String password) {
		this.password = password;
		return this;
	}

	public User setAvatarURL(String avatarURL) {
		this.avatarURL = avatarURL;
		return this;
	}

	public User setType(int type) {
		this.type = type;
		return this;
	}

	public User setLocation(Location location) {
		this.location = location;
		return this;
	}

	public User setEvents(Set<Event> events) {
		this.events = events;
		return this;
	}

	public int getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getAvatarURL() {
		return avatarURL;
	}

	public int getType() {
		return type;
	}

	public Location getLocation() {
		return location;
	}

	public Set<Event> getEvents() {
		return events;
	}
	
	public User build(){
		return this;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", avatarURL=" + avatarURL + ", type=" + type + ", location=" + location
				+ ", events=" + events + "]";
	}
	
	
	
}
