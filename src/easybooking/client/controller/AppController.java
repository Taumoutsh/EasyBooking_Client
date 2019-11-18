package easybooking.client.controller;

import java.sql.Timestamp;

import easbooking.client.servicelocator.AppServiceLocator;
import easybooking.client.data.classes.Flight;
import easybooking.client.data.classes.Reservation;
import easybooking.client.gui.JFramePrincipal;

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
	
	public void signUp(String email, String password, String firstname, String lastname) {
		boolean signUpBoolean = rsl.getService().signUp(email, password, firstname, lastname);
	}
	
	public void logIn(String email, String password) {
		boolean logInBoolean  = rsl.getService().logIn(email, password);
	}
	
	public void searchAirportDate(String origin, String destination, Timestamp timestampOrigin, Timestamp timestampDestination) {
		rsl.getService().searchAirportDate(origin, destination, timestampOrigin, timestampDestination);
	}
	
	public void pay(Reservation reservation) {
		rsl.getService().pay(reservation);
	}
	
	public void book(Flight flight) {
		rsl.getService().book(flight);
	}

	
	public void exit() {
		
	}
	

}
