package Snakepack;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class SignUp {

	public static void main(String[] args) {
		showWindow();
		
	}
	public static void showWindow() {
	final JFrame frame = new JFrame("SignUp");
	frame.setBounds(200, 350,435,449);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setLayout(null);
	
	JLabel lblNewLabel = new JLabel("Username");
	lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
	lblNewLabel.setBounds(10, 48, 104, 52);
	frame.getContentPane().add(lblNewLabel);
	
	JLabel lblPassword = new JLabel("Password");
	lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
	lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
	lblPassword.setBounds(10, 128, 104, 52);
	frame.getContentPane().add(lblPassword);
	
	final JTextPane username = new JTextPane();
	username.setFont(new Font("Tahoma", Font.PLAIN, 14));
	username.setBounds(130, 60, 236, 40);
	frame.getContentPane().add(username);
	
	final JTextPane password = new JTextPane();
	password.setFont(new Font("Tahoma", Font.PLAIN, 14));
	password.setBounds(130, 128, 236, 40);
	frame.getContentPane().add(password);
	
	final JLabel warrning = new JLabel("");
	warrning.setFont(new Font("Tahoma", Font.PLAIN, 14));
	warrning.setHorizontalAlignment(SwingConstants.CENTER);
	warrning.setBounds(36, 323, 342, 25);
	frame.getContentPane().add(warrning);
	
	JButton btnSignIn = new JButton("Sign up");
	btnSignIn.setFont(new Font("Tahoma", Font.PLAIN, 14));
	btnSignIn.setBounds(150, 272, 120, 40);
	frame.getContentPane().add(btnSignIn);
	
	JLabel lblPasswordConfirmation = new JLabel("Password confirmation");
	lblPasswordConfirmation.setHorizontalAlignment(SwingConstants.CENTER);
	lblPasswordConfirmation.setFont(new Font("Tahoma", Font.PLAIN, 12));
	lblPasswordConfirmation.setBounds(0, 191, 133, 52);
	frame.getContentPane().add(lblPasswordConfirmation);
	
	final JTextPane passc = new JTextPane();
	passc.setFont(new Font("Tahoma", Font.PLAIN, 14));
	passc.setBounds(130, 203, 236, 40);
	frame.getContentPane().add(passc);
	
	JButton btnBackS = new JButton("Back");
	btnBackS.setFont(new Font("Tahoma", Font.PLAIN, 13));
	btnBackS.setBounds(294, 361, 89, 23);
	frame.getContentPane().add(btnBackS);
	
	btnBackS.addActionListener(new ActionListener() {

		public void actionPerformed(java.awt.event.ActionEvent e) {
			frame.setVisible(false);
			LogIn.showWindow();
		}});
	
	
	
	
	btnSignIn.addActionListener(new ActionListener() {

		public void actionPerformed(java.awt.event.ActionEvent e) {
		String usr= username.getText();
		String pass=password.getText();
	 String passConf =passc.getText();
			if(pass.equals(passConf)) {	
		 try {
			Statement stmt= SnakeGame.conn.createStatement();
			
			String q=" SELECT user_id FROM [SnakeUser] Where [username] = \'"+usr.toLowerCase()+"\'";
			
			System.out.println(q);
				  ResultSet dbResponse= stmt.executeQuery(q);
				 
				  if(dbResponse != null) {int ok=-1;
					  while (dbResponse.next()) {
						ok = dbResponse.getInt("user_id");
						
						
						
					 }
					  if(ok!=-1) {warrning.setText("Username already exist!");}
					  else {
					  String insertq= "Insert INTO SnakeUser ([username],[password])"
					  		+ "Values('"+usr.toLowerCase()+"','"+pass+"')";
					   stmt.execute(insertq);
					  frame.setVisible(false);
						LogIn.showWindow();
					  }
				  }
				  else {warrning.setText("Error!");}  
				
		 } catch (SQLException e1) {
			
			e1.printStackTrace();
		}	
		}
			else {warrning.setText("Confirmation password must be the same with password!");}	
		}
		
		}
		
			
			);
	
	
	
	
	frame.setLocationRelativeTo(null);

	frame.setVisible(true);
	
}
}