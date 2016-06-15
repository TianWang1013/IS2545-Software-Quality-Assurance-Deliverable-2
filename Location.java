package citysim9002;

import java.util.ArrayList;
import java.util.List;

public class Location{
	
	public List<String> place() {
		List<String> randomListPlace = new ArrayList<String>();
		
		randomListPlace.add("The Cathedral of Learning");
		randomListPlace.add("The Squirrel Hill");
		randomListPlace.add("The Point");
		randomListPlace.add("The Downtown");
		randomListPlace.add("has left the city.");
		
		return randomListPlace;
		//random a location from five locations
	}
}
