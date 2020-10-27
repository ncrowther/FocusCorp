/*
 * Licensed Materials - Property of IBM
 * 5725-B69 5655-Y17 5655-Y31 5724-X98 5724-Y15 5655-V82 
 * Copyright IBM Corp. 1987, 2013. All Rights Reserved.
 *
 * Note to U.S. Government Users Restricted Rights: 
 * Use, duplication or disclosure restricted by GSA ADP Schedule 
 * Contract with IBM Corp.
 */

package tester.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import org.apache.log4j.Logger;

/**
 * A panel that sends message-driven bean messages.
 */
public class QuotePanel extends JPanel {

	private static final long serialVersionUID = 1L;

	static Logger logger = Logger.getLogger(QuotePanel.class);

	public final static boolean RIGHT_TO_LEFT = false;

	private Vector<JComponent> tabelements = new Vector<JComponent>();
	
	private JTextField firstName = new JTextField("FIRSTNAME");
	private JTextField driverId = new JTextField("DRIVER_ID");
	private JTextField lastname = new JTextField("LASTNAME");
	private JTextField birthDate = new JTextField("BIRTHDATE");
	private JTextField policyNo = new JTextField("POLICY_NO");
	private JTextField vehicleYear = new JTextField("VEHICLE_YEAR");
	private JTextField vehicleMake = new JTextField("VEHICLE_MAKE");
	private JTextField vehicleModel = new JTextField("VEHICLE_MODEL");
	private JTextField vin = new JTextField("VIN");
	private JTextField bodilyInjuryLiability = new JTextField("INJURIES_LIMIT");
	private JTextField propertyDamage = new JTextField("PROPERTY_DAMAGE");
	private JTextField collisionWaiver = new JTextField("COLLISION_WAIVER");
	private JTextField uninsuredMotorists = new JTextField("UNISURED_MOTORIST");
	private JTextField comprehensive = new JTextField("COMPREHENSIVE");
	private JTextField emergencyRoadService = new JTextField("EMERGENCY_ROAD");
	private JTextField rentalReimbursement = new JTextField("RENTAL_REIMBURSEMENT");
	private JTextField insuredName = new JTextField("RENTAL_REIMBURSEMENT");	
	private JTextField address = new JTextField("RENTAL_REIMBURSEMENT");
	private JTextField phone = new JTextField("RENTAL_REIMBURSEMENT");
	private JTextField email = new JTextField("RENTAL_REIMBURSEMENT");
	
	private JCheckBox leinholder = new JCheckBox("");
	private JCheckBox additionalinsured = new JCheckBox("");
	private JCheckBox interestedParty = new JCheckBox("");
	private JTextField newPremium = new JTextField("");

	private JButton quote;
	private JButton cancel;

	private JPanel panselection;

	private class quoteButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			logger.info("Please wait.  Calculating premium.....");
						   
