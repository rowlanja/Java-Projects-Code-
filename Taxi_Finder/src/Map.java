import java.util.ArrayList;
import java.util.Comparator;

class Node implements Comparator<Node> { 
    public int node; 
    public int cost; 
  
    public Node() 
    { 
    } 
  
    public Node(int node, int cost) 
    { 
        this.node = node; 
        this.cost = cost; 
    } 
  
    @Override
    public int compare(Node node1, Node node2) 
    { 
        if (node1.cost < node2.cost) 
            return -1; 
        if (node1.cost > node2.cost) 
            return 1; 
        return 0; 
    } 
} 

public class Map {
	
	private ArrayList<Taxi> makeTaxis() {
		ArrayList<Taxi> taxiList = new ArrayList<Taxi>();
		for(int loop = 0; loop < 10; loop++) {
			taxiList.add(new Taxi(loop, 0,0));
		}
		return taxiList;
	}
	
	private ArrayList<Customer> makePeople() {
		ArrayList<Customer> People = new ArrayList<Customer>();
		for(int loop = 0; loop < 10; loop++) {
			People.add(new Customer(loop, 0,0));
		}
		return People;
	}
	
	public static void main(String[] args) {
		
	}
}
