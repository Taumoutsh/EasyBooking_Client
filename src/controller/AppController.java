package controller;

import java.sql.Timestamp;

import GUI.JFramePrincipal;
import servicelocator.AppServiceLocator;

public class AppController {
	
	AppServiceLocator rsl;
	
	public AppController(String args[]) {
		new JFramePrincipal();
		rsl = new ServiceLocator();
		rsl.setService(args[0], args[1], args[2]);
	}
	
	public static void main(String args[]) {
		new AppController(args);
	}
	
	public void signUp(String email, String password, String firstname, String lastname) {
		rsl.getService().signUp(email, password, firstname, lastname);
	}
	
	public void logIn(String email, String password) {
		rsl.getService().logIn(email, password);
	}
	
	public void search(String origin, String destination, Timestamp timestampOrigin, Timestamp timestampDestination) {
		rsl.getService().search(origin, destination, timestampOrigin, timestampDestination);
	}
	
	public void book(Flight flight) {
		rsl.getService().book(flight);
	}
	
	public void pay(Reservation reservation) {
		rsl.getService().pay(reservation);
	}
	
	public void exit() {
		
	}
	

}
