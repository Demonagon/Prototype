package implementation.source.move;

import implementation.action.move.MoveAction;
import implementation.action.move.WalkAction;
import core.action.EvaluableAction;
import core.factory.Factory;

public class MoveActionFactory implements Factory<EvaluableAction> {

	private MoveActionSource.MoveParameter parameters;
	private MoveAction action;
	
	public MoveActionFactory() {
		setParameters(null);
	}
	
	public MoveActionFactory(MoveActionSource.MoveParameter parameters) {
		setParameters(parameters);
	}
	
	public void setParameters(MoveActionSource.MoveParameter parameters) {
		this.parameters = parameters;
		generateAction();
	}
	
	void generateAction() {
		if( this.parameters == null ) {
			action = null;
			return;
		}
		
		// Ici la marche est la seule option.
		// on pourra envisager de nouvelles façon de se déplacer, en fonction
		// des connaissances / des possessions du pnj.
		action = new WalkAction(parameters.getOrigin(), parameters.getDestination());
	}
	
	@Override
	public EvaluableAction create() {
		return action;
	}

}
