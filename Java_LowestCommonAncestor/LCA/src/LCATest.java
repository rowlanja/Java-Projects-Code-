import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import org.junit.jupiter.api.Test;

public class LCATest {

	
	// MEDIUM SIZED FAMILY TREE
	@Test
	void test1() {
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

		String x = test1.findAnchestors(relations1, "F", "G");
		System.out.println("common ancestor : " + x);
		assertEquals(x, "C", "Common Ancestor must be C");
	}
	// TEST OF SMALL FAMILY TREE
	@Test
	void test2() {
		LCA test1 = new LCA();
		HashMap<String,ArrayList<String>> relations2 =
				new HashMap<String,ArrayList<String>>();//Creating HashMap
		
		relations2.put("A", new ArrayList<String>(Arrays.asList("B", "C")));
		relations2.put("C", new ArrayList<String>());
		relations2.put("B", new ArrayList<String>());
		String y = test1.findAnchestors(relations2, "B", "C");
		System.out.println("common ancestor : " + y);

		assertEquals(y, "A", "Common Ancestor must be A");
	}
	// TEST WITH NO RELATIONS
	@Test
	void test3() {
		LCA test1 = new LCA();
		HashMap<String,ArrayList<String>> relations2 =
				new HashMap<String,ArrayList<String>>();//Creating HashMap
		
		relations2.put("A", new ArrayList<String>());
		relations2.put("C", new ArrayList<String>());
		relations2.put("B", new ArrayList<String>());
		String y = test1.findAnchestors(relations2, "B", "C");
		System.out.println("common ancestor : " + y);
		assertEquals(y, "", "Common Ancestor must be A");
	}

	
	// LARGE FAMILY TREE
	@Test
	void test4() {
		LCA test1 = new LCA();
		HashMap<String,ArrayList<String>> relations2 =
				new HashMap<String,ArrayList<String>>();//Creating HashMap
		
		relations2.put("A", new ArrayList<String>(Arrays.asList("B", "E")));
		relations2.put("B", new ArrayList<String>(Arrays.asList("C")));
		relations2.put("C", new ArrayList<String>(Arrays.asList("D")));
		relations2.put("D", new ArrayList<String>());
		relations2.put("E", new ArrayList<String>(Arrays.asList("F")));
		relations2.put("F", new ArrayList<String>(Arrays.asList("G")));
		relations2.put("G", new ArrayList<String>());
		String y = test1.findAnchestors(relations2, "D", "G");
		System.out.println("common ancestor : " + y);
		assertEquals(y, "A", "Common Ancestor must be A");
	}
	
	// DIRECTED ACYCLICAL GRAPH
		@Test
		void test5() {
			LCA test1 = new LCA();
			HashMap<String,ArrayList<String>> relations2 =
					new HashMap<String,ArrayList<String>>();//Creating HashMap
			
			relations2.put("A", new ArrayList<String>(Arrays.asList("B", "C", "D", "E")));
			relations2.put("B", new ArrayList<String>(Arrays.asList("D")));
			relations2.put("C", new ArrayList<String>(Arrays.asList("D")));
			relations2.put("D", new ArrayList<String>(Arrays.asList("E")));
			relations2.put("E", new ArrayList<String>());
			String y = test1.findAnchestors(relations2, "B", "E");
			System.out.println("common ancestor : " + y);
			assertEquals(y, "A", "Common Ancestor must be A");
		}
}
