package csulb.cecs323.model;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Enumerated;
import javax.persistence.TemporalType;
import javax.persistence.Temporal;

/**
 * User class to model basic information about music streaming service subscriber which contain 
 * some basic inforamtion such as name, email address, subscription level, subscription start 
 * and end date.
 */
@Entity
@Table(name = "User")
public class User {
	
	public enum SubscriptionType {
		   Basic, Premium
	}
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String fName;
	private String lName;
	private String email;
	
	@Enumerated(EnumType.STRING)
	private SubscriptionType subType;
   
	@Temporal(TemporalType.DATE)
	private GregorianCalendar subStart;
	@Temporal(TemporalType.DATE)
	private GregorianCalendar subEnd;
	
	@ManyToMany
	@JoinTable(name = "User_Genre")
	private List<Genre> genres;
   
	@OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
	private List<Playlist> playlists;
	
	/**
	 * Default constructor
	 */
	public User() {}
   
	
	/**
	 * Argument constructor
	 * @param fName - the first name of the user
	 * @param lName - the last name of the user
	 * @param email - the email of the user
	 * @param subType - the subscription level the user have
	 * @param subStart - the subscription start date
	 * @param subEnd - the subscription end date
	 */
	public User(String fName, String lName, String email, SubscriptionType subType, 
		   GregorianCalendar subStart, GregorianCalendar subEnd) {
	   
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.subType = subType;
		this.subStart = subStart;
		this.subEnd = subEnd;
	}
   
   
	/**
	 * Get the id of this user object
	 * @return - return a Long represent the id of the user
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Set the id of this user object
	 * @param id - a Long to set the user id to
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Get the first name of the user
	 * @return - a String represent the first name of the user
	 */
	public String getFirstName() {
		return fName;
	}

	/**
	 * Set the first name of the user
	 * @param fName - a String to set the first name of the user to
	 */
	public void setFirstName(String fName) {
		this.fName = fName;
	}

	/**
	 * get the last name of the user
	 * @return - a String represent the last name of the user
	 */
	public String getLastName() {
		return lName;
	}

	/**
	 * set the last name of the user
	 * @param lName - a String to set to the last name of the user
	 */
	public void setLastName(String lName) {
		this.lName = lName;
	}

	/**
	 * get the email of the user
	 * @return - a string represent the email of the user
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * set the email of the user
	 * @param email - a String to set the email of the user to
	 */
	public void setEmail(String email) {
		this.email = email;
	}
   
	/**
	 * get the subscription level the user have
	 * @return - return Subscription Enum represent the subscription level the user have
	 */
	public SubscriptionType getSubType() {
		return subType;
	}
   
	/**
	 * set the subscription level of the user
	 * @param subType - Subscription Enum to set the the user
	 */
	public void setSubcriptionType(SubscriptionType subType) {
		this.subType = subType;
	}
   
	/**
	 * Get the subscription start date of the user
	 * @return -  a GregorianCalendar object represent the start date of user subscription
	 */
	public GregorianCalendar getSubStartDate() {
		return subStart;
	}
	   
	/**
	 * Set the start date of user subscription 
	 * @param subStart - a GregorianCalendar object to set to as the
	 * start date of user subscription 
	 */
	public void setSubStartDate(GregorianCalendar subStart) {
		this.subStart = subStart;
	}
   
	/**
	 * Get the end date of user subscription
	 * @return a GregorianCalendar object represent the end date of user subscription
	 */
	public GregorianCalendar getSubEndDate() {
		return subEnd;
	}
	   
	/**
	 * Set the end date of user subscription
	 * @param subEnd - a GregorianCalendar object to set as
	 * the end date of user subscripion
	 */
	public void setSubEndDate(GregorianCalendar subEnd) {
		this.subEnd = subEnd;
	}
	
	/**
	 * get the genre the user prefers
	 * @return - a List of Genre objects the user prefer
	 */
	public List<Genre> getGenres() {
		return this.genres;
	}
	
	/**
	 * set the genre of the user 
	 * @param genres - a List of Genre object to set for the user
	 */
	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}
	
	/**
	 * Adds a Genre to the list of genres preferred by this user. As the relationship is bidirectional,
	 * this tests to be sure that the Genre's owner either has not been set yet or has been set to this User.
	 * Precondition: Genre's owner has been set to this User. If not, then, nothing is done.
	 * @param genre
	 */
	public void addGenre(Genre genre) {
		if (this.genres == null) {
			this.genres = new ArrayList<Genre>();
		}
		
		if (!genre.getPrefers().contains(this)) {
			this.genres.add(genre);
		}
		
		if (genre.getPrefers().contains(this)) {
			if (!this.genres.contains(genre)) {
				this.genres.add(genre);
			}
		}
	}
	
	/**
	 * get the playlist the user own
	 * @return - a Playlist object the user own
	 */
	public List<Playlist> getPlaylists() {
		return this.playlists;
	}

	/**
	 * Set the playlist of the user
	 * @param playlists - a Playlist object to set to the user
	 */
	public void setPlaylists(List<Playlist> playlists) {
		this.playlists = playlists;
	}
   
   
   /**
    * Adds a Playlist to the list of Playlists owned by this user. As the relationship is bidirectional,
    * this tests to be sure that the Playlist's owner either has not been set yet or has been set to this User.
    * Precondition: Playlist's owner has been set to this User. If not, then, nothing is done.
    *
    * @param playlist the Playlist being added to the customer
    */
	public void addPlaylist(Playlist playlist) {
		if (playlist.getOwner() == null) {
			playlist.setOwner(this);
		}
		
		if (playlist.getOwner().equals(this)) { //Only add this Playlist if the Playlist is owned by this customer

			if (this.playlists == null) {
				this.playlists = new ArrayList<>();
			}
			
			if (! this.playlists.contains(playlist)) { //avoid duplicates
				this.playlists.add(playlist);
			}
		}
	}	

   
   
}