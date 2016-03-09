package implementation.action.move;

import core.action.Action;
import core.action.ActionEvaluator;
import core.location.Location;

public class WalkAction extends MoveAction {
	
	public final static double effort_per_meter = 0.1;
	
	private ActionEvaluator evaluator;
	
	public WalkAction(Location origin, Location destination) {
		super(origin, destination);
		evaluator = new Evaluator();
	}

	@Override
	public double getEffort() {
		return destination.distance(origin) * effort_per_meter;
	}
	
	@Override
	public String toString() {
		return "{Walk from " + origin + " to " + destination + "}";
	}

	@Override
	public ActionEvaluator getEvaluator() {
		return evaluator;
	}

	@Override
	public void setEvaluator(ActionEvaluator evaluator) {
		this.evaluator = evaluator;
	}

	@Override
	public double getValue() {
		return evaluator.evaluate(this);
	}
	
	public class Evaluator implements ActionEvaluator {

		@Override
		public double evaluate(Action action) {
			return - getEffort();
		}
	}

}
