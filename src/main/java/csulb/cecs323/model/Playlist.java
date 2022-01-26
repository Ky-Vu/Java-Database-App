package csulb.cecs323.model;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.TemporalType;
import javax.persistence.Temporal;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.ManyToMany;

/**
 * Playlist class to model the playlist a music streaming service subscriber has.
 * It contain some basic information such as name of the playlist, number of songs, 
 * total duration of songs in playlist.
 */
@Entity
@Table(name = "Playlist")
public class Playlist {
   @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   private String name;
   private int numOfSongs;
   
   private int totalDuration;
   
   @Temporal(TemporalType.DATE)
   private GregorianCalendar dateCreated;

   @ManyToOne
   private User owner;
   
   @ManyToMany
   @JoinTable(name = "SongInPlaylist")
   private List<Song> songs;
   
   
   /**
    * Default constructor
    */
   public Playlist() {
	   
   }
   
   /**
    * Arguement constructor
    * @param name - the name of the playlist
    * @param dateCreated - the date the playlist is created
    * @param numOfSongs - the number of song in the playlist
    * @param totalDuration - the duration of the sum of all songs in the playlist
    */
   public Playlist(String name, GregorianCalendar dateCreated, int numOfSongs, int totalDuration) {
	   this.name = name;
	   this.dateCreated = dateCreated;
	   this.numOfSongs = numOfSongs;
	   this.totalDuration = totalDuration;
   }
   
   /**
    * Get the id of the Playlist object which is the Primary key
    * @return
    */
   public Long getId() {
      return id;
   }

   /**
    * Set the id of the Playlist class
    * @param id - a Long data to set the id of the Playlist object
    */
   public void setId(Long id) {
      this.id = id;
   }

   /**
    * Get the name of the playlist
    * @return - a String represent the name of the playlist
    */
   public String getName() {
      return name;
   }

   /**
    * Set the name of the playlist
    * @param name - a String to set the name of the playlist to
    */
   public void setName(String name) {
      this.name = name;
   }

   /**
    * get the date the playlist was created
    * @return - a GregorianCalendar object represent the date the playlist created
    */
   public GregorianCalendar getDateCreated() {
      return dateCreated;
   }
   
   /**
    * Set the date the playlist created
    * @param dateCreated - a GregorianCalendar object 
    */
   public void setDateCreated(GregorianCalendar dateCreated) {
	   this.dateCreated = dateCreated;
   }
   
   /**
    * get the number of Song in the playlist
    * @return - an int represent the number of song in the playlist
    */
   public int getNumOfSongs() {
	   return numOfSongs;
   }
   
   /**
    * Set the number of songs in the playlist
    * @param numOfSongs - an int represent the number of song in the playlist
    */
   public void setNumOfSongs(int numOfSongs) {
	   this.numOfSongs = numOfSongs;
   }
   
   /**
    * get the total duration of all songs in the playlist
    * @return - an int represent the total duration of song in the playlist
    */
   public int getTotalDuration() {
	   return totalDuration;
   }
   
   /**
    * Set the total duration of songs in the playlist
    * @param totalDuration - an int to set the total duration of songs
    */
   public void setTotalDuration(int totalDuration) {
	   this.totalDuration = totalDuration;
   }
   
   /**
    * Get the owner object of this playlist 
    * @return - the User object represent the owner of the playlist
    */
   public User getOwner() {
	   return owner;
   }
   
   /**
    * Set the owner of this playlist
    * @param owner - a User object to be the owner of this playlist
    */
   public void setOwner(User owner) {
	   this.owner = owner;
   }
  
   /**
    * get all the songs in the playlist
    * @return - a List of Song objects in this playlist
    */
   public List<Song> getSongs(){
	   return songs;
   }
   
   /**
    * set the songs in this playlist
    * @param songs - a List of Song objects to set to this playlist
    */
   public void setSongs(List<Song> songs) {
	   this.songs = songs;
   }
   
   /**
    * add the song to the playlist
    * @param song - the Song object to be added to this playlist
    */
   public void addSong(Song song) {
	   if (this.songs == null) {
		   this.songs = new ArrayList<Song>();
	   }
	   
	   if (!song.getPlaylist().contains(this)) {
		   this.songs.add(song);
	   }
	   
	   if (song.getPlaylist().contains(this)) {
		   if (!this.songs.contains(song)) {
			   this.songs.add(song);
		   }
	   }
	   
   }
   
   
}