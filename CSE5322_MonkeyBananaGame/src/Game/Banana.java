/**
 * 
 */
package Game;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.Random;

/**
 * 
 *
 * Banana Class
 */
public class Banana {
/*Defining the x and y variables positions for the Banana Image */
	private int x;
	private int y;
	private BufferedImage bananaImage;
	private Random random;
	/* Defining the variables required for the movement of the Banana and Monkey */
	
	/* Size of one sqaure in the grassland */
	public final static int sizeofsquare = 30;

	/* Width of the frame*/
	public final static int width_frame_x = 800;

	/* Height of the frame */
	public final static int height_frame_y = 800;

	/**
	 *  Resource folder contains the image of banana.
	 * @return banana image
	 */
	public BufferedImage getBananaImage() {
		URL bananaResource = getClass().getResource("/media/banana.png");
		try {
			bananaImage = ImageIO.read(bananaResource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bananaImage;
	}

	/**
	 *  calculate all the co-ordinates of the banana with the help of Java.Util.Random function
	 * @return banana
	 */
	public Banana randomNumberGenerator() {
		random = new Random();//Generates the random number for the movement of the banana and monkey
		x = random.nextInt(19) * sizeofsquare;
		y = random.nextInt(19) * sizeofsquare;
		if (x >= width_frame_x || y >= height_frame_y)
			randomNumberGenerator();
		return this;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}
}
