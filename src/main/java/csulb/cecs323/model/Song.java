package csulb.cecs323.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Song class to model information about song such as title, length, play count
 * Billboard rating, release date
 */
@Entity
@Table(name = "Song")
@NamedQueries({
	@NamedQuery(name = Song.FIND_ALL, query = "SELECT s FROM Song s"),
	@NamedQuery(name = Song.FIND_BY_TITLE, query="SELECT s.title FROM Song s WHERE s.title=:title")
})
public class Song {
	
	/** Name of JPQL query to find all Song entities */
	public static final String FIND_ALL = "Song.findAll";

	/** Name of JPQL query to find Song entities by first and last name */
	public static final String FIND_BY_TITLE = "Song.findByName";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
   	private String title;
	private int yearReleased;	
   	private int length; 				
   	private int playCount;
   	private double rating;
   	private String language;
 
   	@ManyToMany(mappedBy = "songs")
   	private List<Artist> artists;
   	
   	@ManyToMany(mappedBy = "songs")
   	private List<Album> albums;
   	
   	@ManyToMany
   	@JoinTable(name = "SongGenre")
   	private List<Genre> genres;
    
    @OneToOne(mappedBy = "song", cascade = CascadeType.ALL)
    @JoinColumn(name = "songID", referencedColumnName = "id", nullable = false)
    private OfficialVideo officialvideo;
   
    @ManyToMany(mappedBy = "songs")
    private List<Playlist> playlists;

    /**
     * Default constructor
     */
   	public Song() {
   		
   	}
   	
   	/**
   	 * Arguement constructor
   	 * @param title - the string represent the title of the song
   	 * @param yearReleased - the year this song was released
   	 * @param length - the length of this song in seconds
   	 * @param playCount - the number of play of this song
   	 * @param rating - the US Billboard rating of this song
   	 * @param language - the language this song is in
   	 */
   	public Song(String title, int yearReleased, int length, int playCount,
   			double rating, String language) {
   		this.title = title;
   		this.yearReleased = yearReleased;
   		this.length = length;
   		this.playCount = playCount;
   		this.rating = rating;
   		this.language = language;
   	}

   	/**
   	 * Gets the title of the song
   	 * @return the title of the song
   	 */
   	public String getTitle() {
   		return title;
   	}

   	/**
   	 * Sets the title of the song
   	 * @param title - title of the song
   	 */
   	public void setTitle(String title) {
   		this.title = title;
   	}

   	/**
   	 * Gets the release date of the song
   	 * @return release date of the song
   	 */
   	public int getReleaseYear() {
   		return yearReleased;
   	}
   	
   	/**
   	 * Sets the release date of the song
   	 * @param yearReleased - release date of the song
   	 */
   	public void setReleaseYear(int yearReleased) {
   		this.yearReleased = yearReleased;
   	}
   	
   	/**
   	 * Gets the duration of the song in seconds
   	 * @return duration of the song in seconds
   	 */
   	public int getLength() {
   		return length;
   	}
   	
   	/**
   	 * Sets the duration of the song in seconds
   	 * @param length - duration of the song in seconds
   	 */
   	public void setLength(int length){
   		this.length = length;
   	}
   	
   	/**
   	 * Gets the amount of times the song was played
   	 * @return amount of times the song was played
   	 */
   	public int getPlayCount() {
   		return playCount;
   	}
   	
   	/**
   	 * Sets the amount of times the song was played
   	 * @param playCount - amount of times the song was played
   	 */
   	public void setPlayCount(int playCount) {
   		this.playCount = playCount;
   	}
   	
   	/**
   	 * Gets the billboard rating of the song
   	 * @return the rating of the song
   	 */
   	public double getRating() {
   		return rating;
   	}
   	
   	/**
   	 * Sets the billboard rating of the song
   	 * @param rating - the billboard rating of the song
   	 */
   	public void setRating(double rating) {
   		this.rating = rating;
   	}
   	
   	/**
   	 * Gets the language that the song was sung in
   	 * @return language that the song was sung in
   	 */
   	public String getLanguage() {
   		return language;
   	}
   	
