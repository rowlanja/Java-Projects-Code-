import java.util.*;
public class LCA {	


	@SuppressWarnings("finally")
	public String findAnchestors(HashMap<String,ArrayList<String>> relations, String person1, String person2) {
		String returned  = "", person1Ancest = "", person2Ancest = "";
		Boolean found = false;
		try {
			while(!found) {
				boolean parents1 = false, parents2 = false;
				for (Map.Entry<String, ArrayList<String>> entry : relations.entrySet()) {
					String key = entry.getKey();
					ArrayList<String> value = entry.getValue();
					if(value.contains(person1) && value.contains(person2)) {
						System.out.println(person1 + " " + person2);
						returned =  key;
						found = true;
						break;
					}
					if(value.contains(person1)) {
						System.out.println("p1A " + person1Ancest);
						person1Ancest += key;
						person1 = key;
						parents1 = true;
						if(person2Ancest.contains(key)) {
							System.out.println("found " + key);
							returned = key;
							return key;
						}
					}
					if(value.contains(person2)) {
						System.out.println("p2a " + person2Ancest);
						person2Ancest += key;
						person2 = key;
						parents2= true;
						if(person1Ancest.contains(key)) {
							System.out.println("found " + key);
							returned = key;
							return key;
						}
					}
				}
				if(parents1 == false || parents2 == false) break;
			}
		} catch(Exception E) {
			System.out.println("Exception occured : " + E);
		}
		finally {
			return returned;
		}
	}

	public static void main(String[] args) {
		LCA test1 = new LCA();
		HashMap<String,ArrayList<String>> relations1 =
				new HashMap<String,ArrayList<String>>();//Creating HashMap    

		relations1.put("A", new ArrayList<String>(Arrays.asList("C", "D")));
		relations1.put("B", new ArrayList<String>(Arrays.asList("C", "D")));
		relations1.put("C", new ArrayList<String>(Arrays.asList("E", "F")));
		relations1.put("E", new ArrayList<String>(Arrays.asList("G")));
		relations1.put("D", new ArrayList<String>());
		relations1.put("F", new ArrayList<String>());
		relations1.put("G", new ArrayList<String>());
		relations1.put("Z", new ArrayList<String>(Arrays.asList("A")));

		String x = test1.findAnchestors(relations1, "F", "G");
		System.out.println("common ancestor : " + x);
	}

}
