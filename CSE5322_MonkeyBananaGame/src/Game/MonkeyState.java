package Game;
import java.awt.event.ActionEvent;

/**
 *States of Monkey on key press and key release 
 *Abstract class
 */
public abstract class MonkeyState {

	public MonkeyState keyUp(Monkey monkey) {
		return this.keyUp(monkey);
	}

	public MonkeyState keyRight(Monkey monkey) {
		return this.keyRight(monkey);
	}

	public MonkeyState keyDown(Monkey monkey) {
		return this.keyDown(monkey);
	}

	public MonkeyState keyLeft(Monkey monkey) {
		return this.keyLeft(monkey);
	}

	public MonkeyState keyReleased(Monkey monkey) {
		return this.keyReleased(monkey);
	}
}
