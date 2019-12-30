/*

package easybooking.client.data.classes;

import java.sql.Date;
import java.util.Map;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

public class Main {

	public static void main(String[] args) {
		

		try {
		
	//create an structure
		//create the classes
			Date d = new Date(2020, 3,23);
			Date d2 = new Date(2020, 3,26);
			Flight f1 = new Flight("001",500,500,d,d2, 0, null, null, null);
			Flight f2 = new Flight("002",500,500,d,d2, 0, null, null, null);
			Airport bilbao = new Airport("BIO","Bilbao");
			Airline iberia = new Airline("IBE");
			Reservation r1= new  Reservation(Integer.parseInt(f1.getFlightNumber()), 2);
			Reservation r2= new  Reservation(Integer.parseInt(f2.getFlightNumber()), 3);
			Passenger p1 = new Passenger("Claudia", "Sancho");
			Passenger p2 = new Passenger("Natalia", "Boogen");
			Passenger p3 = new Passenger("Maria", "Eguskiza");
			Passenger p4 = new Passenger("Coro", "Bayona");
			Passenger p5 = new Passenger("Natalia", "Lopez");
			Passenger pass[] = new Passenger[2];
			Passenger pass1[] = new Passenger[3];
			pass[0]= p1;
			pass[1]= p2;
			pass1[0]=p3;
			pass1[1]=p4;
			pass1[2]=p5;
			User u1 = new User("user@gmai.com", 0, 0, bilbao);
			
			bilbao.addArrivingFlight(f1);
			bilbao.addOutGoingFlight(f2);
			iberia.addFlight(f1);
			iberia.addFlight(f2);
			r1.setPaymentCode(0);
			r2.setPaymentCode(1);
			r1.setPassengers(pass);
			r2.setPassengers(pass1);

		//use the methods

			PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
			PersistenceManager pm = pmf.getPersistenceManager();
			
			//Open transaction with database
			Transaction tx = pm.currentTransaction();
			
				try {
				
				// Persist on object (ready to be sended to the database)
					pm.makePersistent(bilbao);
					pm.makePersistent(iberia);
					pm.makePersistent(r1);
					pm.makePersistent(r2);
					
					System.out.println("Inserting contents into the database ....");
				
				// Object is added in the db
					tx.commit();
				}
				catch(Exception e)
				{
					e.getStackTrace();
				} finally {
					if (tx.isActive()) {
						tx.rollback();
					}
					
					pm.close();
				}
				
				pm = pmf.getPersistenceManager();			
				tx = pm.currentTransaction();
				
				try {
					
				    tx.begin();
		
				    Extent<Airport> extentA = pm.getExtent(Airport.class, false);
				    Extent<Reservation> extentR = pm.getExtent(Reservation.class, false);
					
					int cont = 0;
				    
					System.out.println("Airports :");
					
				    for (Airport a : extentA) {
				    	System.out.println(" - Airport n°"+cont++);
				    	System.out.println(" 	- " + a.getIdAirport() + " - " + a.getLocation());
				    	System.out.println(" 	- List of Outgoing flights :");
				    	for(Map.Entry<String, Flight> entry : a.getOutGoingFlightList().entrySet()) {
				    		System.out.println(" 		- Flight number : "+entry.getValue().getFlightNumber());
				    	}
				    	
				    	for(Map.Entry<String, Flight> entry : a.getArrivingflightList().entrySet()) {
				    		System.out.println(" 		- Flight number : "+entry.getValue().getFlightNumber());
				    	}
				    	
				    }
				    
					cont = 0;
				    
				    System.out.println("Reservations :");
					
				    for (Reservation r : extentR) {
				    	System.out.println(" - Reservation n°"+cont++);
				    	System.out.println(" 	- Flight code : " + r.getFlightCode());
				    	System.out.println(" 	- Number of seats : " + r.getNumberOfSeats());
				    	System.out.println(" 	- Payment code : " + r.getPaymentCode());
				    	System.out.println(" 	- Passengers :");
				    	for(Passenger p : r.getPassengers()) {
				    		System.out.println(" 		- Name : "+p.getName()+" "+p.getSurname());
				    	}
				    	
				    }

				    tx.commit();
				} catch (Exception ex) {
					System.out.println("# Error getting Extent: " + ex.getMessage());
				} finally {
				    if (tx.isActive()) {
				        tx.rollback();
				    }
		
				    pm.close();
				}
				
				pm = pmf.getPersistenceManager();			
				tx = pm.currentTransaction();
				
				try {
					
					tx.begin();
				
					Extent<Airport> extentA = pm.getExtent(Airport.class, false);

					for (Airport airport : extentA) {
					    pm.deletePersistent(airport);	
					}
					
					Extent<Airline> extentAl = pm.getExtent(Airline.class, false);

					for (Airline airline : extentAl) {
					    pm.deletePersistent(airline);	
					}
					
					Extent<Reservation> extentR = pm.getExtent(Reservation.class, false);
					
					for (Reservation reservation : extentR) {
					    pm.deletePersistent(reservation);	
					}
					
					Extent<Flight> extentF = pm.getExtent(Flight.class, false);
					
					for (Flight flight : extentF) {
					    pm.deletePersistent(flight);	
					}
					
					Extent<Passenger> extentP = pm.getExtent(Passenger.class, false);
					
					for (Passenger passenger : extentP) {
					    pm.deletePersistent(passenger);	
					}
					
					System.out.println("Deleting database contents....");
				    tx.commit();
				    
				}
				catch(Exception e)
				{
					System.out.println("# Error cleaning DB: " + e.getMessage());
					e.getStackTrace();
				} finally {
					if (tx.isActive()) {
						tx.rollback();
					}
					
					pm.close();
				}
			
			}
			catch (Exception e){
				e.getStackTrace();
			}
		
	}

}


*/
