package easybooking.client.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import easybooking.client.data.classes.Flight;
import easybooking.client.data.classes.Reservation;
import easybooking.client.gui.JFramePrincipal;
import easybooking.client.servicelocator.AppServiceLocator;

import easybooking.server.data.dto.FlightDTO;

public class AppController {
	
	AppServiceLocator rsl;
	Map<String, ArrayList<FlightDTO>> mapFlight;
	
	public AppController(String args[]) {
		new JFramePrincipal(this);
		rsl = new AppServiceLocator();
		rsl.setService(args);
		printAllFlights();
		mapFlight = new HashMap<String, ArrayList<FlightDTO>>();
		
	}
	
	public boolean signUp(String email, String password, String firstname, String lastname) {
		
		boolean signUpBoolean = false;
		
		try {
			signUpBoolean = rsl.getService().signUp(email, password, firstname, lastname);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return signUpBoolean;
	}
	
	public boolean logIn(String email, String password) {
		
		boolean logInBoolean = false;
		
		try {
			logInBoolean  = rsl.getService().logIn(email, password);
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
	
	public void pay(Reservation reservation) {
		try {
			rsl.getService().pay();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean book(String flightNumber) {
		
		boolean bookBoolean = false;
		
		try {
			
			for(Map.Entry<String, ArrayList<FlightDTO>> entry : mapFlight.entrySet()) {
			    String key = entry.getKey();
			    ArrayList<FlightDTO> value = entry.getValue();
			    
			    for(FlightDTO aFlight : value) {
			    	if(aFlight.getFlightNumber().equals(flightNumber)) {
			    		bookBoolean = rsl.getService().bookFlight(aFlight);
			    	}
			    }
			}
			
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
