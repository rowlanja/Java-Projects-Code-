import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class LCA_Tester {
	public static void main() {
		LCA test1 = new LCA();
		test1.relations = new HashMap<String,ArrayList<String>>();
		test1.relations.put("A", new ArrayList<String>(Arrays.asList("C", "D")));
		test1.relations.put("B", new ArrayList<String>(Arrays.asList("C", "D")));
		test1.relations.put("C", new ArrayList<String>(Arrays.asList("E", "F")));
		test1.relations.put("D", new ArrayList<String>());
		test1.relations.put("E", new ArrayList<String>(Arrays.asList("G")));
		test1.relations.put("F", new ArrayList<String>());
		test1.relations.put("G", new ArrayList<String>());
		
		
		ArrayList<String> x = test1.findAnchestors("F", "G");
		System.out.println(x);
	}
}
