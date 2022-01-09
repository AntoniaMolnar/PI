package Snakepack;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class GameOver {
	
public static void main(String[] args) {showWindow();}
	public static void showWindow() {
		final JFrame frame =new JFrame("GameOver");
		frame.setBounds(200, 350,550,500);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.getContentPane().setLayout(null);
		JLabel lblGameOver = new JLabel("GAME OVER!");
	    lblGameOver.setHorizontalAlignment(SwingConstants.CENTER);
	    lblGameOver.setFont(new Font("Jokerman", Font.PLAIN, 40));
	    lblGameOver.setBounds(112, 62, 322, 112);
	    frame.getContentPane().add(lblGameOver);
	    
	    JLabel lblScoreResult = new JLabel("Your score is: "+SnakeGame.Points);
	    lblScoreResult.setFont(new Font("Jokerman", Font.PLAIN, 20));
	    lblScoreResult.setHorizontalAlignment(SwingConstants.CENTER);
	    lblScoreResult.setBounds(89, 185, 275, 87);
	    frame.getContentPane().add(lblScoreResult);
	    
	    JButton btnPlayAgain = new JButton("Play again");
	    btnPlayAgain.setFont(new Font("Tahoma", Font.BOLD, 15));
	    btnPlayAgain.setBounds(199, 343, 144, 48);
	    frame.getContentPane().add(btnPlayAgain);
	    btnPlayAgain.addActionListener(new ActionListener() {

    		public void actionPerformed(java.awt.event.ActionEvent e) {
    			
    		frame.setVisible(false);
    			AntonIcsu.showWindow();
    		}});
	    frame.setLocationRelativeTo(null);
	    frame.setVisible(true);
	    
	}
}
