/**
 * 
 */
package Game;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import monkey_states.IdleState;

/**
 * 
 *
 * Monkey Class
 */
public class Monkey {

	private int x;
	private int y;
	private BufferedImage monkeyImage;
	MonkeyState monkeyState;//Object of the Monkeystate class

	/**
	 * Initialize the monkey with the co-ordinates (0,0)
	 */
	public Monkey() {
		monkeyState = new IdleState();
		x = 0;
		y = 0;
	}

	/**
	 * pass the monkey state to be set
	 * @param newMonkeyState
	 */
	public void setMonkeyState(MonkeyState newMonkeyState) {
		monkeyState = newMonkeyState;
	}

	/**
	 * monkey image is stored in the resource folder.
	 * @return monkey image
	 */
	public BufferedImage getMonkeyImage() {
		URL monkeyResource = getClass().getResource("/media/product_monkey.png");
		try {
			monkeyImage = ImageIO.read(monkeyResource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return monkeyImage;
	}

	public MonkeyState keyUp(Monkey monkey) {
		return monkeyState.keyUp(this);
	}

	public MonkeyState keyDown(Monkey monkey) {
		return monkeyState.keyDown(this);
	}

	public MonkeyState keyLeft(Monkey monkey) {
		return monkeyState.keyLeft(this);
	}

	public MonkeyState keyRight(Monkey monkey) {
		return monkeyState.keyRight(this);
	}

	public MonkeyState keyReleased(Monkey monkey) {
		return monkeyState.keyReleased(this);
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
