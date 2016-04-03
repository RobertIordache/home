package ro.ase.events.model;

import java.util.HashSet;
import java.util.Set;

public class User {

	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String avatarURL;
	private int type;
	private Location location;
	private Set<Event> events=new HashSet<>();
	
	
}
