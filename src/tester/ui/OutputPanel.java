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

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;


public class OutputPanel extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected JTextPane textArea;

	
	private Controller ctrl;

	public OutputPanel(Controller ctrl) {
		super(new GridBagLayout());
		setBorder(BorderFactory.createCompoundBorder(BorderFactory
				.createTitledBorder("Activity Log"), BorderFactory.createEmptyBorder(
				5, 5, 5, 5)));

		this.ctrl = ctrl;

		textArea = new JTextPane();
		textArea.setEditable(false);
		textArea.setAutoscrolls(true);
		JScrollPane scrollPane = new JScrollPane(textArea,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setAutoscrolls(true);

		//Add components to this panel.
		GridBagConstraints c = new GridBagConstraints();
		c.gridwidth = GridBagConstraints.REMAINDER;

		c.fill = GridBagConstraints.HORIZONTAL;

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1.0;
		c.weighty = 1.0;
		add(scrollPane, c);

		ctrl.setTextArea(textArea);
		
		//textArea.setText("User logged on");
	}

	public void actionPerformed(ActionEvent evt) {
		//ctrl.notifyChangeStateConnection();
	}

}
