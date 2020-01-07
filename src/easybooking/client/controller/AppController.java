package easybooking.client.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import easybooking.client.gui.JFrameConnection;
import easybooking.client.gui.JFramePrincipal;
import easybooking.client.servicelocator.AppServiceLocator;

import easybooking.server.data.dto.FlightDTO;

public class AppController {
	
	AppServiceLocator rsl;
	Map<String, ArrayList<FlightDTO>> mapFlight;
	
	public AppController(String args[]) {
		new JFrameConnection(this);
		rsl = new AppServiceLocator();
		rsl.setService(args);
		printAllFlights();
		mapFlight = new HashMap<String, ArrayList<FlightDTO>>();
		
	}
	
	public boolean signUp(String authorizationService, String email, String password, String firstname, String lastname) {
		
		boolean signUpBoolean = false;
		
		try {
			signUpBoolean = rsl.getService().signUp(authorizationService, email, password, firstname, lastname);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return signUpBoolean;
	}
	
	public boolean logIn(String authorizationService, String email, String password) {
		
		boolean logInBoolean = false;
		
		try {
			logInBoolean = rsl.getService().logIn(authorizationService, email, password);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return logInBoolean;
	}
	
	public Map<String, ArrayList<FlightDTO>> searchFlight(String origin, String destination) {
		
		try {
			mapFlight = rsl.getService().searchFlight(origin, destination);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return mapFlight;
	}
	
	public Map<String, ArrayList<FlightDTO>> printAllFlights() {
		
		try {
			mapFlight = rsl.getService().printAllFlights();
			System.out.println(mapFlight.get("Lufthansa").get(0).getArrivalAirportLocation());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return mapFlight;
	}
	
	public int pay() {
		
		int paid = 0;
		
		try {
			paid = rsl.getService().pay();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return paid;
	}
	
	public boolean book(String flightNumber, String name1, String surname1, String name2, String surname2) {
		
		boolean bookBoolean = false;
		
		try {
			
			bookBoolean = rsl.getService().bookFlight(flightNumber, name1, surname1, name2, surname2);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return bookBoolean;
	}

	
	public void exit() {
		
	}
	
	public static void main(String args[]) {
		new AppController(args);
	}
}
