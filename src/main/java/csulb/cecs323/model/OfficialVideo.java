
package csulb.cecs323.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * OfficialVideo class to model official music video of a song. 
 * It has some basic information such as title, length, date release, and view count.
 */
@Entity
@Table(name = "OfficialVideo")
public class OfficialVideo {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
   	private String title;
	private int yearReleased;
   	private int length; 				
   	private int viewCount;
   	

   	@OneToOne
    private Song song;
   	
   	
   	/**
   	 * Default constructor
   	 */
   	public OfficialVideo() {}
   	
   	
   	/**
   	 * Arguement Constructor
   	 * @param title - the title of the music video
   	 * @param yearReleased - year video released
   	 * @param length - the length of the video
   	 * @param viewCount - number of view the video have
   	 */
   	public OfficialVideo(String title, int yearReleased, int length, int viewCount) {
   		this.title = title;
   		this.yearReleased = yearReleased;
   		this.length = length;
   		this.viewCount = viewCount;
   	}

   	/**
   	 * Get the title of the video
   	 * @return a String represent the title of the video
   	 */
   	public String getTitle() {
   		return title;
   	}

   	/**
   	 * Set the title of the video
   	 * @param title - a String to set the title of the video to
   	 */
   	public void setTitle(String title) {
   		this.title = title;
   	}

   	/**
   	 * Get the year the video released
   	 * @return an int represent the year the video was released
   	 */
   	public int getReleaseYear() {
   		return yearReleased;
   	}
   	
   	/**
   	 * Set the year the video is released
   	 * @param yearReleased - an int to set the release year to
   	 */
   	public void setReleaseYear(int yearReleased) {
   		this.yearReleased = yearReleased;
   	}
   	
   	/**
   	 * get the length of the video
   	 * @return	an int represent the length of the video in seconds
   	 */
   	public int getLength() {
   		return length;
   	}
   	
   	/**
   	 * Set the length of the video
   	 * @param length - an int to set the length of the video to in seconds
   	 */
   	public void setLength(int length){
   		this.length = length;
   	}
   	
   	/**
   	 * get the play count of the video
   	 * @return an int represent the play count of the video
   	 */
   	public int getPlayCount() {
   		return viewCount;
   	}
   	
   	/**
   	 * Set the number of play of the video
   	 * @param playCount - an int represent the number of play of the video 
   	 */
   	public void setPlayCount(int playCount) {
   		this.viewCount = playCount;
   	}
   	
}
