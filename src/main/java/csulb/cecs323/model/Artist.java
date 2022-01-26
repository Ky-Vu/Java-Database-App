package csulb.cecs323.model;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Artist class to model artists in a Music Streaming database; an Artist records songs and complates an album but they
 * are not required to do so
 *
 */

@Entity
@Table(name = "Artist")
@NamedQueries({
	@NamedQuery(name = Artist.FIND_ALL, query = "SELECT a.fName, a.lName FROM Artist a"),
	@NamedQuery(name = Artist.FIND_BY_NAME, query="SELECT a.fName, a.lName FROM Artist a WHERE a.fName=:fName AND a.lName=:lName")
})
public class Artist {
	
	/** Name of JPQL query to find all Artist entities */
	public static final String FIND_ALL = "Artist.findAll";

	/** Name of JPQL query to find Artist entities by first and last name */
	public static final String FIND_BY_NAME = "Artist.findByName";
	
	
	
	public enum Sex {
		Male,
		Female
	}
	
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   private String fName;
   private String lName;
   @Temporal(TemporalType.DATE)
   private GregorianCalendar DOB;
   private double numOfMonthlyListeners;

   @Enumerated(EnumType.STRING)
   private Sex gender;
   
   @OneToMany(mappedBy = "artist", cascade = CascadeType.ALL)
   private List<Album> albums;
   
   @ManyToMany(cascade = CascadeType.ALL)
   @JoinTable(name = "SongRecord")
   private List<Song> songs;
   
   /*
    * Empty constructor
    */
   public Artist() {}
   
   /**
    * 
    * @param fName - first name of an Artist
    * @param lName - last name of an Artist
    */
   public Artist(String fName, String lName) {
	   this.fName = fName;
	   this.lName = lName;
   }
   
   
   /**
    * 
    * @param fName - first name of an Artist
    * @param lName - last name of an Artist
    * @param DOB - date of birth of Artist
    * @param gender - binary options for Artist
    * @param numMonthlyListener - number of monthly listeners that an Artist has
    */
   public Artist(String fName, String lName, GregorianCalendar DOB, Sex gender, double numMonthlyListener) {
	   this.fName = fName;
	   this.lName = lName;
	   this.DOB = DOB;
	   this.gender = gender;
	   this.numOfMonthlyListeners = numMonthlyListener;
   }

   /**
    * this function returns a unique id for each artist
    * @return
    */
   public Long getId() {
      return id;
   }

   /**
    * this function sets a unique id for each artist
    * @param id
    */
   public void setId(Long id) {
      this.id = id;
   }

   /**
    * this function returns the first name of an artist
    * @return
    */
   public String getFirstName() {
      return fName;
   }

   /**
    * this function sets the first name of an artist
    * @param fName
    */
   public void setFirstName(String fName) {
      this.fName = fName;
   }

   /**
    * this function returns the last name of an artist
    * @return
    */
   public String getLastName() {
      return lName;
   }

   /**
    * this function sets the last name of an artist
    * @param lName
    */
   public void setLastName(String lName) {
      this.lName = lName;
   }

   /**
    * this function uses the GregorianCalendar function to return the date of birth of an Artist
    * @return
    */
   public GregorianCalendar getDOB() {
	   return DOB;
   }
   
   /**
    * this function sets the date of birth of an Artist
    * @param DOB
    */
   public void setDOB(GregorianCalendar DOB) {
	   this.DOB = DOB;
   }

   /**
    * this function returns the number of monthly listeners that an Artist has
    * @return
    */
   public double getNumMonthlyListeners() {
	   return this.numOfMonthlyListeners;
   }

   /**
    * this function sets the number of monthly listeners that an Artist has
    * @param numOfMonthlyListeners
    */
   public void setNumMonthlyListeners(double numOfMonthlyListeners) {
	   this.numOfMonthlyListeners = numOfMonthlyListeners;
   }

   /**
    * this function returns the gender of an Artist
    * @return
    */
   public Sex getGender() {
	   return this.gender;
   }

   /**
    * this function sets the gender of an artist
    * @param gender
    */
   public void setGender(Sex gender) {
	   this.gender = gender;
   }
   
   /**
    * this function returns a list of albums that an artist may have
    * @return
    */
   public List<Album> getAlbums() {
	   return this.albums;
   }
   
   /**
    * this function sets the list of albums that an artist may have
    * @param albums
    */
   public void setAlbums(List<Album> albums) {
	   this.albums = albums;
   }
   
   /**
    * if a user wants to add an album to an artist this function checks if the 
    * album exists or not
    * @param album
    */
   public void addAlbum(Album album) {
	   if (album.getArtist() == null) {
		   album.setArtist(this);
	   }
	   
	   if (album.getArtist().equals(this)) {
		   if (this.albums == null) {
			   this.albums = new ArrayList<>();
		   }
		   
		   if (!this.albums.contains(album)) {
			   this.albums.add(album);
		   }
		   
	   }
   }
   
   /**
    * this function returns a list of songs that an Artist has recorded
    * @return
    */
   public List<Song> getSongs() {
	   return this.songs;
   }
   
   /**
    * this function sets a list of songs that an Artist has recorded
    * @param songs
    */
   public void setSongs(List<Song> songs) {
	   this.songs = songs;
   }
   
   /**
    * if a user wants to add a song to an artist, this function checks if it is in the 
    * database or not
    * @param song
    */
   public void addSong(Song song) {
	   if (this.getSongs() == null) {
		   this.songs = new ArrayList<Song>();
	   }
	   
	   if (!song.getArtists().contains(this)) {
		   this.songs.add(song);
	   }
	   
	  if (song.getArtists().contains(this)) {
		   if (!this.songs.contains(song)) {
			   this.songs.add(song);
		   }
	   }
   }
   
   /**
    * this function returns the first name, last name, gender, DoB, and monthly listeners of an Artist
    */
   public String toString() {
	   String artist = String.format("%s %s,", this.getFirstName(), this.getLastName());
	   artist += String.format(" %s%n", this.getGender());
	   artist += String.format("Born: %tD%n%d", this.getDOB(), this.getNumMonthlyListeners());
	   return artist;
   }
}