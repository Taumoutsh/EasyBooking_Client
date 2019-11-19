package easybooking.client.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;

import easbooking.client.servicelocator.AppServiceLocator;
import easybooking.client.data.classes.Flight;
import easybooking.client.data.classes.Reservation;
import easybooking.client.gui.JFramePrincipal;
import easybooking.server.data.dto.FlightDTO;

public class AppController {
	
	AppServiceLocator rsl;
	
	public AppController(String args[]) {
		new JFramePrincipal();
		rsl = new AppServiceLocator();
		rsl.setService(args);
	}
	
	public boolean signUp(String email, String password, String firstname, String lastname) {
		return rsl.getService().signUp(email, password, firstname, lastname);
	}
	
	public boolean logIn(String email, String password) {
		return rsl.getService().logIn(email, password);
	}
	
	public HashMap<String, ArrayList<FlightDTO>> searchAirportDate(String origin, String destination, Timestamp timestampOrigin, Timestamp timestampDestination) {
		return rsl.getService().searchAirportDate(origin, destination, timestampOrigin, timestampDestination);
	}
	
	public boolean pay() {
		return rsl.getService().pay();
	}
	
	public boolean book(HashMap<String, String> passenger) {
		return rsl.getService().book(passenger);
	}
	
	public boolean chooseFlight(FlightDTO flight) {
		return rsl.getService().chooseFlight(flight);
	}

	
	public void exit() {
		
	}
	
	public static void main(String args[]) {
		new AppController(args);
	}
}
