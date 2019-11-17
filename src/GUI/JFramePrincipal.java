package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.GridLayout;
import javax.swing.JTextField;

public class JFramePrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField departureDate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFramePrincipal frame = new JFramePrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JFramePrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel labelPanels = new JPanel();
		contentPane.add(labelPanels, BorderLayout.WEST);
		labelPanels.setLayout(new GridLayout(2,1));
		
		JLabel lblSearchBy = new JLabel("Search by");
		labelPanels.add(lblSearchBy);
		
		JLabel lblNewLabel = new JLabel("Departure date");
		labelPanels.add(lblNewLabel);
		
		JLabel lblEasybooking = new JLabel("EasyBooking");
		lblEasybooking.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblEasybooking, BorderLayout.NORTH);
		
		JPanel inputPanel = new JPanel();
		contentPane.add(inputPanel, BorderLayout.CENTER);
		inputPanel.setLayout(new GridLayout(2,1));
		
		JComboBox SelectSearchVariable = new JComboBox();
		inputPanel.add(SelectSearchVariable);
		SelectSearchVariable.setModel(new DefaultComboBoxModel(new String[] {"Airport", "Airline", "Destination", "Origin"}));
		
		departureDate = new JTextField();
		inputPanel.add(departureDate);
		departureDate.setColumns(10);
	}

}
