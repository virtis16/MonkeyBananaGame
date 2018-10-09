/**
 * 
 */
package monkey_states;

import Game.Monkey;
import Game.MonkeyState;

/**
*
* Monkey is in motion.
* While the monkey is in motion and as the key is pressed, 
* the state of the monkey continues to be moving and 
* the MovementState is returned.
* 
* While the monkey is in motion and as the key player releases the key 
* the state of the monkey changes to idle and the IdleState is returned.
*/

public class MovementState extends MonkeyState {
	
	/* Size of one square in the grass land */
	public final static int sizeofsquare = 30;

//keyPress Up event
	public MonkeyState keyUp(Monkey monkey) {
		monkey.setY(monkey.getY() - sizeofsquare);
		monkey.setMonkeyState(this);
		return this;
	}
// keyPressDown event
	public MonkeyState keyDown(Monkey monkey) {
		monkey.setY(monkey.getY() + sizeofsquare);
		monkey.setMonkeyState(this);
		return this;
	}
//keyLeft event
	public MonkeyState keyLeft(Monkey monkey) {
		monkey.setX(monkey.getX() - sizeofsquare);
		monkey.setMonkeyState(this);
		return this;
	}
//keyRight event
	public MonkeyState keyRight(Monkey monkey) {
		monkey.setX(monkey.getX() + sizeofsquare);
		monkey.setMonkeyState(this);
		return this;
	}
//keyReleased event
	public MonkeyState keyReleased(Monkey monkey) {
		monkey.setMonkeyState(new IdleState());
		return new IdleState();
	}
}
