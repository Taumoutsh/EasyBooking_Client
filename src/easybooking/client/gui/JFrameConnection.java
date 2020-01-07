package easybooking.client.gui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import easybooking.client.controller.AppController;

public class JFrameConnection extends JFrame implements ActionListener{
	
	AppController controller;
	Container container= getContentPane ();
	JLabel userLabel=new JLabel("MAIL");
	JLabel passwordLabel=new JLabel("PASSWORD");
	JLabel authorizationServiceLabel=new JLabel("CONNECT WITH :");
	JTextField userTextField=new JTextField();
	JPasswordField passwordField=new JPasswordField();
	JButton loginButton=new JButton("CONNECT");
	JButton resetButton=new JButton("RESET");
	JCheckBox showPassword=new JCheckBox("Show Password");
	JRadioButton google = new JRadioButton("Google");
	JRadioButton facebook = new JRadioButton("Facebook");
	JRadioButton twitter = new JRadioButton("Twitter");
	ButtonGroup bg=new ButtonGroup();
	
	
	public JFrameConnection(AppController controller)
	{
		//Calling methods inside constructor.
		this.controller = controller;
		setLayoutManager();
		setLocationAndSize();
		addComponentsToContainer();
		loginClickEvent(this);
		this.setTitle("Login Form");
		this.setVisible(true);
		this.setBounds(10,10,370,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
	}
	public void setLayoutManager()
	{
		container.setLayout(null);
	}
	public void setLocationAndSize()
	{
		//Setting location and Size of each components using setBounds() method.
		userLabel.setBounds(50,150,100,30);
		passwordLabel.setBounds(50,220,100,30);
		authorizationServiceLabel.setBounds(130,300,150,50);
		userTextField.setBounds(150,150,150,30);
		passwordField.setBounds(150,220,150,30);
		showPassword.setBounds(150,250,150,30);
		loginButton.setBounds(50,400,100,30);
		resetButton.setBounds(200,400,100,30);
		google.setBounds(50, 350,100,30);
		facebook.setBounds(150, 350,100,30);
		twitter.setBounds(250, 350,100,30);
	
	}
	public void addComponentsToContainer()
	{
	
		//Adding button group
		google.setActionCommand("Google");
		facebook.setActionCommand("Facebook");
		twitter.setActionCommand("Twitter");
		
		bg.add(google);
		bg.add(facebook);
		bg.add(twitter);
	
		//Adding each components to the Container
		container.add(userLabel);
		container.add(passwordLabel);
		container.add(authorizationServiceLabel);
		container.add(userTextField);
		container.add(passwordField);
		container.add(showPassword);
		container.add(loginButton);
		container.add(resetButton);
		container.add(google);
		container.add(facebook);
		container.add(twitter);
	}
	
	public void exit(JFrame frame) {
		frame.setVisible(false);
	}
	
	public void loginClickEvent(JFrame currentFrame) {
		
		loginButton.addActionListener(new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	
		    	boolean connected = false;
		    	
		    	String authorizationService = bg.getSelection().getActionCommand();
		    	
		        connected = controller.logIn(authorizationService, userTextField.getText(), passwordField.getText());
		        System.out.println(authorizationService);
		        if(connected == true) {
		        	exit(currentFrame);
		        	JFramePrincipal frame = new JFramePrincipal(userTextField.getText(), controller);
		        }
		        else {
		        	JOptionPane.showMessageDialog(null, "The mail address or password is not recognized !");
		        }
		    }
		});
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
