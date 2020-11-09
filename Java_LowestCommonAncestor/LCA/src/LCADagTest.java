import static org.junit.Assert.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class LCADagTest {

	public LCADagTest() {

	}

	LCADag graph1 =new LCADag(8);
	LCADag graph2 = new LCADag(9);
	LCADag graph3 = new LCADag(9);
	LCADag graph4 = new LCADag(7);
	LCADag graph5 = new LCADag(6);
	
	@Test(expected = IllegalArgumentException.class)
	public void testLCA(){
		graph1();
		graph2Graph();
		graph3Graph();
		
		assertEquals("Because it is cyclic it will throw an exception", 1, graph2.findLCA(1, 4));
		//showing different levels within the graph
		assertEquals("", 7, graph3.findLCA(3, 4));
		assertEquals("", 7, graph3.findLCA(1, 4));
		assertEquals("", 7, graph3.findLCA(5, 2));
		//swapping around the vertices v and w
		assertEquals("", 5, graph3.findLCA(1, 5));
		assertEquals("", 5, graph3.findLCA(5, 1));
		//same v as w
		assertEquals("Can be its own ancestor", 3, graph1.findLCA(3, 3));
	}
	//----------------------------TESTING GRAPH 1--------------------------------//
	//	ALL THESE GRAPHS WILL RETURN EXCEPTIONS AS THE GRPAH IS CYCLICAL AND WONT PROCESS PROPERLY
	
	@Test(expected = IllegalArgumentException.class)
	public void test1Graph1() {	//checking direct parents 
		graph1();
		assertEquals("Can be its own ancestor", 3, graph1.findLCA(2, 3));
	}
	@Test(expected = IllegalArgumentException.class)
	public void test2Graph1() {	//checking relationship with unrelated child 
		graph1();
		assertEquals("Can be its own ancestor", 3, graph1.findLCA(2,8));
	}
	@Test(expected = IllegalArgumentException.class)
	public void test3Graph1() {	//checking for null parent
		graph1();
		assertEquals("Should throw exception", null, graph1.findLCA(3, 3));
	}
	@Test(expected = IllegalArgumentException.class)
	public void test4Graph1() {	//passing the same child as arguments 
		graph1();
		assertEquals("Can be its own ancestor", 2, graph1.findLCA(2, 2));
	}
	
	//---------------------------TESTING GRAPH 2--------------------------------//
	

	@Test(expected = IllegalArgumentException.class)
	public void test1Graph2() {	//checking direct parents 
		graph1();
		assertEquals("Can be its own ancestor", 3, graph2.findLCA(4, 3));
	}
	@Test(expected = IllegalArgumentException.class)
	public void test2Graph2() {	//checking relationship with unrelated child 
		graph1();
		assertEquals("Can be its own ancestor", 3, graph2.findLCA(5, 6));
	}
	@Test(expected = IllegalArgumentException.class)
	public void test3Graph2() {	//checking for null parent
		graph1();
		assertEquals("Should throw exception", null, graph2.findLCA(7, 8));
	}
	@Test(expected = IllegalArgumentException.class)
	public void test4Graph2() {	//passing the same child as arguments 
		graph1();
		assertEquals("Can be its own ancestor", 2, graph2.findLCA(0, 7));
	}
	//---------------------------TESTING GRAPH 3--------------------------------//
	
	//THIS GRAPH IS A ACYCLIC GRAPH SO IT WILL BE PROCESSED NORMALLY 
	
	@Test(expected = IllegalArgumentException.class)
	public void testgraph1al1() {
		graph3Graph();
		assertEquals("", 0, graph3.findLCA(3, 4));
		assertEquals("", 0, graph3.findLCA(1, 4));
		assertEquals("", 7, graph3.findLCA(5, 2));
	}

	
	//-------------------------------GRAPH INITIALISATION-------------------//
	
	public void graph1(){
		//1->2->3->4->5->6->7
		graph1.addEdge(0, 1);
		graph1.addEdge(1, 2);
		graph1.addEdge(2, 3);
		graph1.addEdge(3, 4);
		graph1.addEdge(4, 5);
		graph1.addEdge(5, 6);
		graph1.addEdge(6, 7);
	}
	
	public void graph2Graph(){
		//  -> 1    <- 3 -> 6 -> 8 
		//0    ->      ^         ^
		//  ->    2 -> 4         7
		graph2.addEdge(0, 1);
		graph2.addEdge(0, 2);
		graph2.addEdge(1, 2);
		graph2.addEdge(2, 4);
		graph2.addEdge(4, 3);
		graph2.addEdge(3, 1);
		graph2.addEdge(3, 6);
		graph2.addEdge(6, 8);
		graph2.addEdge(7, 8);
	}

	public void graph3Graph(){
		//  -> 1 -> 3 -> 5 ->
		//0    ^              7 -> 8             
		//  -> 2 -> 4 -> 6 ->      
		graph3.addEdge(0, 1);
		graph3.addEdge(0, 2);
		graph3.addEdge(1, 3);
		graph3.addEdge(2, 4);
		graph3.addEdge(3, 5);
		graph3.addEdge(4, 6);
		graph3.addEdge(5, 7);
		graph3.addEdge(6, 7);
		graph3.addEdge(7, 8);
	}


		
	public void graph4Graph(){
		//	     < 2		 4 >
		//	 < 1	   3  >		5 >
		//0						     6
		graph4.addEdge(2, 1);
		graph4.addEdge(1, 0);
		graph4.addEdge(2, 3);
		graph4.addEdge(4, 5);
		graph4.addEdge(4, 3);
		graph4.addEdge(5, 6);
	}	

	public void graph5Graph(){
		//1<-2<-3		4->5->6
		graph5.addEdge(2, 1);
		graph5.addEdge(3, 2);
		graph5.addEdge(4, 5);
		graph5.addEdge(5, 6);
	}	

}
