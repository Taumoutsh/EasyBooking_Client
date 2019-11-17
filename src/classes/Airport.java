package classes;

import java.util.HashMap;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.Join;

@PersistenceCapable

public class Airport {
	private String idAirport, location;
	@Join
	private HashMap<String, Flight> arrivingflightList;//map of flights that arrive this airport
	@Join
	private HashMap<String, Flight> outGoingFlightList;//map of flights that come from this airport
	public Airport(String idAirport, String location, HashMap<String, Flight> EnteringflightList,HashMap<String, Flight> outgoingFlightList) {
		this.idAirport = idAirport;
		this.location = location;
		this.arrivingflightList = EnteringflightList;
		this.outGoingFlightList = outgoingFlightList;
	}
	
	public Airport(String idAirport, String location) {
		this.idAirport = idAirport;
		this.location = location;
		this.arrivingflightList = new HashMap<String, Flight>();
		this.outGoingFlightList= new HashMap<String, Flight>();
	}

	public String getIdAirport() {
		return idAirport;
	}

	public void setIdAirport(String idAirport) {
		this.idAirport = idAirport;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}


	public HashMap<String, Flight> getArrivingflightList() {
		return arrivingflightList;
	}

	public void setArrivingflightList(HashMap<String, Flight> enteringflightList) {
		this.arrivingflightList = enteringflightList;
	}

	public HashMap<String, Flight> getOutGoingFlightList() {
		return outGoingFlightList;
	}

	public void setOutGoingFlightList(HashMap<String, Flight> outGoingFlightList) {
		this.outGoingFlightList = outGoingFlightList;
	}

	public void addArrivingFlight(Flight f) {
		this.arrivingflightList.put(f.getFlightNumber(), f);
	}
	public void addOutGoingFlight(Flight f) {
		this.outGoingFlightList.put(f.getFlightNumber(), f);
	}	
	public Flight getArrivingFlight(String flightNumber) {
		return this.arrivingflightList.get(flightNumber);
	}
	public Flight getOutGoinggFlight(String flightNumber) {
		return this.outGoingFlightList.get(flightNumber);
	}
	
	


}
