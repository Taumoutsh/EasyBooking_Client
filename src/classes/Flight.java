package classes;

import java.sql.Date;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;

@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)

public class Flight {
//properties
	private String flightNumber;
	private int totalSeats, remainingSeats;
	private Date departureTimeDate, arrivaTimeDate;
	//should the flights have an string with the origin and destination airport's code??

	//constructor
	public Flight(String flightNumber, int totalSeats, int remainingSeats, Date departureTimeDate,
			Date arrivaTimeDate) {
		this.flightNumber = flightNumber;
		this.totalSeats = totalSeats;
		this.remainingSeats = remainingSeats;
		this.departureTimeDate = departureTimeDate;
		this.arrivaTimeDate = arrivaTimeDate;
	}
	public Flight() {
		this.flightNumber = null;
		this.totalSeats = 0;
		this.remainingSeats = 0;
		this.departureTimeDate = null;
		this.arrivaTimeDate = null;
	}
	public Flight(Flight f) {
		this.flightNumber = f.flightNumber;
		this.totalSeats = f.totalSeats;
		this.remainingSeats = f.remainingSeats;
		this.departureTimeDate = f.departureTimeDate;
		this.arrivaTimeDate = f.arrivaTimeDate;
	}
	
	//getters and setters
	public String getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	public int getTotalSeats() {
		return totalSeats;
	}
	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}
	public int getRemainingSeats() {
		return remainingSeats;
	}
	public void setRemainingSeats(int remainingSeats) {
		this.remainingSeats = remainingSeats;
	}
	public Date getDepartureTimeDate() {
		return departureTimeDate;
	}
	public void setDepartureTimeDate(Date departureTimeDate) {
		this.departureTimeDate = departureTimeDate;
	}
	public Date getArrivaTimeDate() {
		return arrivaTimeDate;
	}
	public void setArrivaTimeDate(Date arrivaTimeDate) {
		this.arrivaTimeDate = arrivaTimeDate;
	}
	

}
