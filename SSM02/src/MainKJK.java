
import java.util.Random;
import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;

/* @author Kyle Kaminski
 * @class System Simulation & Modeling
 * @date 2/16/2020
 */

public class MainKJK {
	public static void main(String[] args) {
		System.out.println("System Simulation & Modeling: Week 2");
		Random randy = new Random();

		double arriveTime = ((randy.nextInt(6)) / 10.0) + 1;
		double startServeTime = (randy.nextInt(10) / 10.0) + 0.1 + arriveTime;

		System.out.println("Arrive time = " + arriveTime);
		System.out.println("Start Serve time = " + startServeTime);

		Customer c = new Customer();

		c.setArriveTime(arriveTime);
		c.setArriveTime(startServeTime);

		System.out.println("\n**********\n");

		// Stores all customer objects
		ArrayList<Customer> cust = new ArrayList<Customer>();

		cust.add(c);
		
	} // end of psvm
} // end of class