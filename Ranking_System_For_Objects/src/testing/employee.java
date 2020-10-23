package testing;
import java.time.LocalDate;
import java.util.*;

public class employee implements Comparable<employee>{
	
    private int id;
    private String name;
    private LocalDate dob;
 
    public employee(int id, String name, LocalDate dob) {
        super();
        this.id = id;
        this.name = name;
        this.dob = dob;
    }
     public String getName(employee emp) {
    	 return this.name;
     }

     
    public static void main(String[] args) {

    	Comparator<employee> nameSorter = new Comparator<employee>(){

			@Override
			public int compare(employee employee1, employee employee2) {
				return employee1.id < employee2.id ? 1 : -1;
			}
    	};
    	 
    	PriorityQueue<employee> priorityQueue = new PriorityQueue<>(nameSorter);
    	
       	priorityQueue.add(new employee(395, "David Kasanove", LocalDate.now()));
    	priorityQueue.add(new employee(380, "Donthe Hightower", LocalDate.now()));
    	priorityQueue.add(new employee(330, "Jerome Patterson", LocalDate.now()));         
    	priorityQueue.add(new employee(450, "Blake Rehahn", LocalDate.now()));
    	priorityQueue.add(new employee(415, "Danny Beasley", LocalDate.now()));
    	priorityQueue.add(new employee(400, "Keith Brown", LocalDate.now()));
 
	    System.out.println("\nEmployees Ranked from highest ID number to Lowest ID Number : \n");

    	while(priorityQueue.size() > 0) 
    	{
    	    employee e = priorityQueue.poll();
    	    System.out.println("Employee ID " + e.id + " , Employee Name : " + e.name);
    	}
    }

}
