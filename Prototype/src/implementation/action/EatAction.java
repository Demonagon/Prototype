package implementation.action;

import implementation.object.EatableObject;
import core.action.Action;
import core.action.ActionEvaluator;
import core.action.EvaluableAction;
import core.location.Location;

public class EatAction implements EvaluableAction {
	
	public final static double eating_effort = 0.2;

	EatableObject food;
	ActionEvaluator evaluator;
	
	public EatAction(EatableObject food) {
		this.food = food;
		setEvaluator( new EatActionEvaluator() );
	}
	
	@Override
	public Location getFinalPoint() {
		return food.getLocation();
	}

	@Override
	public double getEffort() {
		return eating_effort;
	}

	@Override
	public Object getResult() {
		return null;
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

	public class EatActionEvaluator implements ActionEvaluator {

		@Override
		public double evaluate(Action action) {
			return food.getNutritionValue() - getEffort();
		}
		
	}
	
	@Override
	public String toString() {
		return "{Eat " + food + "}";
	}
}
