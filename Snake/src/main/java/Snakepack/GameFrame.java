package Snakepack;

import javax.swing.JFrame;

public class GameFrame extends JFrame {
	GameFrame(){ 
		SnakeGame.Points=0;
		this.add(new GamePanel(this));
		this.setTitle("Snake");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.pack();
		this.setVisible(true);
	    this.setLocationRelativeTo(null);
	}
}
