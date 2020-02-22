

public class Customer {
	private String id;
	private double arriveTime, startServeTime, endServeTime, departTime;
	
	// Default Constructor
	public Customer() {
		this.id = "";
		this.arriveTime = 0.0;
		this.startServeTime = 0.0;
		this.endServeTime = 0.0;
		this.departTime = 0.0;
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

	@Override
	public String toString() {
		return "Customer [id=" + id + ", arriveTime=" + arriveTime  + 
				", startServeTime=" + startServeTime + ", endServeTime=" + 
				endServeTime + ", departTime=" + departTime;
	}
}