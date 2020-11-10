import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class LCADagTest {
	@Before
	public void creator() {
		DAG DAG = new DAG(10);
	}

	@Test
	public void testDAGVertices() {
		DAG DAG = new DAG(5);
		assertEquals(' ',' ',"DAG not created");
		int vertices = DAG.V();
		assertEquals(5,vertices,"Did not count the correct vertices");
	}

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

	//----------------TESTING WITH A GRAPH THATS ACYCLICAL AND CONNECTED----------//
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
			assertTrue("Testing single lca return", DAG1.lowestCommonAncestor(2,1).contains(i));
		}
		testArray.clear();
		testArray.add(1);

		assertTrue("Testing double lca return", DAG1.lowestCommonAncestor(8,5).size() == testArray.size());
		for(int i : testArray){
			assertTrue("Testing double lca return", DAG1.lowestCommonAncestor(8,5).contains(i));
		}
		testArray.clear();
		testArray.add(7);

		assertTrue("Testing double lca return", DAG1.lowestCommonAncestor(8,9).size() == testArray.size());
		for(int i : testArray){
			assertTrue("Testing double lca return", DAG1.lowestCommonAncestor(8,9).contains(i));
		}
		testArray.clear();
	}

	//----------------TESTING WITH A GRAPH THATS NOT CONNECTED----------//
	@Test
	public void DAGTest2() {


		DAG DAG2 = new DAG(10);

		DAG2.addEdge(0, 2);
		DAG2.addEdge(0, 1);
		DAG2.addEdge(1, 3);
		DAG2.addEdge(3, 4);
		DAG2.addEdge(4, 5);

		DAG2.addEdge(6, 7);
		DAG2.addEdge(7, 8);
		DAG2.addEdge(7, 9);

		ArrayList<Integer> testArray = new ArrayList<Integer>();
		assertTrue("Testing single lca return", DAG2.lowestCommonAncestor(2,1).size() == 1);
		assertTrue("Testing single lca return", DAG2.lowestCommonAncestor(2,1).contains(0));
		assertTrue("Testing double lca return", DAG2.lowestCommonAncestor(8,5).size() == 0);
		assertTrue("Testing double lca return", DAG2.lowestCommonAncestor(8,9).size() == 1);
		assertTrue("Testing double lca return", DAG2.lowestCommonAncestor(8,9).contains(7));
	}
	
	//----------------TESTING WITH A GRAPH THATS EMPTY----------//
		@Test
		public void DAGTest3() {
			DAG DAG3 = new DAG(0);
			ArrayList<Integer> testArray = new ArrayList<Integer>();
			assertTrue("Testing single lca return", DAG3.lowestCommonAncestor(2,1).size() == testArray.size());

		}
		
		//----------------TESTING WITH A GRAPH where nodes have loads of connections----------//
		@Test
		public void testLCAonDAG2() {

			DAG DAG4 = new DAG(7);

			DAG4.addEdge(1, 2);
			DAG4.addEdge(1, 0);
			DAG4.addEdge(1, 5);
			DAG4.addEdge(2, 3);
			DAG4.addEdge(1, 6);

			ArrayList<Integer> testArray = new ArrayList<Integer>();

			assertTrue("Testing single lca return", DAG4.lowestCommonAncestor(2,1).size() == 1);
			assertTrue("Testing single lca return", DAG4.lowestCommonAncestor(2,1).contains(1));
			System.out.println(DAG4.lowestCommonAncestor(8,9));
			assertTrue("Testing double lca return", DAG4.lowestCommonAncestor(6,3).size() == 1);
			assertTrue("Testing double lca return", DAG4.lowestCommonAncestor(6,3).contains(1));
			assertTrue("Testing double lca return", DAG4.lowestCommonAncestor(8,9).size() == 0);
			assertTrue("Testing double lca return", DAG4.lowestCommonAncestor(8,9).contains(testArray));
		}

}
