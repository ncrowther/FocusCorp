/*
 * Licensed Materials - Property of IBM
 * 5725-B69 5655-Y17 5655-Y31 5724-X98 5724-Y15 5655-V82 
 * Copyright IBM Corp. 1987, 2013. All Rights Reserved.
 *
 * Note to U.S. Government Users Restricted Rights: 
 * Use, duplication or disclosure restricted by GSA ADP Schedule 
 * Contract with IBM Corp.
 */

package tester;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JSplitPane;
import javax.swing.ImageIcon;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import tester.ui.Controller;
import tester.ui.LoginPanel;
import tester.ui.OptionsMenu;
import tester.ui.OutputPanel;
import tester.ui.QuotePanel;


/**
 * This class invokes the message-driven rule bean using Java Swing.
 */
public class SwingJavaClient {
	
	static Logger logger = Logger.getLogger(SwingJavaClient.class);

	private JSplitPane quotePane;

	private QuotePanel quotePanel;

	private OutputPanel output;
	
	private static LoginPanel login;

	private Controller ctrl;

	private OptionsMenu optionsMenu;
	
	public SwingJavaClient() {
		
		Logger.getRootLogger().setLevel(Level.INFO);
		
		login = new LoginPanel();
		
		// Create the mvc controller.
		ctrl = new Controller();
		
		// Create the send message panel.
		quotePanel = new QuotePanel(ctrl);
		
		// Create the connect - output panel.
		output = new OutputPanel(ctrl);
       output.setPreferredSize(new Dimension(600, 50));
		

		quotePane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, quotePanel,
				output);

		quotePane.setOneTouchExpandable(true);
		quotePane.setDividerLocation(470);

		// Provide a preferred size for the split pane.
		quotePane.setPreferredSize(new Dimension(600, 650));
		
		quotePanel.setVisible(false);
		
		// Options Menu
		optionsMenu = new OptionsMenu(ctrl, quotePanel);

	}

	public OptionsMenu getMenu() {
		return optionsMenu;
	}

	public void changeConnectionState() {

	}

	public JSplitPane getSplitPane() {
		return quotePane;
	}

	/**
	 * Creates the user interface and displays it. For thread safety, this
	 * method should be invoked from the event-dispatching thread.
	 */
	private static void createAndShowGUI() {
		// Configure log4j.
		// PropertyConfigurator.configure("swinglog4j.properties");
		
		// Create and set up the window.
		JFrame mainFrame = new JFrame("Focus Corp");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SwingJavaClient mainScreen = new SwingJavaClient();
		mainFrame.getContentPane().add(mainScreen.getSplitPane());
		
	    ImageIcon icon = new javax.swing.ImageIcon(SwingJavaClient.class.getResource("/data/images/car.png"));   
		mainFrame.setIconImage(icon.getImage());

		mainFrame.setJMenuBar(mainScreen.getMenu().getMenuBar());

		mainScreen.optionsMenu.setParentFrame(mainFrame);

		// Display the window.
		mainFrame.pack();
		mainFrame.setVisible(false);
		
		login.setVisible(true);
		
		LoginPanel.setMain(mainFrame);
	}
	
	public static void main(String[] args) {
		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				createAndShowGUI();
			}
		});
	}
}
