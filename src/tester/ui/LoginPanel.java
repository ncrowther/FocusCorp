package tester.ui;

import javax.swing.*;

import java.awt.event.*;

public class LoginPanel extends JFrame {

	private static final long serialVersionUID = 1L;

	private static JFrame mainDialog;
	
	JButton blogin;
	JPanel loginpanel;
	JTextField txuser;
	JTextField pass;
	JLabel username;
	JLabel password;

	public LoginPanel () {
	
	    blogin = new JButton("Login");
	    loginpanel = new JPanel();
	    txuser = new JTextField(15);
	    pass = new JPasswordField(15);
	    username = new JLabel("Username");
	    password = new JLabel("Password");

	    setSize(350,200);
	    setLocation(500,280);
	    loginpanel.setLayout (null); 

	    txuser.setBounds(70,30,150,20);
	    pass.setBounds(70,65,150,20);
	    blogin.setBounds(80,100,120,20);
	    username.setBounds(4,28,120,20);
	    username.setName("username");
	    password.setBounds(4,63,120,20);

	    loginpanel.add(blogin);
	    loginpanel.add(txuser);
	    loginpanel.add(pass);
	    loginpanel.add(username);
	    loginpanel.add(password);
	    
	    ImageIcon icon = new javax.swing.ImageIcon(getClass().getResource("/data/images/car.png"));   
	    setIconImage(icon.getImage());   
	    
	    this.setTitle("Focus Corp");

	    getContentPane().add(loginpanel);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setVisible(true);

	    blogin.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	        
	            txuser.setText("");
	            pass.setText("");
	            txuser.requestFocus();
	            
	            mainDialog.setVisible(true);
	            setVisible(false);
	            
	          }

	    });

	  }
	
	public static void setMain(JFrame mainFrame) {
		mainDialog = mainFrame;
	}

}