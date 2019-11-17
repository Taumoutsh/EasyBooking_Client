package classes;

import java.util.ArrayList;
import java.util.HashMap;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.Join;

public class User {
	private String email;
	private int paymentMethod, autorizationMethod;
	private Airport defaultDepartureAirport;
	//private HashMap<Integer,Reservation>reservations;//if we want to have an array of the reservations
	public User(String email, int paymentMethod, int autorizationMethod, Airport defaultDepartureAirport) {
		this.email = email;
		this.paymentMethod = paymentMethod;
		this.autorizationMethod = autorizationMethod;
		this.defaultDepartureAirport = defaultDepartureAirport;
		//this.reservations = new HashMap<Integer, Reservation>();
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(int paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public int getAutorizationMethod() {
		return autorizationMethod;
	}
	public void setAutorizationMethod(int autorizationMethod) {
		this.autorizationMethod = autorizationMethod;
	}
	public Airport getDefaultDepartureAirport() {
		return defaultDepartureAirport;
	}
	public void setDefaultDepartureAirport(Airport defaultDepartureAirport) {
		this.defaultDepartureAirport = defaultDepartureAirport;
	}
	/*public HashMap<Integer, Reservation>getReservations() {
		return reservations;
	}
	public Reservation getReservation(int paymentCode) {
		return this.reservations.get(paymentCode);
	}
	public void addReservation(Reservation r) {
		this.reservations.put(r.getPaymentCode(),r);
	}*/
}
