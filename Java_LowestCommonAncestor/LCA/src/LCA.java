import java.util.*;
public class LCA {	


	public String findAnchestors(HashMap<String,ArrayList<String>> relations, String person1, String person2) {
		String returned  = "", person1Ancest = "", person2Ancest = "";
		Boolean found = false;
		while(!found) {
			boolean parents = false;
			for (Map.Entry<String, ArrayList<String>> entry : relations.entrySet()) {
			    String key = entry.getKey();
			    ArrayList<String> value = entry.getValue();
			    //if the current Person is the parent of the two children in question
			    if(value.contains(person1) && value.contains(person2)) {
					returned =  key;
					found = true;
				}
			    //if the current Person is the parent of child 1
			    if(value.contains(person1)) {
					person1Ancest += key;
					person1 = key;
					parents = true;
					if(person2Ancest.contains(key)) return key;
				}
			    //if the current Person is the parent of child 2
			    if(value.contains(person2)) {
					person2Ancest += key;
					person2 = key;
					parents = true;
					if(person1Ancest.contains(key)) return key;	
				}
			}
			if(parents == false) break;
		}
		return returned;
	}

	public static void main(String[] args) {
	}

}
