package citysim9002;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class citysim9002 { // an integer argument passed in from the command line as a seed
	public static void main(String[] args) {
		if (args.length == 1) {			
			try {
				int firstArg = Integer.parseInt(args[0]);
				System.out.println("Welcome to CitySim!" + "  " + "Your seed is" + " " + firstArg + ".");
			} catch (NumberFormatException e) { // check whether the seed is an integer
				System.err.println("Argument" + " " + args[0] + " must be an integer.");
				System.exit(1);
			}
		} 
		else {
			System.err.println("Argument" + " " + args[0] + " must be just one integer.");
			System.exit(1);	
		} // an integer argument passed in from the command line	
		
		Random r = new Random(Long.parseLong(args[0])); // set the random according to the seed
		
		List<String> randomListPerson = new ArrayList<String>();
		randomListPerson.add("Student");
		randomListPerson.add("Professor");
		randomListPerson.add("Business Person");
		randomListPerson.add("Blogger");
		Random randomperson = r;
		String person = randomListPerson.get(randomperson.nextInt(randomListPerson.size()));
		// random a visitor from four visitors
		
		List<String> randomListPlace = new ArrayList<String>();
		randomListPlace.add("The Cathedral of Learning");
		randomListPlace.add("The Squirrel Hill");
		randomListPlace.add("The Point");
		randomListPlace.add("The Downtown");
		randomListPlace.add("has left the city.");
		Random randomplace = r;
		String place = randomListPlace.get(randomplace.nextInt(randomListPlace.size()));
		//random a location from five locations
		
		List<String> randomListLike = new ArrayList<String>();
		randomListLike.add("did like");
		randomListLike.add("did not like");
		Random randomlike = r;
		String like = randomListLike.get(randomlike.nextInt(randomListLike.size()));
		//random whether the visitor did like the location or not
		
		for (int i = 1; i <6; i++) {
			
			System.out.println("Visitor" + " " + i + " " + "is a" + " " + person + "."); 
			// output the type of the visitor
			
			while (place == "has left the city.") {
				place = randomListPlace.get(randomplace.nextInt(randomListPlace.size()));
			} // to avoid visitor left the city for the first time
			while (place != "has left the city.") {
				if (person == "Student"){
					if (place == "The Cathedral of Learning") {
						like = "did not like";
					}
					else like = "did like";
				} // A Student shall dislike The Cathedral of Learning, and like all other locations.
				if (person == "Business Person") {
					if (place == "The Squirrel Hill" || place == "The Downtown") {
						like = "did like";
					}
					else like = "did not like";
				} // A Business Person shall like Squirrel Hill and Downtown, and dislike all other locations.
				if (person == "Professor") {
					like = "did like";
				} // A Professor shall like all locations.  
				if (person == "Blogger") {
					like = "did not like";
				} // A Blogger shall dislike all locations.
				
				System.out.println("Visitor" + " " + i + " " + "is going to" + " " + place + ".");
				System.out.println("Visitor" + " " + i + " " + like+ " " + place + ".");
				// output where the visitor is going to and the visitor did like it or not

				place = randomListPlace.get(randomplace.nextInt(randomListPlace.size()));
				like = randomListLike.get(randomlike.nextInt(randomListLike.size()));
				// random the location and whether the visitor did like the location or not
			}
			
			person = randomListPerson.get(randomperson.nextInt(randomListPerson.size()));
			
			System.out.println("Visitor" + " " + i + " " + place);
			System.out.println("***");	
			// output visitor left the city and with the '***' end line	
		} // end random for 5 times for 5 visitors		
	} // end main
} // end class
