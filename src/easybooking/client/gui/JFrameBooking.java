package easybooking.client.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;
import java.util.StringTokenizer;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.Dimension;

import easybooking.client.controller.AppController;
import easybooking.server.data.dto.FlightDTO;

public class JFrameBooking extends JFrame {

	private Container container = getContentPane();

	private AppController controller;
	
	private int price = 0;
	
	private String userAddress = "";
	private String flightNumber = "";
	
	private JLabel flightInfoLabel = new JLabel("Book the flight number : "+flightNumber);
	private JLabel userLabel = new JLabel("User : "+userAddress);
	private JLabel passengerLabel = new JLabel("- Add new passenger(s) (if you want to)");
	
	private JLabel name1Label = new JLabel("Name n°1 :");
	private JLabel surname1Label = new JLabel("Surname n°1 :");;
	private JTextField name1TextField = new JTextField();
	private JTextField surname1TextField = new JTextField();;
	
	private JLabel name2Label = new JLabel("Name n°2 :");
	private JLabel surname2Label = new JLabel("Surname n°2 :");
	private JTextField name2TextField = new JTextField();;
	private JTextField surname2TextField = new JTextField();;
	
	private JLabel payingLabel = new JLabel("Choose your paying method :");
	private ButtonGroup payingBg = new ButtonGroup();
	private JRadioButton visaRb = new JRadioButton("VISA");
	private JRadioButton mastercardRb = new JRadioButton("Mastercard");
	private JRadioButton payPalRb = new JRadioButton("PayPal");
	
	private JLabel priceLabel = new JLabel("The price to pay is : XX€");
	
	private JButton payButton = new JButton("Pay");
	
	public JFrameBooking(int price, String flightNumber, String userAddress, AppController controller) {
		this.price = price;
		this.flightNumber = flightNumber;
		this.controller = controller;
		this.userAddress = userAddress;
		setLayoutManager();
		setLocationAndSize();
		addComponentsToContainer();
		payingClickEvent(this);
		this.setTitle("Login Form");
		this.setVisible(true);
		this.setBounds(10,10,500,460);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
	}
	
	public void setLayoutManager()
	{
		container.setLayout(null);
	}
	
	public void setLocationAndSize()
	{
		
		// Change labels of flight and user and price
		
		userLabel.setText("User : "+userAddress);
		flightInfoLabel.setText("Book the flight number : "+flightNumber);
		priceLabel.setText("Price : "+price+"€ (by person)");
		
		//Setting location and Size of each components using setBounds() method.
		flightInfoLabel.setBounds(170, 30, 300, 30);
		userLabel.setBounds(50, 60, 300, 30);
		passengerLabel.setBounds(50, 90, 300, 30);
		
		name1Label.setBounds(50,150,300,30);
		surname1Label.setBounds(50,180,300,30);
		name1TextField.setBounds(150,150,300,30);
		surname1TextField.setBounds(150,180,300,30);
		
		name2Label.setBounds(50,210,300,30);
		surname2Label.setBounds(50,240,300,30);
		name2TextField.setBounds(150,210,300,30);
		surname2TextField.setBounds(150,240,300,30);
		
		payingLabel.setBounds(50,270,300,30);
		mastercardRb.setBounds(50,300,200,30);
		visaRb.setBounds(180,300,100,30);
		payPalRb.setBounds(250,300,100,30);
		
		priceLabel.setBounds(50,330,300,30);
		
		payButton.setBounds(50,370,100,30);
	
	}
	public void addComponentsToContainer()
	{
	
		//Adding button group
		visaRb.setActionCommand("Visa");
		payPalRb.setActionCommand("PayPal");
		mastercardRb.setActionCommand("Mastercard");
		
		payingBg.add(visaRb);
		payingBg.add(payPalRb);
		payingBg.add(mastercardRb);
	
		//Adding each components to the Container
		container.add(flightInfoLabel);
		container.add(userLabel);
		container.add(passengerLabel);
		container.add(name1Label);
		container.add(name1TextField);
		container.add(surname1Label);
		container.add(surname1TextField);
		container.add(name2Label);
		container.add(name2TextField);
		container.add(surname2Label);
		container.add(surname2TextField);
		container.add(payingLabel);
		container.add(mastercardRb);
		container.add(visaRb);
		container.add(payPalRb);
		container.add(priceLabel);
		container.add(payButton);
	}
	
	public void payingClickEvent(JFrame currentFrame) {
		
		payButton.addActionListener(new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	
		    	String authorizationService = payingBg.getSelection().getActionCommand();
		    	
		    	int paid = controller.pay(authorizationService);
		    	
		    	if(paid != 0) {
		    		
		    		System.out.println(paid);
		    	
			    	if(!(name1TextField.getText().isEmpty() && surname1TextField.getText().isEmpty())){
			    		if(!(name2TextField.getText().isEmpty() && surname2TextField.getText().isEmpty())){
			    			controller.book(flightNumber, name1TextField.getText(), surname1TextField.getText(), name2TextField.getText(), surname2TextField.getText());
				    	}
			    		else {
			    			controller.book(flightNumber, name1TextField.getText(), surname1TextField.getText(), "", "");
			    		}
			    	}
			    	else {
			    		controller.book(flightNumber, "", "", "", "");
			    	}
		    	}
		    	
		    }
		});
	}

	
}
