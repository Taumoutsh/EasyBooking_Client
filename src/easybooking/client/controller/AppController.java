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
	
	public AppController(String args[]) {
		new JFramePrincipal();
		rsl = new AppServiceLocator();
		rsl.setService(args);
	}
	
	public static void main(String args[]) {
		new AppController(args);
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
		
		Map<String, ArrayList<FlightDTO>> mapFlight = new HashMap<String, ArrayList<FlightDTO>>();
		
		try {
			mapFlight = rsl.getService().searchFlight(origin, destination);
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
	
	public boolean book(FlightDTO flight) {
		
		boolean bookBoolean = false;
		
		try {
			bookBoolean = rsl.getService().bookFlight(flight);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return bookBoolean;
		
	}

	
	public void exit() {
		
	}
	

}
