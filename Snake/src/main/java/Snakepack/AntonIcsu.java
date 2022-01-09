package Snakepack;

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class AntonIcsu {

	public static void main(String[] args) {
		showWindow();
		
	}
	public static void showWindow() {
	final JFrame frame = new JFrame("Snake Game");
	frame.setBounds(200, 350,635,649);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setLayout(null);
	
	JLabel usernameLabel = new JLabel("");
	usernameLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
	usernameLabel.setHorizontalAlignment(SwingConstants.CENTER);
	usernameLabel.setBounds(139, 11, 342, 25);
	frame.getContentPane().add(usernameLabel);
	
	final JButton btnEasy = new JButton("Easy Mode");
	btnEasy.setFont(new Font("Tahoma", Font.PLAIN, 14));
	btnEasy.setBounds(37, 273, 150, 40);
	frame.getContentPane().add(btnEasy);
	
	JLabel highScor = new JLabel("Highest scores");
	highScor.setHorizontalAlignment(SwingConstants.CENTER);
	highScor.setFont(new Font("Tahoma", Font.PLAIN, 16));
	highScor.setBounds(139, 75, 342, 25);
	frame.getContentPane().add(highScor);
	
	JLabel highScor_1 = new JLabel("");
	highScor_1.setHorizontalAlignment(SwingConstants.CENTER);
	highScor_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
	highScor_1.setBounds(139, 118, 342, 25);
	frame.getContentPane().add(highScor_1);
	
	JLabel highScor_2 = new JLabel("");
	highScor_2.setHorizontalAlignment(SwingConstants.CENTER);
	highScor_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
	highScor_2.setBounds(139, 154, 342, 25);
	frame.getContentPane().add(highScor_2);
	
	JLabel highScor_3 = new JLabel("");
	highScor_3.setHorizontalAlignment(SwingConstants.CENTER);
	highScor_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
	highScor_3.setBounds(139, 190, 342, 25);
	frame.getContentPane().add(highScor_3);
	
	final JButton btnMediumMode = new JButton("Medium Mode");
	btnMediumMode.setFont(new Font("Tahoma", Font.PLAIN, 14));
	btnMediumMode.setBounds(232, 273, 150, 40);
	frame.getContentPane().add(btnMediumMode);
	
	final JButton btnHardMode = new JButton("Hard Mode");
	btnHardMode.setFont(new Font("Tahoma", Font.PLAIN, 14));
	btnHardMode.setBounds(429, 273, 150, 40);
	frame.getContentPane().add(btnHardMode);
	
	JLabel snakeColorLabel = new JLabel("Snake Color");
	snakeColorLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
	snakeColorLabel.setHorizontalAlignment(SwingConstants.CENTER);
	snakeColorLabel.setBounds(37, 459, 150, 40);
	frame.getContentPane().add(snakeColorLabel);
	
	JButton SnkCol = new JButton("");
	SnkCol.setForeground(Color.ORANGE);
	SnkCol.setBackground(Color.ORANGE);
	SnkCol.setFont(new Font("Tahoma", Font.PLAIN, 14));
	SnkCol.setBounds(76, 398, 40, 40);
	frame.getContentPane().add(SnkCol);
	
	JButton MpCol = new JButton("");
	MpCol.setForeground(Color.PINK);
	MpCol.setFont(new Font("Tahoma", Font.PLAIN, 14));
	MpCol.setBackground(Color.PINK);
	MpCol.setBounds(481, 398, 40, 40);
	frame.getContentPane().add(MpCol);
	
	JLabel lblBackgroundColor = new JLabel("Background Color");
	lblBackgroundColor.setHorizontalAlignment(SwingConstants.CENTER);
	lblBackgroundColor.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblBackgroundColor.setBounds(429, 459, 150, 40);
	frame.getContentPane().add(lblBackgroundColor);
	
	JButton btnStart = new JButton("START");
	btnStart.setFont(new Font("Segoe Script", Font.BOLD, 33));
	btnStart.setBounds(215, 494, 204, 76);
	frame.getContentPane().add(btnStart);
	
	JButton BackBtn = new JButton("Log out");
	BackBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
	BackBtn.setBounds(481, 559, 118, 42);
	frame.getContentPane().add(BackBtn);
	
	JLabel lblNewLabel = new JLabel("1 apple = 100p");
	lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
	lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel.setBounds(52, 335, 107, 32);
	frame.getContentPane().add(lblNewLabel);
	
	JLabel lblApple = new JLabel("1 apple = 150p");
	lblApple.setHorizontalAlignment(SwingConstants.CENTER);
	lblApple.setFont(new Font("Tahoma", Font.PLAIN, 13));
	lblApple.setBounds(248, 335, 107, 32);
	frame.getContentPane().add(lblApple);
	
	JLabel lblApple_1 = new JLabel("1 apple = 200p");
	lblApple_1.setHorizontalAlignment(SwingConstants.CENTER);
	lblApple_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
	lblApple_1.setBounds(449, 335, 107, 32);
	frame.getContentPane().add(lblApple_1);

	if(SnakeGame.PointsPerApp==150) {
		btnEasy.setEnabled(true);
		btnMediumMode.setEnabled(false);
		btnHardMode.setEnabled(true);
SnakeGame.speed=100;
	}
	
	if(SnakeGame.PointsPerApp==100) {
		btnEasy.setEnabled(false);
		btnMediumMode.setEnabled(true);
		btnHardMode.setEnabled(true);
		SnakeGame.speed=144;
	}
	if(SnakeGame.PointsPerApp==200) {
		btnEasy.setEnabled(true);
		btnMediumMode.setEnabled(true);
		btnHardMode.setEnabled(false);
		SnakeGame.speed=30;
	}
	
	btnEasy.addActionListener(new ActionListener() {

		public void actionPerformed(java.awt.event.ActionEvent e) {
			SnakeGame.PointsPerApp=100;
			btnEasy.setEnabled(false);
			btnMediumMode.setEnabled(true);
			btnHardMode.setEnabled(true);
			SnakeGame.speed=144;
			
			
		}});
	btnMediumMode.addActionListener(new ActionListener() {

		public void actionPerformed(java.awt.event.ActionEvent e) {
			SnakeGame.PointsPerApp=150;
			btnEasy.setEnabled(true);
			btnMediumMode.setEnabled(false);
			btnHardMode.setEnabled(true);
			SnakeGame.speed=100;
			
			
		}});
	btnHardMode.addActionListener(new ActionListener() {

		public void actionPerformed(java.awt.event.ActionEvent e) {
			SnakeGame.PointsPerApp=200;
			btnEasy.setEnabled(true);
			btnMediumMode.setEnabled(true);
			btnHardMode.setEnabled(false);
			SnakeGame.speed=70;
			
			
		}});

	SnkCol.addActionListener(new ActionListener() {

		public void actionPerformed(java.awt.event.ActionEvent e) {
			SnakeGame.ColorPickerMode="snake";
			new ColorPicker().createAndShowGUI();;
			frame.setVisible(false);
			
		}});
	MpCol.addActionListener(new ActionListener() {

		public void actionPerformed(java.awt.event.ActionEvent e) {
			SnakeGame.ColorPickerMode="map";
			new ColorPicker().createAndShowGUI();;
			frame.setVisible(false);
			
			
		}});
	
	btnStart.addActionListener(new ActionListener() {

		public void actionPerformed(java.awt.event.ActionEvent e) {
			new GameFrame();
			frame.setVisible(false);
			
			
		}});
	
	BackBtn.addActionListener(new ActionListener() {

		public void actionPerformed(java.awt.event.ActionEvent e) {
		
			frame.setVisible(false);
			SnakeGame.CurrentUser=-1;
			LogIn.showWindow();
			
			
		}});
	
	
	String q=" SELECT TOP 3 points FROM [SnakeScor] Where [user_id] = "+SnakeGame.CurrentUser  +" Order By [points] DESC";
	
	  ResultSet dbResponse;
	try {
		dbResponse = SnakeGame.conn.createStatement().executeQuery(q);
		 if(dbResponse != null) {int ok=0;
		  while (dbResponse.next()) {
			  if(ok==0) {highScor_1.setText(dbResponse.getString("points"));}
			  if(ok==1) {highScor_2.setText(dbResponse.getString("points"));}
			  if(ok==2) {highScor_3.setText(dbResponse.getString("points"));}
		
			ok++;
		  }}
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}

	 
	usernameLabel.setText(SnakeGame.UserName);
	SnkCol.setForeground(new Color(SnakeGame.SnakeR, SnakeGame.SnakeG, SnakeGame.SnakeB));
	SnkCol.setBackground(new Color(SnakeGame.SnakeR, SnakeGame.SnakeG, SnakeGame.SnakeB));
	MpCol.setForeground(new Color(SnakeGame.MapR, SnakeGame.MapG, SnakeGame.MapB));
	MpCol.setBackground(new Color(SnakeGame.MapR, SnakeGame.MapG, SnakeGame.MapB));
	frame.setLocationRelativeTo(null);

	frame.setVisible(true);
	
}
}