			QuotePanel.this.newPremium.setText("$345.34");
			QuotePanel.this.newPremium.setBackground(Color.GREEN);
		}

	}

	private class cancelButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			QuotePanel.this.newPremium.setText("");
		}
	}

	/**
	 * Constructs the sent message panel class.
	 *
	 * @param controller
	 *            The Controller of the GUI.
	 */
	public QuotePanel(Controller controller) {

		super(new BorderLayout());

		setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createTitledBorder("Quote Info"),
				BorderFactory.createEmptyBorder(5, 5, 5, 5)));

		addComponentsToPane();
		

	    ImageIcon img1 = new javax.swing.ImageIcon(getClass().getResource("/data/images/quote.png"));   
		quote = new JButton("quote", img1);
		quote.addActionListener(new quoteButtonListener());

	    ImageIcon img2 = new javax.swing.ImageIcon(getClass().getResource("/data/images/cancel.png"));   
		cancel = new JButton("cancel", img2);
		cancel.addActionListener(new cancelButtonListener());
		
		
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.X_AXIS));
		buttonPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		buttonPane.add(Box.createHorizontalGlue());
		buttonPane.add(Box.createRigidArea(new Dimension(10, 10)));
		buttonPane.add(quote);
		buttonPane.add(cancel);

		add(buttonPane, BorderLayout.AFTER_LAST_LINE);
	}

	/*
	 * Enables the components of the panel.
	 * 
	 * @see java.awt.Component#setEnabled(boolean)
	 */
	public void setEnabled(boolean enable) {
		Iterator<JComponent> it = tabelements.iterator();
		while (it.hasNext()) {
			JComponent jc = it.next();
			jc.setEnabled(enable);
		}
		quote.setEnabled(enable);
	}

	/*
	 * Enables the components of the panel.
	 * 
	 * @see java.awt.Component#setEnabled(boolean)
	 */

	private void addComponentsToPane() {

		panselection = new JPanel();
		panselection.setLayout(new BorderLayout());
		JPanel panLabel = new JPanel(new GridLayout(0, 1));
		JPanel panField = new JPanel(new GridLayout(0, 1));
			
		addTextField(driverId, panLabel, panField, "Driver ID :",
				"", "", true);
		addTextField(firstName, panLabel, panField, "First Name :", "", "",
				true);
		
		addTextField(lastname, panLabel, panField, "Last Name :", "",
				"", true);
		addTextField(birthDate, panLabel, panField, "Birth Date :",
				"birthDate", "", true);
		addTextField(policyNo, panLabel, panField, "Policy Number :",
				"policyNo", "", true);
		
		addTextField(insuredName, panLabel, panField, "Insured name :",
				"insuredName", "", true);
		addTextField(address, panLabel, panField, "Address :",
				"address", "", true);
		addTextField(phone, panLabel, panField, "Phone :",
				"phone", "", true);	
		addTextField(email, panLabel, panField, "Email :",
				"email", "", true);		
		
		addTextField(vehicleMake, panLabel, panField, "Vehicle Make :",
				"vehicleMake", "", true);

		addTextField(vehicleModel, panLabel, panField, "Vehicle Model :",
				"vehicleModel", "", true);
		
		addTextField(vehicleYear, panLabel, panField, "Vehicle Year :",
				"vehicleYear", "", true);

		addTextField(vin, panLabel, panField, "VIN :", "",
				"", true);		
		
		addTextField(bodilyInjuryLiability, panLabel, panField, "Bodily Injury Liability :",
				"bodilyInjuryLimit", "", true);

		addTextField(propertyDamage, panLabel, panField, "Property Damage Liability :",
				"propertyDamage", "", true);	
		
		addTextField(uninsuredMotorists, panLabel, panField, "Uninsured/Underinsured Motorists :",
				"uninsuredMotorists", "", true);	

		addTextField(comprehensive, panLabel, panField, "Comprehensive :",
				"comprehensive", "", true);	
		
		addTextField(collisionWaiver, panLabel, panField, "Collision :",
				"collisionWaiver", "", true);
		
		addTextField(emergencyRoadService, panLabel, panField, "Emergency Road Service :",
				"emergencyRoadService", "", true);	
		
		addTextField(rentalReimbursement, panLabel, panField, "Rental Reimbursement :",
				"rentalReimbursement", "", true);	
			
		addCheckBox(leinholder, panLabel, panField, "Leinholder :", "", true);	
		addCheckBox(additionalinsured, panLabel, panField, "Additional Insured :", "", true);			
		addCheckBox(interestedParty, panLabel, panField, "Interested Party :", "", true);	
		
		panLabel.add(new JSeparator());
		panField.add(new JSeparator());
		
		addTextField(newPremium, panLabel, panField, "New Premium :", "",
				"", false);

		panselection.add(panLabel, BorderLayout.WEST);
		panselection.add(panField, BorderLayout.CENTER);
		panselection.setMinimumSize(new Dimension(Integer.MAX_VALUE,
				Integer.MAX_VALUE));
		add(panselection, BorderLayout.CENTER);

	}

	private void addComboString(JComboBox<String> combo, JPanel panLabel,
			JPanel panField, String label, String name) {

		JLabel l = new JLabel(label, JLabel.TRAILING);
		panLabel.add(l);
		combo.setName(name);
		panField.add(combo);
		tabelements.add(combo);
	}

	private void addCheckBox(JCheckBox checkBox, JPanel panLabel,
			JPanel panField, String label, String name, boolean editable) {

		JLabel l = new JLabel(label, JLabel.TRAILING);
		panLabel.add(l);

		panField.add(checkBox);
		checkBox.setEnabled(editable);
		tabelements.add(checkBox);
	}

	private void addTextField(JTextField textField, JPanel panLabel,
			JPanel panField, String label, String name, String defaultvalue,
			boolean editable) {
		JLabel l = new JLabel(label, JLabel.TRAILING);
		// l.setFont(new Font("Helvetica", Font.PLAIN, 12));
		panLabel.add(l);

		//textField.setFont(new Font("Helvetica", Font.PLAIN, 8));
		l.setLabelFor(textField);
		textField.setText(defaultvalue);
		textField.setName(name);
		textField.setEditable(editable);
		panField.add(textField);
		tabelements.add(textField);
	}
	
}