   	/**
   	 * Sets the language that the song was sung in
   	 * @param language - language that the song was sung in
   	 */
   	public void setLanguage(String language) {
   		this.language = language;
   	}
   	
   	/**
   	 * Gets all the artists that created this song
   	 * @return the artists that created this song
   	 */
   	public List<Artist> getArtists() {
   		return this.artists;
   	}
   	
   	/**
   	 * Sets the artists that created this song
   	 * @param artists - artists that created this song
   	 */
   	public void setArtists(List<Artist> artists) {
   		this.artists = artists;
   	}
   	
   	/**
   	 * Adds an artist to the list of who helped made the song
   	 * @param artist - new artist who helped made the song
   	 */
   	public void addArtist(Artist artist) {
   		if (this.artists == null) {
   			this.artists = new ArrayList<Artist>();
   		}
   		
   		if (!artist.getSongs().contains(this)) {
   			this.artists.add(artist);
   		}
 	   
   		if (artist.getSongs().contains(this)) {
   			if (!this.artists.contains(artist)) {
   				this.artists.add(artist);
   			}
   		}
   	}
   	
   	/**
   	 * Gets the list of albums that this song is featured in
   	 * @return the list of albums that this song is featured in
   	 */
   	public List<Album> getAlbums() {
   		return this.albums;
   	}
   	
   	/**
   	 * Sets the list of albums that this song is featured in
   	 * @param albums - list of albums that this song is featured in
   	 */
   	public void setAlbums(List<Album> albums) {
   		this.albums = albums;
   	}
   	
   	/**
   	 * Adds an album to the list of albums that this song is featured in
   	 * @param album - new album that this song is featured in
   	 */
   	public void addAlbum(Album album) {
   		if (this.albums == null) {
   			this.albums = new ArrayList<Album>();
   		}
   		
   		if (!album.getSongs().contains(this)) {
   			this.albums.add(album);
   		}
 	   
   		if (album.getSongs().contains(this)) {
   			if (!this.albums.contains(album)) {
   				this.albums.add(album);
   			}
   		}
    }
   	
   	/**
   	 * Gets all the genres this song is about
   	 * @return the genres this song is about
   	 */
   	public List<Genre> getGenres() {
   		return this.genres;
   	}
   	
   	/**
   	 * Sets all the genres this song is about
   	 * @param genres - the genres this song is about
   	 */
   	public void setGenres(List<Genre> genres) {
   		this.genres = genres;
   	}
   	
   	/**
   	 * Adds a genre nature to the song
   	 * @param genre - the genre this song is part of
   	 */
   	public void addGenre(Genre genre) {
   		if (this.genres == null) {
   			this.genres = new ArrayList<Genre>();
   		}
   		if (!genre.getSongs().contains(this)) {
   			this.genres.add(genre);
   		}
   		
   		if (genre.getSongs().contains(this)) {
   			if (!this.genres.contains(genre)) {
   				this.genres.add(genre);
   			}
   		}
   	}
   	
   	/**
   	 * Gets all the playlists this song is featured in
   	 * @return playlists this song is featured in
   	 */
   	public List<Playlist> getPlaylist() {
   		return this.playlists;
   	}
   	
   	/**
   	 * Sets all the playlists this song is featured in
   	 * @param playlists - playlists this song is featured in
   	 */
   	public void setPlaylist(List<Playlist> playlists) {
   		this.playlists = playlists;
   	}
   	
   	/**
   	 * Adds a new playlist to the list of playlists this song is featured in
   	 * @param playlist - playlist this song is featured in
   	 */
   	public void addPlaylist(Playlist playlist) {
   		if (this.playlists == null) {
   			this.playlists = new ArrayList<Playlist>();
   		}
   		if (!playlist.getSongs().contains(this)) {
   			this.playlists.add(playlist);
   		}
 	   
   		if (playlist.getSongs().contains(this)) {
   			if (!this.playlists.contains(playlist)) {
   				this.playlists.add(playlist);
   			}
   		}
    }
   	
   	public String toString() {
   		return String.format("\nTitle: %s\nLength: %d\nRating: %f", this.getTitle(), this.getLength(), this.getRating());
   	}
   	

}