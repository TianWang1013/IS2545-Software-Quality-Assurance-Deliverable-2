//package citysim9002;

import java.util.List;
import java.util.Random;

public class Person {
	String identify = "";
	public String person(Random r) {
		Visitor vis = new Visitor();
		List<String> randomListPerson = vis.person();
		String person = randomListPerson.get(r.nextInt(randomListPerson.size()));
		return person;
	}
	
	//set the identity of each visitor
	public void setIdentify(Random r){
		this.identify = person(r);
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
