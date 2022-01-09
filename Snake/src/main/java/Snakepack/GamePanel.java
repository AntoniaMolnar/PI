package Snakepack;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

import javax.swing.JPanel;


public class GamePanel extends JPanel implements ActionListener {
	
	static final int SCREEN_WIDTH=600;
	static final int SCREEN_HEIGHT=600;
	static final int UNIT_SIZE=20;
	static final int GAME_UNITS = (SCREEN_WIDTH*SCREEN_HEIGHT)/UNIT_SIZE;
	static int DELAY= SnakeGame.speed;
	
	final int x[]= new int [GAME_UNITS];
	final int y[]= new int [GAME_UNITS];
	int bodyParts= 5;
	int applesEaten;
	int appleX;
	int appleY;
	char direction = 'D';
	boolean running= false;
	Timer timer;
	Random random;
	GameFrame wind;
	GamePanel (GameFrame win){
		wind =win;
		DELAY=SnakeGame.speed;
		random= new Random();
		this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
		this.setBackground(new Color(SnakeGame.MapR, SnakeGame.MapG, SnakeGame.MapB));
		this.setFocusable(true);
		this.addKeyListener(new MyKeyAdapter());
		startGame();				
		
	}
	public void startGame() {
		
		newApple();
		running=true;
		timer= new Timer(DELAY,this);
		timer.start();
		
	}
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		draw(g);
		
	} 
	
	public void draw (Graphics g) {
		
		/*for(int i=0; i<SCREEN_HEIGHT/UNIT_SIZE; i++) {
			
			g.drawLine(i*UNIT_SIZE,0,i*UNIT_SIZE, SCREEN_HEIGHT);
			g.drawLine(0,i*UNIT_SIZE,SCREEN_HEIGHT,i*UNIT_SIZE);
		}*/
		g.setColor(new Color(28, 133, 23));
		g.fillOval(appleX,appleY, UNIT_SIZE, UNIT_SIZE);
		
		for (int i=0; i<bodyParts; i++) {
			if(i==0) {
				g.setColor(new Color(SnakeGame.SnakeR, SnakeGame.SnakeG, SnakeGame.SnakeB));
				g.fillRect(x[i],y[i],UNIT_SIZE,UNIT_SIZE);
			}
			else {
				g.setColor(new Color(SnakeGame.SnakeR, SnakeGame.SnakeG, SnakeGame.SnakeB));
				g.fillRect(x[i],y[i],UNIT_SIZE,UNIT_SIZE);
			}
		}
	}
	
	public void newApple() {
		
		appleX= random.nextInt((int)(SCREEN_WIDTH/UNIT_SIZE))*UNIT_SIZE;
		appleY= random.nextInt((int)(SCREEN_HEIGHT/UNIT_SIZE))*UNIT_SIZE;
	}
	public void move() {
		
		for(int i=bodyParts; i>0; i--) {
			x[i]=x[i-1];
			y[i]=y[i-1];
		}
		// iteram prin elem corpului
		switch(direction) {
		case 'W':
			y[0]= y[0]-UNIT_SIZE;
			break;  // cand merge in sus
		case 'S':
			y[0]= y[0]+UNIT_SIZE;
			break; // cand merge in jos
		case 'A':
			x[0]= x[0]-UNIT_SIZE;
			break; // cand merge in stanga
		case 'D':
			x[0]= x[0]+UNIT_SIZE;
			break; // cand merge in dreapta
		}
	}
	
	public void checkApple() {
		
	}
	
	public void checkCollisions() {
		for(int i=bodyParts; i>0;i--) {
			if(x[0]==appleX && y[0]==appleY) {
				this.bodyParts++;
				newApple();
				SnakeGame.Points+=SnakeGame.PointsPerApp;
				
			}
			//daca se loveste de corp -> end game
			if((x[0]==x[i]) && (y[0]==y[i])) running= false;
		}
		//daca se loveste de perete-stanga -> end game
		if(x[0]<0) running= false;
		//daca se loveste de perete-dreapta -> end game
		if(x[0]>SCREEN_WIDTH) running= false;
		//daca se loveste de perete-sus -> end game
		if(y[0]<0) running= false;
		//daca se loveste de perete-jos -> end game
		if(y[0]> SCREEN_HEIGHT) running= false;

		if (!running) { timer.stop();
		this.wind.setVisible(false);
		  String insertq= "Insert INTO SnakeScor ([user_id],[points])"
			  		+ "Values('"+SnakeGame.CurrentUser+"','"+SnakeGame.Points+"')";
			  try {
			SnakeGame.conn.createStatement().execute(insertq);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			  GameOver.showWindow();
		}
		
	}
	
	public void gameOver(Graphics g) {
		
	}	 
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(running) {
			move();
			checkApple();
			checkCollisions();
			
		}
	
		repaint();
	}
	
	public class MyKeyAdapter extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			direction=e.getKeyText(e.getKeyCode()).toCharArray()[0];
		}
	}
	
void getKey() {

}
}
