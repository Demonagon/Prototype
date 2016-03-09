package implementation.action;

import java.util.LinkedList;
import java.util.List;

import core.action.Action;
import core.action.ActionEvaluator;
import core.action.EvaluableAction;
import core.location.Location;

public class ConcatenedAction implements EvaluableAction {
	
	private List<Action> actions;
	
	private ActionEvaluator evaluator;

	public ConcatenedAction() {
		actions = new LinkedList<Action>();
		evaluator = new Evaluator();
	}
	
	public void addAction(Action action) {
		actions.add(action);
	}
	
	@Override
	public Location getFinalPoint() {
		return actions.get( actions.size() - 1 ).getFinalPoint();
	}

	@Override
	public double getEffort() {
		double total_effort = 0;
		for(Action action : actions)
			total_effort += action.getEffort();
		return total_effort;
	}

	@Override
	public Object getResult() {
		return actions.get( actions.size() - 1 ).getResult();
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
		public double evaluate(Action a) {
			double value = 0;
			
			for(Action action : actions) {
				if( action instanceof EvaluableAction )
					value += ((EvaluableAction) action).getValue();
				value -= action.getEffort();
			}
			
			return value;
		}
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("{Do ");
		for(int k = 0; k < actions.size() ; k++) {
			if( k < actions.size() - 1 )
				builder.append(actions.get(k) + " then ");
			else
				builder.append(actions.get(k) + " }");
		}
		
		return builder.toString();
	}
	
}
