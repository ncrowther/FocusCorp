package tester.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import org.apache.log4j.Logger;

import tester.ui.Controller;


public class OptionsMenu {

	static final String BUILD_VERSION = "Build: 26-Oct-2020";
	static Logger logger = Logger.getLogger(OptionsMenu.class);
	
	JMenuBar menuBar;
	Controller ctrl;
	JFrame parentFrame;
	QuotePanel quotePanel;
	
	public OptionsMenu(Controller ctrl, QuotePanel quotePanel) {
		menuBar = createMenu();
		this.ctrl = ctrl;
		this.quotePanel = quotePanel;
	}

	ActionListener quoteListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent event) {
			logger.info("Menu item [" + event.getActionCommand()
					+ "] was pressed.");
		quotePanel.setVisible(true);
		}
	};
	
	ActionListener quitListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent event) {
			logger.info("Menu item [" + event.getActionCommand()
					+ "] was pressed.");

			parentFrame.dispose();
		}
	};
	
	ActionListener aboutListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent event) {
			logger.info("About menu item [" + event.getActionCommand()
					+ "] was pressed.");
				
			
		    ImageIcon carIco = new javax.swing.ImageIcon(getClass().getResource("/data/images/car.png"));  
			
			JOptionPane.showMessageDialog(null,
			    "Focus Corp\nAuthor: Nigel T. Crowther\n" + BUILD_VERSION,
			    "Quote UI",
			    JOptionPane.INFORMATION_MESSAGE,carIco);
		
		}
	};	

	private JMenuBar createMenu() {
		// Create the menu bar.
		JMenuBar menuBar = new JMenuBar();

		// options menu.
		JMenu optionsMenu = new JMenu("Options");
		optionsMenu.setMnemonic(KeyEvent.VK_A);
		optionsMenu.getAccessibleContext().setAccessibleDescription("Options to run");
		menuBar.add(optionsMenu);

		// Accounts menu
		JMenuItem accounts = new JMenuItem("Accounts", KeyEvent.VK_A);
		optionsMenu.add(accounts);

		// Refunds menu
		JMenuItem refunds = new JMenuItem("Refunds", KeyEvent.VK_A);
		optionsMenu.add(refunds);

		// PO menu
		JMenuItem po = new JMenuItem("Purchase Orders", KeyEvent.VK_A);
		optionsMenu.add(po);

		// Invoices menu
		JMenuItem invoices = new JMenuItem("Invoices", KeyEvent.VK_A);
		optionsMenu.add(invoices);
		
		// Policies menu
		JMenuItem policies = new JMenuItem("Policies", KeyEvent.VK_A);
		optionsMenu.add(policies);
		
		// Quotes menu
		JMenuItem quotes = new JMenuItem("Quotes", KeyEvent.VK_A);
		quotes.addActionListener(quoteListener);
		optionsMenu.add(quotes);
		
		// Quit menu
		JMenuItem quit = new JMenuItem("Exit", KeyEvent.VK_Q);
		quit.addActionListener(quitListener);
		optionsMenu.add(quit);
		
		
		// Help menu
		JMenu helpMenu = new JMenu("Help");
		helpMenu.setMnemonic(KeyEvent.VK_H);
		helpMenu.getAccessibleContext().setAccessibleDescription("Help");
		menuBar.add(helpMenu);
		
		// About menu
		JMenuItem about = new JMenuItem("About", KeyEvent.VK_A);
		about.addActionListener(aboutListener);
		helpMenu.add(about);
		
		return menuBar;
	}
	
	public JMenuBar getMenuBar() {
		return menuBar;
	}

	public void setMenuBar(JMenuBar menuBar) {
		this.menuBar = menuBar;
	}

	public void setParentFrame(JFrame parentFrame) {
		this.parentFrame = parentFrame;
	}
}
