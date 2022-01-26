/*
 * Licensed under the Academic Free License (AFL 3.0).
 *     http://opensource.org/licenses/AFL-3.0
 *
 *  This code is distributed to CSULB students in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE, other than educational.
 *
 *  2018 Alvaro Monge <alvaro.monge@csulb.edu>
 *
 */

package csulb.cecs323.app;

import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import csulb.cecs323.model.Album;
import csulb.cecs323.model.AlbumPK;
import csulb.cecs323.model.Artist;
import csulb.cecs323.model.Song;
import csulb.cecs323.model.User;

/**
 * A simple application to demonstrate how to persist an object in JPA.
 *
 * This is for demonstration and educational purposes only.
 */
public class Homework4Application {
	//Creating entity manager for updating records in database
	private EntityManager entityManager;

	//Logs all activities specified by persistence.xml properties
	private static final Logger LOGGER = Logger.getLogger(Homework4Application.class.getName());

	
	public Homework4Application(EntityManager manager) {
		this.entityManager = manager;
	}

	/**
	 * Main function
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		LOGGER.fine("Creating EntityManagerFactory and EntityManager");
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("homework4_PU");
		EntityManager manager = factory.createEntityManager();
		Homework4Application hw4application = new Homework4Application(manager);

		// Any changes to the database need to be done within a transaction.
		// See: https://en.wikibooks.org/wiki/Java_Persistence/Transactions
		
		//Test transaction for errors with connecting to database
		LOGGER.fine("Begin of Transaction Test");
		EntityTransaction tx = manager.getTransaction();

		tx.begin();
		tx.commit();


		LOGGER.fine("End of Transaction Test");
		System.out.println("Done!");

		System.out.println("Press any key to continue...");
		sc.nextLine();
		
		//Booleans for the two loops within this while loop
		boolean exit1 = false; //For the main while loop
		boolean exit2 = false; //For testing out the queries
		
		
		//Prevent user from exiting program unless they actually choose actual exit case
		while (!exit1) {
			
			//User selection variable to choose through the following
			//switch-case sets.
			int input = 0;
			
			//Instantiating second boolean to allow user to query constantly.
			exit2 = false;
			
			//Prints out list of options available for main menu / main
			//switch-case statement set
			System.out.println(options);
			input = sc.nextInt();
			switch(input) {
				case 1: //Query tests and executions; while loop to allow the user
						//to query as much as they want. Additionally, incorrect inputs
						//into the input variable will prevent exiting properly.
					while(!exit2) {

						//Reset option selection to prevent automatic querying 
						input = 0;
						
						//Prints the list of queries available to execute
						System.out.println(queryOptions);
						//Get user input for selecting a query
						input = sc.nextInt();
						
						//Secondary switch-case set for set of queries with exit and default
						//statements included. Each query instantiates with the manager.createQuery()
						//and gets the String from the static query strings instantiated at the bottom
						//of this file. Additionally, for each selected attribute, the objects are
						//properly casted displayed for the user to see.
						switch(input) {
							
							case 1:
								Query q = manager.createQuery(q1);
								List<Object[]> list = q.getResultList();
								for (Object[] obj : list) {	//SELECT attributes converted into displayable data.
									String s1 = (String) obj[0];
									String s2 = (String) obj[1];
									String s3 = (String) obj[2];
									String s4 = (String) obj[3];
									System.out.println("First name: " + s1 + "\nLast name: " + s2 + "\nAlbum: " + s3 + "\nSong title: " + s4 + "\n");
								}
								break;
							case 2:
								q = manager.createQuery(q2);
								list = q.getResultList();
								for (Object[] obj : list) {
									String s1 = (String) obj[0];
									long s2 = (long) obj[1];
									double s3 = (double) obj[2];
									System.out.printf("Genre: %s\nNumber of songs: %d\nAverage song length (in minutes): %.2f\n\n", s1, s2, s3);
								}
								break;
							case 3:
								q = manager.createQuery(q3);
							    list = q.getResultList();
							    for (Object[] obj : list) {
							    	String s1 = (String) obj[0];
							    	String s2 = (String) obj[1];
							    	String s3 = (String) obj[2];
							    	System.out.println("First name: " + s1 + "\nLast name: " + s2 + "\nGenre: " + s3 + "\n");
							    }
			       		  		break;
			       		  	case 4:
			       		  		q = manager.createQuery(q4);
			       		  		list = q.getResultList();
			       		  		for (Object[] obj : list) {
			       		  			String s1 = (String) obj[0];
			       		  			String s2 = (String) obj[1];
			       		  			String s3 = (String) obj[2];
									System.out.println("First name: " + s1 + "\nLast name: " + s2 + "\nSong title: " + s3 + "\n");
			       		  		}
			       		  		break;
			       		  	case 5:
			       		  		q = manager.createQuery(q5);
			       		  		list = q.getResultList();
			       		  		for (Object[] obj : list) {
			       		  			String s1 = (String) obj[0];
			       		  			int s2 = (int) obj[1];
			       		  			int s3 = (int) obj[2];
			       		  			String s4 = (String) obj[3];
			       		  			int s5 = (int) obj[4];
			       		  			int s6 = (int) obj[5];
			       		  			System.out.println("Song title: " + s1 + "\nSong year released: " + s2 + "\nSong viewcount: " + s3
			       		  					+ "\nVideo title: " + s4 + "\nVideo year released: " + s5 + "\nVideo viewcount: " + s6 + "\n");
			       		  		}
			       		  		break;
			       		  	case 6:
			       		  		q = manager.createQuery(q6);
			       		  		list = q.getResultList();
			       		  		for (Object[] obj : list) {
			       		  			String s1 = (String) obj[0];
			       		  			String s2 = (String) obj[1];
									User.SubscriptionType s3 = (User.SubscriptionType) obj[2];
									String s4 = (String) obj[3];
									System.out.println("First name: " + s1 + "\nLast name: " + s2 + "\nSubscription level: " + s3.toString()
									+ "\nPreferred genre: " + s4 + "\n");
			       		  		}
			       		  		break;
			       		  	case 7:
			       		  		exit2 = true;
			       		  		break;
			       		  	default:
			       		  		System.out.println("Error! Invalid selection!");
			       		  		break;
						}
					}
					break;
					//End of query case
				case 2: //Adding artist entity
					input = 0;           	  		
					System.out.println("Please enter in app1roriate variables: \nFirst name: ");
					sc.nextLine();	//Placeholder to prevent undesirable data entry
					
					//Gather artist variables piece by piece, then creates the entity
					String fName = sc.nextLine().trim();
					System.out.println("Last name: ");
		            String lName = sc.nextLine().trim();
		            System.out.println("Birth month: ");
		            int month = sc.nextInt();
		            System.out.println("Birth day: ");
		            int day = sc.nextInt();
		            System.out.println("Birth year: ");
		            int year = sc.nextInt();
		            System.out.println("Approximately how many listen to him / her? ");
		            int nml = sc.nextInt();
		            System.out.println("Gender(M/F): ");
		            sc.nextLine();
		            String gender = sc.nextLine().trim();
		            
		            //Instantiating artist slightly prematurely
		            Artist a = new Artist(fName, lName, new GregorianCalendar(year, month, day), Artist.Sex.Male, nml);
		            
		            //Setting artist's gender based on String gender variable input
		            if (gender == "M") {
		            	a.setGender(Artist.Sex.Male);
		            }
		            else {	
		            	a.setGender(Artist.Sex.Female);
		            }
		            LOGGER.fine("Pushing to database...");
		            
		            //Begin adding to database
		            tx.begin();
	
		            //Allow user to map one existing song to this new artist before committing 
		            List<Song> allSongs = hw4application.entityManager.createNamedQuery(Song.FIND_ALL, Song.class).getResultList();
		            int i = 0;
		            for (Song song : allSongs) {
		            	System.out.println(String.valueOf(i) + ". " + song.toString());
		           		i++;
		            }
		           	System.out.println("Which song would you like this artist to be connected to?");
		           	Scanner in = new Scanner(System.in);
		           	int pick = in.nextInt();
	
		           	//Adds song to Artist a's songs array
		           	a.addSong(allSongs.get(pick));
		           	//Persist artist
		           	hw4application.entityManager.persist(a);
		           	
		           	//Complete transaction by committing
		           	tx.commit();
		           	LOGGER.fine("Commit complete!");
		        	break;
		        	//End of adding artist to database
				case 3: //Album to remove
					//Initial display to user of available albums for deletion
					List<Album> allAlbums = hw4application.entityManager.createNamedQuery(Album.FIND_ALL, Album.class).getResultList();
		        	i = 0;
		        	for (Album album : allAlbums) {
		        		System.out.println(String.valueOf(i) + ". " + album.toString());
		        		i++;
		        	}
	
		        	sc.nextLine(); //Prevent undesirable data entry
		        	
		        	//Ask user for specific album's primary key variables to remove
		        	System.out.println("Title of album to be removed: ");
		        	String title = sc.nextLine().trim();
		        	System.out.println("Month of release: ");
		        	month = sc.nextInt();
		        	//Must decrement to get proper month
		        	month -= 1;
		        	System.out.println("Day of release: ");
		        	day = sc.nextInt();
		        	System.out.println("Year of release: ");
		        	year = sc.nextInt();
		        	GregorianCalendar temp = new GregorianCalendar(year, month, day);
		        	System.out.println(temp.getTime());
		        	LOGGER.fine("Beginning deletion...");
		        	//Searches through all albums for deletion
		        	for (Album album : allAlbums) {
		        		if (title.equals(album.getTitle()) && temp.equals(album.getDateReleased())) {
		        			tx.begin();
		        			//Create AlbumPK entity for entityManager to find specified album for deletion
		        			AlbumPK albumPK = new AlbumPK(album.getTitle(), album.getDateReleased());
		        			Album rm = hw4application.entityManager.find(Album.class, albumPK);
		        			hw4application.entityManager.remove(rm);
		        			tx.commit();
		        		}
		        	}
		        	LOGGER.fine("Deletion successful.");
		        	break;
				case 4:	//Exit case
					sc.close();
					exit1 = true;
		        	break;
				default:
					System.out.println("Error! Invalid selection!");
		        	break;
			};
	    	  
		}
   }
	   
	   //Options list string displayed in main switch-case set
	   private static String options = "Select from the following options to execute (1-4): \n"
	   		+ "1. Execute a query\n"
	   		+ "2. Insert a new record\n"
	   		+ "3. Delete a record\n"
	   		+ "4. Exit";
	   
	   //Query options list displayed in nested switch-case set with a short description
	   //of what it is trying to retrieve.
	   private static String queryOptions = "Select which query to execute (1-6): \n"
	   		+ "1. For artists that have created at least an album, find the artist name,"
	   		+ "their most recent album and songs in that album.\n\n"
	   		+ "2. List the name of the genres, total number of songs in each genre,"
	   		+ " and average song length.\n\n"
	   		+ "3. Find the name of the artists who record only one genre and the genre title.\n\n"
	   		+ "4. For each female artists who have record at least 2 songs, find their name,"
	   		+ " and the title of their solo songs.\n\n"
	   		+ "5. List all Hip Hop songs in 2010’s, their play count,  their released year.\n"
	   		+ "In addition, list their official music video, release year and the view count if"
	   		+ " there is any.\n\n"
	   		+ "6. List the name of users who prefer only one type of genre, their subscription tier,"
	   		+ " and the genre name.\n\n"
	   		+ "7. Main menu";
	   
	   //Initially added for options for user to select and delete for each entity
	   /*private static String adddelRecordOptions = "Select which entity you want to add / delete to the database (1-6)\n"
	   		+ "1. Artist\n\n"
	   		+ "2. Album\n\n"
	   		+ "3. Song\n\n"
	   		+ "4. User\n\n"
	   		+ "5. Playlist\n\n"
	   		+ "6. Genre\n\n"
	   		+ "7. Main menu";*/
	   
/**************************************	Q U E R I E S **************************************/
	   //First query
	   private static String q1 = 
			  "SELECT a.fName AS Firstname, a.lName AS Lastname, al.title AS Album_Title,"
			+ " s.title AS SongsInAlbum"
		   	+ " FROM Artist a"
		   	+ " INNER JOIN a.albums al"
		   	+ " INNER JOIN al.songs s"
		   	+ " WHERE NOT EXISTS( SELECT a"
		   	+ " FROM Artist recArtist INNER JOIN recArtist.albums al2"
		   	+ " WHERE a.id = recArtist.id AND al.dateReleased < al2.dateReleased)" 
		   	+ " GROUP BY al.title, a.fName, a.lName, s.title"
			;
	   
