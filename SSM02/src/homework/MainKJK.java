package homework;
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
		System.out.println("System Simulation & Modeling: Week 3");
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

		// 20 Customer objects
		cust.add(new Customer("Adam"));
		cust.add(new Customer("Bill"));
		cust.add(new Customer("Chad"));
		cust.add(new Customer("Dan"));
		cust.add(new Customer("Eddy"));
		cust.add(new Customer("Fred"));
		cust.add(new Customer("Gil"));
		cust.add(new Customer("Hector"));
		cust.add(new Customer("Igor"));
		cust.add(new Customer("Josh"));
		cust.add(new Customer("Kyle"));
		cust.add(new Customer("Lenny"));
		cust.add(new Customer("Manny"));
		cust.add(new Customer("Noah"));
		cust.add(new Customer("Oscar"));
		cust.add(new Customer("Pete"));
		cust.add(new Customer("Quinn"));
		cust.add(new Customer("Ron"));
		cust.add(new Customer("Sam"));
		cust.add(new Customer("Tim"));

		// Sets the randomized arrive, start serve, end serve, and depart times for each
		// customer.
		for (Customer customer : cust) {
			// Set arrive time of the customer
			customer.setArriveTime(((randy.nextInt(6)) / 10.0) + 1);
			// Set start serve time, which comes after arrive time
			customer.setStartServeTime(customer.getArriveTime() + (randy.nextInt(10) / 10.0) + 0.1);
			// Set end serve time, which comes after start serve time
			customer.setEndServeTime(customer.getStartServeTime() + (randy.nextInt(10) / 10.0) + 0.1);
			// Set depart time, which comes after end serve time
			customer.setDepartTime(customer.getEndServeTime() + (randy.nextInt(10) / 10.0) + 0.1);
		}

		// Sets 5 randomly chosen customers to have end serve time > depart time
		for (int i = 5; i > 0; i--) {
			Customer randCust = cust.get(randy.nextInt(cust.size())); // Gets a random customer
			// If we grabbed an element we already changed
			if (randCust.getEndServeTime() > randCust.getDepartTime()) {
				i++; // Increment i and redo this for loop
			} else {
				randCust.setEndServeTime(randCust.getDepartTime() + 1);
				// Customer randomly exceeds the top limit bounds of their service time
			}
		}

		// Set the customer objects' min time
		for (Customer customer : cust) {
			customer.setMinTime(customer.getArriveTime());
		}

		// Set the customer objects' max time
		for (Customer customer : cust) {
			customer.setMaxTime(customer.getEndServeTime());
		}

		// Queue for serving customers
		Queue<Customer> serve = new LinkedList<Customer>();

		// Have the Customer objects enter the queue at random times
		for (Customer customer : cust) {
			serve.add(customer);
		}

		// Find the earliest arrive and start serve times,
		// and the latest end serve, and depart times (for u_hat calculation)
		double open = 100; // time of first arrival, default as large value for comparisons
		double firstCust = 100; // time of first cust served
		double lastCust = -1; // time of last cust served, default as small value for comparisons
		double close = -1; // time of last departure
		for (Customer customer : serve) {
			if (customer.getArriveTime() < open)
				open = customer.getArriveTime(); // Save the earliest arrive time
			if (customer.getStartServeTime() < firstCust)
				firstCust = customer.getStartServeTime(); // Save the time of first customer starting
			if (customer.getEndServeTime() > lastCust && customer.getDepartTime() > customer.getEndServeTime())
				lastCust = customer.getEndServeTime(); // Save the time of last customer ending
			if (customer.getDepartTime() > close)
				close = customer.getDepartTime(); // Save the latest depart time
		}

		// q: Keeps track of the amount of elements in the queue at the given time
		double qServe = 0.0;
		// custExceed: Keeps track of customers who have end serve time > depart time
		int custExceed = 0;
		// (took too long to serve them and they departed)
		for (Customer customer : serve) { // For each customer that is being served
			System.out.println(customer.toString());
			// If the customer left before they got served.
			if (customer.getEndServeTime() > customer.getDepartTime()) {
				System.out.println(customer.getId() + " exceeded serve time and departed.");
				custExceed++;
			}
			qServe += serve.size();
		}

		// Customers that left before being served.
		System.out.println("Customers that departed before being served: " + custExceed);

		// q_hat: Average # of elements in a queue over the time of a run (estimate)
		// If q_hat == queue size, then all customers were added at the same time
		// (just like in this example).
		double q_hat = qServe / serve.size(); // Size of queue at all given times / size (average)

		// u_hat: Utilization time of the server (estimate)
		double workday = close - open; // Time that server is "open" (server initiated but not in use)
		double working = lastCust - firstCust; // Time that customers are being served (server in use)
		double u_hat = Math.round((working / workday) * 100.0) / 100.0;

		// stdev: Standard deviation of the service times from 0 to T(n).
		double a[] = new double[serve.size()];
		int in = 0;
		for (Customer customer : serve) {
			double custServe = customer.getEndServeTime() - customer.getStartServeTime();
			a[in] = custServe;
			in++;
		}
		double sum = 0;
		for (int i = 0; i < a.length; i++)
			sum += a[i];
		double mean = sum / a.length;
		double sqDiff = 0;
		for (int i = 0; i < a.length; i++)
			sqDiff += (a[i] - mean) * (a[i] - mean);
		double stdev = Math.round((sqDiff / a.length) * 100.0) / 100.0;

//		String u_hatPercent = Math.round(u_hat * 100.0) + "%";
		System.out.println("Average # of elements in a queue over the time of a run (estimate): " + q_hat);
		System.out.println("Utilization time of the server over the time of a run (estimate): " + u_hat);
		System.out.println("Standard Deviation: " + stdev);
	} // end of psvm
} // end of class