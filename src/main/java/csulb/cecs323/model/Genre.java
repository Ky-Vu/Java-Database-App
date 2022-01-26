package csulb.cecs323.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Genre class is to model the popular Genre of a song. It has just the genre name. 
 */
@Entity
@Table(name = "Genre")
public class Genre {
   
   @Id
   private String title;
   
   @ManyToMany(mappedBy = "genres", cascade = CascadeType.PERSIST)
   private List<Song> songs;
   
   @ManyToMany(mappedBy = "genres", cascade = CascadeType.PERSIST)
   private List<User> users;
   
   /**
    * Empty constructor
    */
   public Genre() {}
   
   /**
    * @param title - title of a genre
    */
   public Genre(String title) {
	   this.title = title;
   }
   
   /**
    * this function returns the title of a genre
    * @return
    */
   public String getTitle() {
	   return title;
   }
   
   public void setTitle(String title){
	   this.title = title;
   }
   
   /**
    * this function returns a list of users who prefer a certain genre
    * @return
    */
   public List<User> getPrefers(){
	   return this.users;
   }
   
   
   public void setPrefers(List<User> users) {
	   this.users = users;
   }
   
   /**
    * this function checks the genre that the user wants to add
    * checks if the genre already exists or not
    * @param user
    */
   public void addPrefers(User user) {
	   if (this.users == null) {
		   this.users = new ArrayList<User>();
	   }
	   
	   if (!user.getGenres().contains(this)) {
		   this.users.add(user);
	   }
	   
	   if (user.getGenres().contains(this)) {
		   if (!this.users.contains(user)) {
			   this.users.add(user);
		   }
	   }
   }
   
   /**
    * function returns a list of songs within a certain genre
    * @return
    */
   public List<Song> getSongs(){
	   return this.songs;
   }
   
   public void setSongs(List<Song> songs) {
	   this.songs = songs;
   }
   
   /**
    * when a user adds a song, this function checks if that song already exists in that genre
    * or not.
    * @param song
    */
   public void addSong(Song song) {
	   if (this.songs == null) {
		   this.songs = new ArrayList<Song>();
	   }
	   
	   if (!song.getGenres().contains(this)) {
		   this.songs.add(song);
	   }
	   
	   if (song.getGenres().contains(this)) {
		   if (!this.songs.contains(song)) {
			   this.songs.add(song);
		   }
	   }
   }
   
   
}