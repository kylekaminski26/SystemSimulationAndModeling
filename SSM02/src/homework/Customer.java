package homework;

public class Customer {
	private String id;
	private double arriveTime, startServeTime, endServeTime, departTime, minTime, maxTime;
	// 2a) Min/max time range
	/*
	 * 3a) Time when customer enters queue: arriveTime Time when customer begins
	 * service: startServeTime Time when customer exits queue: endServeTime
	 */

	// Default Constructor
	public Customer() {
		this.id = "";
		this.arriveTime = 0.0;
		this.startServeTime = 0.0;
		this.endServeTime = 0.0;
		this.departTime = 0.0;
		this.minTime = 0.0;
		this.maxTime = 0.0;
	}

	// Name only Constructor
	public Customer(String id) {
		this.id = id;
		this.arriveTime = 0.0;
		this.startServeTime = 0.0;
		this.endServeTime = 0.0;
		this.departTime = 0.0;
		this.minTime = 0.0;
		this.maxTime = 0.0;
	}

	// Full Constructor
	public Customer(String id, double arriveTime, double startServeTime, double endServeTime, double departTime,
			double minTime, double maxTime) {
		super();
		this.id = id;
		this.arriveTime = arriveTime;
		this.startServeTime = startServeTime;
		this.endServeTime = endServeTime;
		this.departTime = departTime;
		this.minTime = minTime;
		this.maxTime = maxTime;
	}

	public String getId() {
		return id;
	}

	public double getArriveTime() {
		return arriveTime;
	}

	public double getStartServeTime() {
		return startServeTime;
	}

	public double getEndServeTime() {
		return endServeTime;
	}

	public double getDepartTime() {
		return departTime;
	}

	public double getMinTime() {
		return minTime;
	}

	public double getMaxTime() {
		return maxTime;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setArriveTime(double arriveTime) {
		this.arriveTime = arriveTime;
	}

	public void setStartServeTime(double startServeTime) {
		this.startServeTime = startServeTime;
	}

	public void setEndServeTime(double endServeTime) {
		this.endServeTime = endServeTime;
	}

	public void setDepartTime(double departTime) {
		this.departTime = departTime;
	}

	// a) Set min service time range
	public void setMinTime(double minTime) {
		this.minTime = minTime;
	}

	// a) Set max service time range
	public void setMaxTime(double maxTime) {
		this.maxTime = maxTime;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", arriveTime=" + Math.round(arriveTime * 100.0) / 100.0 + ", startServeTime="
				+ Math.round(startServeTime * 100.0) / 100.0 + ", endServeTime="
				+ Math.round(endServeTime * 100.0) / 100.0 + ", departTime=" + Math.round(departTime * 100.0) / 100.0
				+ ", minTime=" + Math.round(minTime * 100.0) / 100.0 + ", maxTime="
				+ Math.round(maxTime * 100.0) / 100.0 + "]";
	}
}