import bridges.connect.Bridges;
import bridges.connect.DataSource;
import bridges.data_src_dependent.ActorMovieIMDB;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
public class Lab5 {
	public static void main(String[] args) {
	//create the Bridges object
	Bridges bridges = new Bridges(5, "shellam", "V00867109");
	DataSource ds = bridges.getDataSource();
	List<ActorMovieIMDB> movieData = null;
	List<ActorMovieIMDB> actorNames = new ArrayList();
	try {
	movieData = ds.getActorMovieIMDBData();
	}
	catch (Exception e) {
	System.out.println("Unable to connect to Bridges.");
	}
	//loop that displays the actor and movie title for the first 5 objects in the lis
	for(int i = 0; i < 5; i++) {
		ActorMovieIMDB entry = movieData.get(i); 
		//System.out.println("" + i + ". " + entry.getActor() + " was in " + entry.getMovie());
		}
	/*use enhanced for loop to iterate through a certain movie and add
	**all of its actors to the actor names list
	**/
	for ( ActorMovieIMDB movieActors : movieData) {
		if (movieActors.getMovie().equals("Being_John_Malkovich_(1999)")) {

			actorNames.add(movieActors);
		}
		
	}
	//using anon class to include comparator class inside the sort method
	 Collections.sort(actorNames, new Comparator<ActorMovieIMDB>(){
		 public int compare(ActorMovieIMDB o1, ActorMovieIMDB o2) {
			// TODO Auto-generated method stub
				
			 return o1.getActor().compareTo(o2.getActor()); 
		 }
	 });
 //Collections.sort(actorNames, new ActorComparator());
 for (ActorMovieIMDB printActors : actorNames) {
		System.out.println(printActors.getActor());
 }
}
}