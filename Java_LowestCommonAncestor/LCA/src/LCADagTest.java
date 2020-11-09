import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.jupiter.api.Test;
/*
 * Unit Tests for LCA Algorithim 
 */
class LCATest {
	@Before
	public void creator() {
		DAG DAG = new DAG(10);

	}

	//Test the DAG structure constructor and Vertices finder
	@Test
	public void testDAGVertices() {
		DAG DAG = new DAG(5);
		assertEquals(' ',' ',"DAG not created");
		int vertices = DAG.V();
		assertEquals(5,vertices,"Did not count the correct vertices");
	}

	//Testing adding edges
	@Test
	public void testAddEdges() {
		DAG DAG = new DAG(10);
		assertEquals(DAG.addEdge(0, 0),false,"Loop created 0-0");
		assertEquals(DAG.addEdge(0, 1),true,"Failed at adding valid edge(0,1)");
		assertEquals(DAG.addEdge(1, 0),false,"Loop created 1-0-1");
		assertEquals(DAG.addEdge(0, 2),true,"Failed at adding valid edge(0,2)");
		assertEquals(DAG.addEdge(0, 11),false,"Added to a non-existent node 0-11");
		assertEquals(DAG.addEdge(11, 12),false,"Added 2 non-existent nodes 11-12");
		assertEquals(DAG.addEdge(1, 3),true,"Failed at adding valid edge(1,3)");
		assertEquals(DAG.addEdge(2, 4),true,"Failed at adding valid edge(2,3)"); //NOTE: not a loop, directed
		assertEquals(DAG.addEdge(4, 0),false,"Created loop 0-2-4-0");

	}

	//
	@Test
	public void testAdj(){
		DAG DAG1 = new DAG(5);
		assertTrue("Testing empty adj list", DAG1.adj(0).isEmpty());
		ArrayList<Integer> expectedResult = new ArrayList<Integer>();
		expectedResult.add(2);
		DAG1.addEdge(1, 2);
		assertTrue("Testing single edge adj list", DAG1.adj(1).size() == expectedResult.size());
		for(int i : expectedResult){
			assertTrue("Testing single edge adj list", DAG1.adj(1).contains(i));
		}

		expectedResult.clear();

		expectedResult.add(3);
		expectedResult.add(4);

		DAG1.addEdge(2, 3);
		DAG1.addEdge(2, 4);

		assertTrue("Testing multi-edge adj list", DAG1.adj(2).size() == expectedResult.size());
		for(int i : expectedResult){
			assertTrue("Testing multi-edge adj list", DAG1.adj(2).contains(i));
		}
	}

	//
	@Test
	public void testLCAonDAG() {

		DAG DAG1 = new DAG(10);

		DAG1.addEdge(0, 2);
		DAG1.addEdge(0, 1);
		DAG1.addEdge(1, 3);
		DAG1.addEdge(3, 4);
		DAG1.addEdge(4, 5);
		DAG1.addEdge(1, 6);
		DAG1.addEdge(6, 7);
		DAG1.addEdge(7, 8);
		DAG1.addEdge(7, 9);

		ArrayList<Integer> testArray = new ArrayList<Integer>();
		testArray.add(0);

		assertTrue("Testing single lca return", DAG1.lowestCommonAncestor(2,1).size() == testArray.size());
		for(int i : testArray){
			System.out.println(testArray);
			assertTrue("Testing single lca return", DAG1.lowestCommonAncestor(2,1).contains(i));
		}
		testArray.clear();
		testArray.add(1);

		assertTrue("Testing double lca return", DAG1.lowestCommonAncestor(8,5).size() == testArray.size());
		for(int i : testArray){
			System.out.println(testArray);
			assertTrue("Testing double lca return", DAG1.lowestCommonAncestor(8,5).contains(i));
		}
		testArray.clear();
		testArray.add(7);

		assertTrue("Testing double lca return", DAG1.lowestCommonAncestor(8,9).size() == testArray.size());
		for(int i : testArray){
			System.out.println(testArray);
			assertTrue("Testing double lca return", DAG1.lowestCommonAncestor(8,9).contains(i));
		}
		testArray.clear();
	}
	
	@Test
	public void DAGTest2() {
		
	}
}
