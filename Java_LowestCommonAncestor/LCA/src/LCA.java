import java.util.*;
public class LCA {	


	public String findAnchestors(
			HashMap<String,ArrayList<String>> relations, String person1, String person2) {

		String returned = new String();
		boolean found = false;
		String person1Ancest = "", person2Ancest = "";
		String p1 = person1, p2 = person2;
		while(!found) {
			for (Map.Entry<String, ArrayList<String>> entry : relations.entrySet()) {
			    String key = entry.getKey();
			    ArrayList<String> value = entry.getValue();
			    if(value.contains(p1) && value.contains(p2)) {
					returned =  key;
					found = true;
				}
				if(value.contains(p1)) {
					person1Ancest += key;
					p1 = key;
					if(person2Ancest.contains(key)) return key;
				}
				if(value.contains(p2)) {
					person2Ancest += key;
					p2 = key;
					if(person1Ancest.contains(key)) return key;	
				}
				System.out.println(person1Ancest +" " + person2Ancest );
				 
				/* System.out.println(key + " : " + (value)); */
			}
		}
		System.out.println(relations.containsKey(person1));
		System.out.println(relations.containsKey(person2));
		return returned;
	}

	public static void main(String[] args) {
		LCA test1 = new LCA();

		HashMap<String,ArrayList<String>> relations2 =
				new HashMap<String,ArrayList<String>>();//Creating HashMap 
		relations2.put("A", new ArrayList<String>(Arrays.asList("B", "C")));
		relations2.put("C", new ArrayList<String>());
		relations2.put("B", new ArrayList<String>());

		HashMap<String,ArrayList<String>> relations1 =
				new HashMap<String,ArrayList<String>>();//Creating HashMap    

		relations1.put("A", new ArrayList<String>(Arrays.asList("C", "D")));
		relations1.put("B", new ArrayList<String>(Arrays.asList("C", "D")));
		relations1.put("C", new ArrayList<String>(Arrays.asList("E", "F")));
		relations1.put("E", new ArrayList<String>(Arrays.asList("G")));
		relations1.put("D", new ArrayList<String>());
		relations1.put("F", new ArrayList<String>());
		relations1.put("G", new ArrayList<String>());

		String y = test1.findAnchestors(relations2, "B", "C");
		String x = test1.findAnchestors(relations1, "F", "G");
		System.out.println("common ancestor : " + y);
		System.out.println("common ancestor : " + x);
	}

}
