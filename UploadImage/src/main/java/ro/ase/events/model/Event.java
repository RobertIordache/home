package ro.ase.events.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Event {

	private int id;
	private String title;
	private String description;
	private Date startDate;
	private Date endDate;
	private Date deadline;
	private int availableTickets;
	private String coverURL;
	private Double price;
	private User organizer;
	private EventType type;
	private Location location;
	private Set<User> participants=new HashSet<>();
	
}
