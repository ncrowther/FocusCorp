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

import javax.swing.JTextPane;

import org.apache.log4j.Logger;



/**
 * MVC Design Pattern. The controller translates interactions with the view into
 * actions to be performed by the model. In a stand-alone GUI client, user
 * interactions could be button clicks or menu selections. The actions performed
 * by the model include activating business processes or changing the state of
 * the model.
 */
public class Controller {
	static Logger logger = Logger.getLogger(Controller.class);

    static  String clientId = "ee7e1154-0a5c-4d54-8870-a578418e47d6";

	JTextPane textArea;
	
	public Controller() {		
	}
	
	public JTextPane getTextArea() {
		return textArea;
	}

	public void setTextArea(JTextPane textArea) {
		this.textArea = textArea;
	}



}
