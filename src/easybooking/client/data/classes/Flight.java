package easybooking.client.data.classes;

import java.sql.Date;

public class Flight {
//properties
	private String flightNumber;
	private int totalSeats, remainingSeats;
	private Date departureTimeDate, arrivalTimeDate;
	private int price;
	private Airline airline;
	private Airport depatureAirport, arrivalAirport;

	//constructor
	public Flight(String flightNumber, int totalSeats, int remainingSeats, Date departureTimeDate,
			Date arrivalTimeDate, int price, Airline airline, Airport depatureAirport, Airport arrivalAirport) {
		this.flightNumber = flightNumber;
		this.totalSeats = totalSeats;
		this.remainingSeats = remainingSeats;
		this.departureTimeDate = departureTimeDate;
		this.arrivalTimeDate = arrivalTimeDate;
		this.price = price;
		this.airline = airline;
		this.depatureAirport = depatureAirport;
		this.arrivalAirport = arrivalAirport;
	}
	public Flight() {
	}
	
	public Flight(Flight f) {
		this.flightNumber = f.getFlightNumber();
		this.totalSeats = f.getTotalSeats();
		this.remainingSeats = f.getRemainingSeats();
		this.departureTimeDate = f.getDepartureTimeDate();
		this.arrivalTimeDate = f.getArrivalTimeDate();
		this.price = f.getPrice();
		this.airline = f.getAirline();
		this.depatureAirport = f.getDepatureAirport();
		this.arrivalAirport = f.getArrivalAirport();
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
	public Date getArrivalTimeDate() {
		return arrivalTimeDate;
	}
	public void setArrivalTimeDate(Date arrivalTimeDate) {
		this.arrivalTimeDate = arrivalTimeDate;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Airline getAirline() {
		return airline;
	}
	public void setAirline(Airline airline) {
		this.airline = airline;
	}
	public Airport getDepatureAirport() {
		return depatureAirport;
	}
	public void setDepatureAirport(Airport depatureAirport) {
		this.depatureAirport = depatureAirport;
	}
	public Airport getArrivalAirport() {
		return arrivalAirport;
	}
	public void setArrivalAirport(Airport arrivalAirport) {
		this.arrivalAirport = arrivalAirport;
	}

}
