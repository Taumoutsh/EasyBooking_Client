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

import javax.swing.JTextField;

public class JFramePrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField departureAirport;
	private JTextField arrivalAirport;
	private JScrollPane scrollTVProgs1 = new JScrollPane();
	private JList<String> tvProgsList1 = new JList<String>();
	private DefaultListModel<String> tvProgsList = new DefaultListModel<String>();
	private AppController controller;

	/**
	 * Launch the application.
	 */
	public void printWindow(JFrame frame) {
			try {	
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setBounds(100, 100, 600, 400);
				contentPane = new JPanel();
				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				contentPane.setLayout(new BorderLayout(0, 0));
				setContentPane(contentPane);
				
				// Label panel
				
				JPanel labelPanels = new JPanel();
				contentPane.add(labelPanels, BorderLayout.WEST);
				labelPanels.setLayout(new GridLayout(2,1));
					
				JLabel lblSearchBy = new JLabel("Departure :");
				labelPanels.add(lblSearchBy);
					
				JLabel lblNewLabel = new JLabel("Arrival :");
				labelPanels.add(lblNewLabel);
					
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
				contentPane.add(buttonPanel, BorderLayout.SOUTH);
				buttonPanel.setLayout(new GridLayout(2,2));
				
				JButton searchButton = new JButton();
				searchButton.setText("Search");
				
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
				
				JPanel flightPanel = new JPanel((new GridLayout(4, 0)));
				flightPanel.add(scrollTVProgs1);
				contentPane.add(flightPanel);
				
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
	
	public void updateList(Map<String, ArrayList<FlightDTO>> allFlights) {
		
		for(Map.Entry<String, ArrayList<FlightDTO>> entry : allFlights.entrySet()) {
		    String key = entry.getKey();
		    ArrayList<FlightDTO> value = entry.getValue();
		    
		    tvProgsList.clear();
		    
		    for(FlightDTO flight : value) {
		    	System.out.println(flight.getArrivalAirportCode());
		    	tvProgsList.addElement(flight.getArrivalAirportCode());
		    }

		}
		
	}

}
