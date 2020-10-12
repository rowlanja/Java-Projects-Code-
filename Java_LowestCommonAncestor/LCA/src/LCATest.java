import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import org.junit.jupiter.api.Test;

class LCATest {

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
	

	void test2() {

		LCA test1 = new LCA();
		HashMap<String,ArrayList<String>> relations2 =
				new HashMap<String,ArrayList<String>>();//Creating HashMap
		
		relations2.put("A", new ArrayList<String>(Arrays.asList("B", "C")));
		relations2.put("C", new ArrayList<String>());
		relations2.put("B", new ArrayList<String>());
		String y = test1.findAnchestors(relations2, "B", "C");
		System.out.println("common ancestor : " + y);

		assertEquals(y, "C", "Common Ancestor must be A");
	}
	
	void test3() {

		LCA test1 = new LCA();
		HashMap<String,ArrayList<String>> relations2 =
				new HashMap<String,ArrayList<String>>();//Creating HashMap
		
		relations2.put("A", new ArrayList<String>(Arrays.asList("B", "C")));
		relations2.put("C", new ArrayList<String>());
		relations2.put("B", new ArrayList<String>());
		String y = test1.findAnchestors(relations2, "B", "C");
		System.out.println("common ancestor : " + y);

		assertEquals(y, "C", "Common Ancestor must be A");
	}

	
}
