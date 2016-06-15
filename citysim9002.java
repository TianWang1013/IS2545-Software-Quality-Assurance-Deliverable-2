package citysim9002;


import java.util.Random;

public class Citysim9002 { // an integer argument passed in from the command line as a seed	
	
	public static void main(String[] args) {
		int seed = 0;
		if (isInteger(args)) {
				seed = Integer.parseInt(args[0]);
				System.out.println("Welcome to CitySim!" + "  " + "Your seed is" + " " + seed + ".");
		} 
		else {
			System.err.println("Argument" + " " + args[0] + " must be just one integer.");
			System.exit(1);	
		} // an integer argument passed in from the command line	
//		
		Random r = new Random(Long.parseLong(args[0])); // set the random according to the seed
		
		Person ps = new Person();
		String person = ps.person(r);
		Place pc = new Place();
		String place = pc.place(r);

		for (int i = 1; i <6; i++) {
			System.out.println("Visitor" + " " + i + " " + "is a" + " " + person + "."); 
			// output the type of the visitor
			while (place == "has left the city.") {
				Place pc1 = new Place();
				place = pc1.place(r);
			} // to avoid visitor left the city for the first time
			while (place != "has left the city.") {

				System.out.println("Visitor" + " " + i + " " + "is going to" + " " + place + ".");
				
				if(perference(ps, place)) {
					System.out.println("Visitor" + " " + i + " " + "did like" + " " + place + ".");
				}
				else {
					System.out.println("Visitor" + " " + i + " " + "did not like" + " " + place + ".");
				}

				Place pc2 = new Place();
				place = pc2.place(r);
				// random the location
			}
	
			Person ps1 = new Person();
			person = ps1.person(r);
			
			System.out.println("Visitor" + " " + i + " " + place);
			System.out.println("***");	
			// output visitor left the city and with the '***' end line	
		} // end random for 5 times for 5 visitors	
	} // end main
	
	public static boolean isInteger(String[] args) {
		if (args.length != 1) {	
			return false;
		}
		try {
			Integer.parseInt(args[0]);
		} catch (NumberFormatException e) { // check whether the seed is an integer
			return false;
		} catch (NullPointerException e) { // check whether the seed is null
			return false;
		}
		return true;
	}// end isInteger
	
	public static boolean perference(Person person, String place) {		
		
		if (person.getIdentify() == "Student"){
			if (place == "The Cathedral of Learning") {
				return false;
			}
			else return true;
		} // A Student shall dislike The Cathedral of Learning, and like all other locations.
		if (person.getIdentify() == "Business Person") {
			if (place == "The Squirrel Hill" || place == "The Downtown") {
				return true;
			}
			else return false;
		} // A Business Person shall like Squirrel Hill and Downtown, and dislike all other locations.
		if (person.getIdentify() == "Professor") {
			return true;
		} // A Professor shall like all locations.  
		if (person.getIdentify() == "Blogger") {
			return false;
		} // A Blogger shall dislike all locations.
		return false;	
	} // end perference
} // end class
