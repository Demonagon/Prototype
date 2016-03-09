package implementation.source.eat;

import core.action.EvaluableAction;
import core.actor.Actor;
import core.factory.Factory;
import implementation.action.ConcatenedAction;
import implementation.action.EatAction;
import implementation.action.move.MoveAction;
import implementation.action.move.WalkAction;
import implementation.object.EatableObject;
import implementation.source.move.MoveActionSource;

public class EatActionFactory implements Factory<EvaluableAction> {
	//Ressources
	private Actor actor;
	private EatableObject food;
	private MoveAction move_action;
	
	//Intermediary products
	private EatAction eat_action;
	
	private ConcatenedAction total_action;
	
	public EatActionFactory() {
		this.actor = null;
		this.food = null;
		this.move_action = null;
		this.eat_action = null;
		this.total_action = null;
	}
	
	public void setActor(Actor actor) {
		this.actor = actor;
		generateResult();
	}
	
	public double estimateFood(EatableObject food) {
		if( food == null ) return Double.NEGATIVE_INFINITY;
		return food.getNutritionValue() - food.getLocation().distance(actor.getLocation());
	}
	
	public boolean isBetter(EatableObject food) {
		return estimateFood(food) > estimateFood(this.food);
	}
	
	public double estimateMoveMethod(MoveAction move_action) {
		if( move_action == null ) return Double.NEGATIVE_INFINITY;
		return - move_action.getEffort();
	}
	
	public boolean isBetter(MoveAction move_action) {
		return estimateMoveMethod(move_action) > estimateMoveMethod(this.move_action);
	}
	
	public void setFood(EatableObject food) {
		this.food = food;
		this.move_action = null;
		resetResult();
	}
	
	public void setMoveMethod(MoveAction action) {
		this.move_action = action;
		generateResult();
	}
	
	public void caliberMove(MoveActionSource source) {
		source.setCondition(new MoveActionSource.MoveParameter(actor.getLocation(), food.getLocation()));
	}
	
	public EatableObject getFood() {
		return this.food;
	}
	
	public void generateResult() {
		if( actor == null || food == null || move_action == null ) {
			resetResult();
			return;
		}
		
		eat_action = new EatAction(food);
		total_action = new ConcatenedAction();
		total_action.addAction(move_action);
		total_action.addAction(eat_action);
	}
	
	public void resetResult() {
		total_action = null;
		eat_action = null;
	}

	@Override
	public EvaluableAction create() {
		return total_action;
	}
}
