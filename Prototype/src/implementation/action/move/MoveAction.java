package implementation.action.move;

import core.action.EvaluableAction;
import core.location.Location;

public abstract class MoveAction implements EvaluableAction {

	protected Location origin, destination;
	
	public MoveAction(Location origin, Location destination) {
		this.origin = origin;
		this.destination = destination;
	}
	
	@Override
	public Location getFinalPoint() {
		return destination;
	}

	@Override
	public Object getResult() {
		return null;
	}

}