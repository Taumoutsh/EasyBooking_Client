package easybooking.client.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import easybooking.client.controller.AppController;
import easybooking.server.data.dto.FlightDTO;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Map;
import java.util.StringTokenizer;

import javax.swing.JTextField;

public class JFramePrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField departureAirport;
	private JTextField arrivalAirport;
	private JScrollPane scrollTVProgs1 = new JScrollPane();
	private JList<String> tvProgsList1 = new JList<String>();
	private DefaultListModel<String> tvProgsList = new DefaultListModel<String>();
	private AppController controller;
	private JLabel lblDeparture;
	private JLabel lblArrival;

	/**
	 * Launch the application.
	 */
	public void printWindow(JFrame frame) {
			try {	
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setBounds(100, 100, 600, 600);
				contentPane = new JPanel();
				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				contentPane.setLayout(new BorderLayout(0, 0));
				setContentPane(contentPane);
				
				// Label panel
				
				JPanel labelPanels = new JPanel();
				contentPane.add(labelPanels, BorderLayout.WEST);
				labelPanels.setLayout(new GridLayout(2,1));
					
				lblDeparture = new JLabel("Departure :");
				labelPanels.add(lblDeparture);
					
				lblArrival = new JLabel("Arrival :");
				labelPanels.add(lblArrival);
					
				JLabel lblEasybooking = new JLabel("EasyBooking");
				lblEasybooking.setHorizontalAlignment(SwingConstants.CENTER);
				contentPane.add(lblEasybooking, BorderLayout.NORTH);
				
				// Input panel
				
				JPanel inputPanel = new JPanel();
				contentPane.add(inputPanel, BorderLayout.CENTER);
				inputPanel.setLayout(new GridLayout(2,1));
				
				departureAirport = new JTextField();
				departureAirport.setPreferredSize(new Dimension(200, 24));
				inputPanel.add(departureAirport);
				arrivalAirport = new JTextField();
				arrivalAirport.setPreferredSize(new Dimension(200, 24));
				inputPanel.add(arrivalAirport);
				
				// Button panel
				
				JPanel buttonPanel = new JPanel();
				contentPane.add(buttonPanel, BorderLayout.NORTH);
				buttonPanel.setLayout(new GridLayout(2,2));
				
				JButton searchButton = new JButton();
				searchButton.setText("Search");
				searchButton.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						 searchButtonActionPerformed(evt);
						}

					});
				
				JButton viewFlightButton = new JButton();
				viewFlightButton.setText("View all flights");
				viewFlightButton.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
							viewFlightButtonActionPerformed(evt);
						}

					});
				
				buttonPanel.add(searchButton);
				buttonPanel.add(viewFlightButton);
				
				// Print flights panel
				
				scrollTVProgs1.setPreferredSize(new java.awt.Dimension(100, 110));
				scrollTVProgs1.add(tvProgsList1);
				tvProgsList1.setModel(tvProgsList);
				JButton bookButton = new JButton();
				bookButton.setText("Book a flight");
				bookButton.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
							bookButtonActionPerformed(evt);
					}

				});
				
				JPanel flightPanel = new JPanel((new GridLayout(4, 10)));
				flightPanel.add(tvProgsList1);
				flightPanel.add(bookButton);
				contentPane.add(flightPanel, BorderLayout.SOUTH);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

	/**
	 * Create the frame.
	 */
	public JFramePrincipal(AppController controller) {
		this.controller = controller;
		printWindow(this);
		this.setVisible(true);
		
	}
	
	private void viewFlightButtonActionPerformed(ActionEvent evt) {
		Map<String, ArrayList<FlightDTO>> allFlights = controller.printAllFlights();
		updateList(allFlights);
		
	}
	
	
	private void searchButtonActionPerformed(ActionEvent evt) {
		Map<String, ArrayList<FlightDTO>> allFlights = controller.searchFlight(departureAirport.getText(), arrivalAirport.getText());
		System.out.println("Search - Departure : "+departureAirport.getText()+", Arrival :"+arrivalAirport.getText());
		updateList(allFlights);
		
	}
	
	private void bookButtonActionPerformed(ActionEvent evt) {
		String selected = tvProgsList1.getSelectedValue();
		StringTokenizer st = new StringTokenizer(selected, " ");
		String flightNumber = st.nextToken();
		controller.book(flightNumber);
		
		System.out.println("Book - Departure : "+departureAirport.getText()+", Arrival :"+arrivalAirport.getText());
		
	}
	
	public void updateList(Map<String, ArrayList<FlightDTO>> allFlights) {
		
		tvProgsList.clear();
		
		for(Map.Entry<String, ArrayList<FlightDTO>> entry : allFlights.entrySet()) {
		    String key = entry.getKey();
		    ArrayList<FlightDTO> value = entry.getValue();
		    
		    for(FlightDTO flight : value) {
		    	System.out.println("FLIGHT : "+flight.getAirlineCode()+" - FLIGHT NB : "+flight.getFlightNumber()+" - FROM : "+flight.getDepatureAirportCode()+" - TO : "+flight.getArrivalAirportCode());
		    	tvProgsList.addElement(flight.getFlightNumber()+" FLIGHT : "+flight.getAirlineCode()+" - FROM : "+flight.getDepatureAirportCode()+" - TO : "+flight.getArrivalAirportCode());
		    }

		}
		
		tvProgsList1.setModel(tvProgsList);
		
	}

}
