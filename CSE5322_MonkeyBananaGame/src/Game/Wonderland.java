/**
 * 
 */
package Game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Wonderland extends JPanel implements ActionListener, KeyListener, Runnable {

	private static final long serialVersionUID = 1L;
	//Declaration of Width and Height for the frame
    public static final int width = 640, height = width/12*9;
	private Monkey monkey;//Variable of the Class Monkey
	private Banana banana;//Variable of class Banana
	
	//Initializing the JFrame and Jpanel for displaying the event
	private static JFrame frame;
	private static JPanel controlPanel;
	private static JLabel timerLabel, labelforbanana, label_bananatimer, headerLabel ;
	Timer timer = new Timer(1000, this);
	/* Size of one square in the grass land */
	public final static int sizeofsquare = 30;

	/* Width of the frame*/
	public final static int width_frame_x = 600;

	/* Height of the frame */
	public final static int height_frame_y = 600;
	
	/* Calculate the difference for determining the collision */
	public final static int diff = 10;
	
	/* size of the images */
	public final static int sizeofimage = 30;
	
	/* total number of bananas */
	public final static int noofbananas = 10;


	private int TIMER_GAME = 60;

	private int TIMER_BANANA = 6;

	private int NO_OF_BANANAS_REMAINING = 10;

	private boolean isCollisionDetected;
	public static String Grass_Image ="resource/media/grass.jpg";
	ImageIcon grass_icon = new ImageIcon(Grass_Image);
	Image scaleImage_grass = grass_icon.getImage().getScaledInstance(700,750,Image.SCALE_DEFAULT);
	static Image backImage = (new ImageIcon(Grass_Image)).getImage();
	
	/*
	 * Initializing threads in order to invoke the game
	 * 
	 */

	private Thread thread;
	private boolean running = false;
    
	
	public synchronized void start(){
	
		thread = new Thread(this);
		thread.start();
		running=true;//boolean variable to see
	}
	
	public synchronized void stop()
	{
		try{
		thread.join();//Killing off the thread
		running=false;
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public void run(){
		
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while(running)
		{
			long now = System.nanoTime();
			delta += (now - lastTime)/ns;
			lastTime = now;
			while(delta >= 1)
			{
				tick();
				delta--;
			}
			if(running)
				render();
			frames++;
			if(System.currentTimeMillis() - timer > 1000)
			{
				timer += 1000;
				System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		stop();
	}
	
	private void tick()
	{
		
	}

	private void render()
	{
	
	}
			
		
	/*
	 * 
	 * End of the thread initialization
	 */
	//Main Method
	public static void main(String[] args) {
		//Calling the GUI method
		initializeUI();
	}
	
	/** Wonderland constructor that defines the dimensions of the frame*/
	 
	/**
	 * create monkey and banana in the wonderland. Constructor Wonderland
	 */
	public Wonderland() {
		timer.start();
		monkey = new Monkey();
		banana = new Banana();
		updateBananaPosition();
		addKeyListener(this);
		setBackground(Color.CYAN);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
	}


	/**
	 * create the frame and panel and add the GUI elements
	 */
	private static void initializeUI() {

		frame = new JFrame("Monkey & Banana Game");
        /* Set Width and Height of the Frame from the final variable declared VS*/
		frame.setPreferredSize(new Dimension(width_frame_x, height_frame_y));
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));
		labelforbanana = new JLabel("Total Number of bananas to be eaten = 10");
		System.out.println("\n");
		timerLabel = new JLabel("Time remaining = 20");
		System.out.println("\n");
		label_bananatimer = new JLabel("You have to eat this banana within 6 seconds");
		System.out.println("\n");
		/* Setting the header label in the center and set it as Opaque=true */
		headerLabel = new JLabel("Welcome to the Banana Monkey Game World" + "\n" , JLabel.CENTER);
//		headerLabel.setText("Welcome to the Banana Monkey Game World" + "\n"  );
		labelforbanana.setOpaque(true);
		timerLabel.setOpaque(true);
		label_bananatimer.setOpaque(true);
		headerLabel.setOpaque(true);

		label_bananatimer.setBackground(Color.WHITE);
		timerLabel.setBackground(Color.WHITE);
		labelforbanana.setBackground(Color.WHITE);
		headerLabel.setBackground(Color.GREEN);
		//Set the Font style
		Font font = new Font("Times New Roman", Font.BOLD, 14);
		headerLabel.setFont(font);
		timerLabel.setFont(font);
		labelforbanana.setFont(font);
		label_bananatimer.setFont(font);
		
	
		//controlPanel.add(labelforbanana);
//		Graphics2D graphic2d = (Graphics2D) g;
//		g.drawImage(backImage, 0, 0,600, 600, this);

		createPanel();
		createFrame();
	}
    /*
	 * Create a Frame with foreground and background color
	 */

	private static void createFrame() {
		frame.add(headerLabel);
//		Add the game to the frame by creating an instance of the class Wonderland
		frame.add(new Wonderland());
		frame.setBackground(Color.CYAN);
		frame.setForeground(Color.gray);
		frame.setResizable(false);
		frame.add(controlPanel, BorderLayout.NORTH);
		frame.pack();
		frame.setSize(width_frame_x, height_frame_y);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
	/*
	 * Create a Panel with foreground and background color
	 */

	private static void createPanel() {
		controlPanel = new JPanel();
		controlPanel.add(headerLabel);
		System.out.println("\n");
		controlPanel.add(timerLabel);
		System.out.println("\n");
		controlPanel.add(labelforbanana);
		System.out.println("\n");
		controlPanel.add(label_bananatimer);
		System.out.println("\n");
		controlPanel.setBounds(0, 0, 800, 30);
		controlPanel.setBackground(Color.CYAN);
		controlPanel.setForeground(Color.WHITE);

		
	}


	/**
	 * The method written below and the code inside is performed every second. TIMER_GAME and TIMER_BANANA are checked.
	 */
	public void actionPerformed(ActionEvent actionEvent) {
		timerLabel.setText("Welcome to the Banana Monkey Game World" + "\n"  );
		if (TIMER_BANANA > 0) {
			TIMER_BANANA--;
			label_bananatimer.setText("You should eat this banana within " + TIMER_BANANA + "seconds");
		}
		if (TIMER_BANANA < 0) {
			updateBananaPosition();
		} else if (TIMER_BANANA == 0) {
			updateBananaPosition();
			TIMER_BANANA = 8;
			repaint();
		}
		if (TIMER_GAME > 0) {
			TIMER_GAME--;
			timerLabel.setText("  Time left = " + TIMER_GAME);
		} else {
			gameOver();
		}
	}

	/**
	 * Once the Game is complete, display appropriate texts
	 */
	public void gameOver() {
		timer.stop();
		
		timerLabel.setText("  Game is complete "  +  "\n"  +  "Number of bananas eaten = " + (noofbananas - NO_OF_BANANAS_REMAINING));
		
		label_bananatimer.setText("");
		if (NO_OF_BANANAS_REMAINING > 0) {
			labelforbanana.setText("OOPS, You lose!!!" + "Please try hard later");
		} else {
			labelforbanana.setText("Congratulations, You win!!");
		}
		repaint();
	}


	/**
	 * updating the banana position
	 */
	public void updateBananaPosition() {
		banana.randomNumberGenerator();
	}

	/**
	 * paint banana and monkey on the UI
	 */
	public void paintComponent(Graphics g) {
//		Graphics object g used to position image
//		g.drawImage(backImage, 0, 0,null);
		super.paintComponent(g);
	
		
		if (TIMER_GAME > 0 && NO_OF_BANANAS_REMAINING > 0) {
			displayBanana(g);
      //Retrieve monkey and banana image from the Monkey Class
			g.drawImage(monkey.getMonkeyImage(), monkey.getX(), monkey.getY(), sizeofimage, sizeofimage, this);
			
			Font font = new Font("Times New Roman", Font.BOLD, 22);
			FontMetrics metric = this.getFontMetrics(font); 
			g.setColor(Color.RED);
			g.setFont(font);
		}
	}

	public void displayBanana(Graphics g) {
		g.drawImage(banana.getBananaImage(), banana.getX(), banana.getY(), sizeofimage, sizeofimage, this);
	}

	/**
	 * handle keyboard key pressed event
	 * 
	 * Also, handle the screen boundary conditions
	 */
	@Override
	public void keyPressed(KeyEvent e) {

		int code = e.getKeyCode();

		/**
		 *  keyboard up key is pressed
		 */
		if (code == KeyEvent.VK_UP) {
			if (monkey.getX() < 30) {
				monkey.setY(30);
			}
			monkey.keyUp(monkey);
		}
		
		/**
		 *  keyboard down key is pressed
		 */
		if (code == KeyEvent.VK_DOWN) {
			if (monkey.getY() > 480) {
				monkey.setY(480);
			}
			monkey.keyDown(monkey);
		}
		
		/**
		 *  keyboard left key is pressed
		 */
		if (code == KeyEvent.VK_LEFT) {
			if (monkey.getX() < 30) {
				monkey.setX(30);
			}
			monkey.keyLeft(monkey);
		}
		
		/**
		 *  keyboard right key is pressed
		 */
		if (code == KeyEvent.VK_RIGHT) {
			if (monkey.getX() > 510) {
				monkey.setX(510);
			}
			monkey.keyRight(monkey);
		}

		isCollisionDetected = checkCollision();

		/**
		 * if banana and monkey are colliding update the banana position
		 */
		if (isCollisionDetected == true && NO_OF_BANANAS_REMAINING >= 0) {
			labelforbanana.setText("Number of bananas to be eaten = " + NO_OF_BANANAS_REMAINING);
			updateBananaPosition();
			TIMER_BANANA = 8;
		}
		
		/**
		 * if bananas to be eaten is 0, then game is over
		 */
		if (NO_OF_BANANAS_REMAINING == 0)
			gameOver();
		repaint();
	}

	/**
	 * check if monkey banana collision
	 * 
	 * @return true; if positions of monkey and banana are same
	 * 		   false; otherwise
	 */
	public boolean checkCollision() {
		System.out.println("monkey and banana count " + "Monkey's X-coordinate" + monkey.getX() + "Banana's X co-ordinate position " + banana.getX() + " Monkey's Y co-ordinate" + monkey.getY() + " "
				+ banana.getY());
		if (monkey.getX() == banana.getX() && monkey.getY() == banana.getY()) {
			System.out.println("We are checking inside the checkCollision class");
			NO_OF_BANANAS_REMAINING--;
			return true;
		}
		return false;
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		monkey.keyReleased(monkey);
	}
}
