/**
 * 
 */
package monkey_states;

import Game.Monkey;
import Game.MonkeyState;

/**
 * 
 * Monkey is in the idle or movement state
 * 
 * When the monkey is in the idle position and any key is pressed, then the state changes 
 * MovementState and the MovementState is returned
 */
public class IdleState extends MonkeyState {
	/* Size of one square in the grass land */
	public final static int sizeofsquare = 30;
	public MonkeyState keyUp(Monkey monkey) {
		monkey.setY(monkey.getY() - sizeofsquare);
		monkey.setMonkeyState(new MovementState());
		return new MovementState();
	}

	public MonkeyState keyRight(Monkey monkey) {
		monkey.setX(monkey.getX() + sizeofsquare);
		monkey.setMonkeyState(new MovementState());
		return new MovementState();
	}

	public MonkeyState keyDown(Monkey monkey) {
		monkey.setY(monkey.getY() + sizeofsquare);
		monkey.setMonkeyState(new MovementState());
		return new MovementState();
	}

	public MonkeyState keyLeft(Monkey monkey) {
		monkey.setX(monkey.getX() - sizeofsquare);
		monkey.setMonkeyState(new MovementState());
		return new MovementState();
	}

}