	   //Second query
	   private static String q2 =
 				  "SELECT g.title, COUNT(DISTINCT g.songs) AS total_songs, AVG(s.length) / 60 AS avg_song_length"
		   		+ " FROM Genre g LEFT OUTER JOIN g.songs s" 
		   		+ " GROUP BY g.title"
		   		;
	   
	   //Third query
	   private static String q3 = 
				  "SELECT a1.fName AS Firstname, a1.lName AS Lastname, g1.title AS Genre"
				  + " FROM Artist a1"  
				  + " INNER JOIN a1.songs s1"
				  + " INNER JOIN s1.genres g1"
				  + " WHERE NOT EXISTS (SELECT a1 FROM Artist a2"
				  + " INNER JOIN a2.songs s2" 
				  + " INNER JOIN s2.genres g2" 
				  + " WHERE a1.id = a2.id AND g1.title <> g2.title)"
				  + " GROUP BY a1.id, a1.fName, a1.lName, g1.title"
		   		  ;
		   
	   private static String q4 =
				  "SELECT a1.fName AS Firstname, a1.lName AS Lastname, s1.title AS SongTitle"
		   		+ " FROM Artist a1"
		   		+ " INNER JOIN a1.songs s1"
		   		+ " WHERE a1.gender = csulb.cecs323.model.Artist.Sex.Female"
		   		+ " AND NOT EXISTS (SELECT a1"
		   		+ " FROM Artist a2"
		   		+ " WHERE a1.id <> a2.id AND a1.songs = a2.songs)"
		   		+ " GROUP BY a1.id, a1.fName, a1.lName, s1.title"
		   		+ " HAVING COUNT(a1.songs) >= 2" 
		   		;
		   
	   private static String q5 = 
				  "SELECT s1.title AS SongTitle, s1.yearReleased AS SongReleaseYear, s1.playCount AS PlayCount, v.title AS OfficialVideoTitle,"
				+ " v.yearReleased AS VideoReleaseYear, v.viewCount AS ViewCount"
		   		+ " FROM Song s1 LEFT OUTER JOIN s1.officialvideo v"
		   		+ " WHERE s1.yearReleased BETWEEN 2010 and 2018"
		   		+ " AND EXISTS (SELECT s1 FROM Song s2"
		   		+ " INNER JOIN s2.genres g"
		   		+ " WHERE s2.title = s1.title AND s2.yearReleased = s1.yearReleased AND g.title = 'Hip Hop')" 
		   		;
		   
	   private static String q6 = 
				  "SELECT u1.fName AS FirstName, u1.lName AS LastName, u1.subType AS SubscriptionType,"
				+ " g1.title AS Genre"
		   		+ " FROM User u1"
				+ " INNER JOIN u1.genres g1"
		   		+ " WHERE NOT EXISTS (SELECT u1 FROM User u2"
				+ " INNER JOIN u2.genres g2"
		   		+ " WHERE u1.id = u2.id AND g1.title <> g2.title)"
		   		;
}
