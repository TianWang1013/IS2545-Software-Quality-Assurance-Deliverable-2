//package citysim9002;

import java.util.List;
import java.util.Random;

public class Place {
	String identify = "";
	public String place(Random r) {
		Location loc = new Location();
		List<String> randomListPlace = loc.place();	
		
		String place = randomListPlace.get(r.nextInt(randomListPlace.size()));
		return place;
	}	
	
	//set the identity of each visitor
	public void setIdentify(Random r){
		this.identify = place(r);
	}
	//set the identity of each visitor
	public void setIdentify(String id){
		this.identify = id;
	}
		
	//get the identity of each visitor
	public String getIdentify(){
		return identify;
	}
}
