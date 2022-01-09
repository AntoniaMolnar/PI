package Snakepack;

import java.awt.*;

import java.awt.event.*;
import java.util.concurrent.CompletableFuture;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.colorchooser.*;

/* ColorChooserDemo.java requires no other files. */
public class ColorPicker extends JPanel implements ChangeListener {
	 
	private static JFrame frame = new JFrame("ColorChooserDemo");

    protected JColorChooser tcc;
    protected JLabel banner;
    public static void createAndShowGUI() {
        //Create and set up the window.
    	
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        JComponent newContentPane = new ColorPicker();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
    public ColorPicker() {
        super(new BorderLayout());

        //Set up the banner at the top of the window
        banner = new JLabel("Welcome to the Tutorial Zone!",
                            JLabel.CENTER);
        banner.setForeground(Color.yellow);
        banner.setBackground(Color.blue);
        banner.setOpaque(true);
        banner.setFont(new Font("SansSerif", Font.BOLD, 24));
        banner.setPreferredSize(new Dimension(100, 65));

        JPanel bannerPanel = new JPanel(new BorderLayout());
        bannerPanel.add(banner, BorderLayout.CENTER);
        bannerPanel.setBorder(BorderFactory.createTitledBorder("Banner"));

        //Set up color chooser for setting text color
        tcc = new JColorChooser(banner.getForeground());
        tcc.getSelectionModel().addChangeListener(this);
        tcc.setBorder(BorderFactory.createTitledBorder(
                                             "Choose Text Color"));

        //add(bannerPanel, BorderLayout.CENTER);
        add(tcc, BorderLayout.PAGE_END);
        
        JButton btnNewButton = new JButton("Select");
        btnNewButton.setBackground(Color.RED);
        add(btnNewButton, BorderLayout.NORTH);
        btnNewButton.addActionListener(new ActionListener() {

    		public void actionPerformed(java.awt.event.ActionEvent e) {
    			
    		frame.setVisible(false);
    			AntonIcsu.showWindow();
    		}});
    }

    public void stateChanged(ChangeEvent e) {
        Color newColor = tcc.getColor();
      
       if(SnakeGame.ColorPickerMode.equals("snake")) {

       SnakeGame.SnakeR=newColor.getRed();
       SnakeGame.SnakeG=newColor.getGreen();
       SnakeGame.SnakeB=newColor.getBlue();
       }
       if(SnakeGame.ColorPickerMode.equals("map")) {
       SnakeGame.MapR=newColor.getRed();
       SnakeGame.MapG=newColor.getGreen();
       SnakeGame.MapB=newColor.getBlue();}
    }

	
	
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
   

    public static void main(String[] args) { 
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
      javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
    
}