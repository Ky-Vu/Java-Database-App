package csulb.cecs323.model;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.ManyToMany;
import javax.persistence.JoinTable;

/**
 * Album class to model albums in a Music Streaming database; an Album is created by an Artist and has songs in it.
 *
 */
@Entity
@IdClass(AlbumPK.class)
@Table(name = "Album")
@NamedQueries({
	@NamedQuery(name = Album.FIND_ALL, query = "SELECT al FROM Album al"),
	@NamedQuery(name = Album.FIND_BY_TITLE, query="SELECT al.title FROM Album al WHERE al.title=:title")
})

public class Album {
	
	/** Name of JPQL query to find all Album entities */
	public static final String FIND_ALL = "Album.findAll";

	/** Name of JPQL query to find Album entities by first and last name */
	public static final String FIND_BY_TITLE = "Album.findByName";
	
	@Id
	private String title;
	@Id @Temporal(TemporalType.DATE)
	private GregorianCalendar dateReleased;
	private double revenue;
	private int numSongs;
	
	@ManyToOne
	private Artist artist;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "SongInAlbum",
			joinColumns = {
					@JoinColumn(name = "albumTitle", referencedColumnName = "title", nullable = true),
					@JoinColumn(name = "albumReleaseDate", referencedColumnName = "dateReleased", nullable = true),
			},
			inverseJoinColumns =
					@JoinColumn(name = "songID", referencedColumnName = "id", nullable = true)
	)
	private List<Song> songs;
	
	/*
	 * Empty constructor
	 */
	public Album() {}
	
	/**
	 * 
	 * @param title - this is the title of the album
	 * @param dateReleased - has month, day, year the album was released
	 */
	public Album(String title, GregorianCalendar dateReleased) {
		this.title = title;
		this.dateReleased = dateReleased;
	}
	
	
	/**
	 * 
	 * @param title - this is the title of the album
	 * @param dateReleased - has month, day, year the album was released
	 * @param revenue - the amount of revenue the album created
	 * @param numSongs - the amount of songs in the album
	 */
	public Album(String title, GregorianCalendar dateReleased, double revenue, int numSongs) {
		this.title = title;
		this.dateReleased = dateReleased;
		this.revenue = revenue;
		this.numSongs = numSongs;
	}
	
	/**
	 * this function returns the title
	 * @return
	 */
	public String getTitle() {
		return this.title;
	}
	
	
	/**
	 * this function sets the Album title
	 * @param title - title for the album
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * using the GregorianCalendar function to return the date
	 * @return
	 */
	public GregorianCalendar getDateReleased() {
		return this.dateReleased;
	}
	
	
	/**
	 * sets the 
	 * @param dateReleased
	 */
	public void setDateReleased(GregorianCalendar dateReleased) {
		this.dateReleased = dateReleased;
	}
	
	
	/**
	 * this function returns the album revenue
	 * @return
	 */
	public double getRevenue() {
		return this.revenue;
	}
	
	/**
	 * this function sets the album revenue
	 * @param revenue
	 */
	public void setRevenue(double revenue) {
		this.revenue = revenue;
	}
	
	/**
	 * this function returns the number of songs in an album
	 * @return
	 */
	public int getNumSongs() {
		return this.numSongs;
	}
	
	/**
	 * this function sets the number of songs in an album
	 * @param numSongs
	 */
	public void setNumSongs(int numSongs) {
		this.numSongs = numSongs;
	}
	
	/**
	 * this function returns the name of the artist of the album
	 * @return
	 */
	public Artist getArtist() {
		return this.artist;
	}
	
	/**
	 * this function sets the artist of the album
	 * @param artist
	 */
	public void setArtist(Artist artist) {
		this.artist = artist;
	}
	
	/**
	 * this function returns the list of songs in an album
	 * @return
	 */
	public List<Song> getSongs() {
		return this.songs;
	}
	
	/**
	 * this function sets the list of songs in an album
	 * @param songs
	 */
	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}
	

	/**
	 * if a user wants to add a song to the database, 
	 * this function checks if it is in or not and adds it to the database
	 * @param song
	 */

	public void addSong(Song song) {
		if (this.songs == null) {
			this.songs = new ArrayList<Song>();
		}
		
		if (!song.getAlbums().contains(this)) {
			   this.songs.add(song);
		}
		   
		if (song.getAlbums().contains(this)) {
			if (!this.songs.contains(song)) {
				this.songs.add(song);
			}
		}
	}
	

	/**
	 * this function returns the name of the album, in a string format
	 */
	public String toString() {
		String album = String.format("Title: %s%nReleased: %tD", this.getTitle(), this.getDateReleased());
		return album;
	}
	

}
