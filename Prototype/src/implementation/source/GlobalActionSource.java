package implementation.source;

import implementation.human.Human;
import implementation.source.eat.EatActionSource;
import core.action.Action;
import core.action.EvaluableAction;
import core.condition.SourceResultCondition;
import core.source.ChainedSource;
import core.source.Source;
import core.source.SourceListener;

public class GlobalActionSource extends ChainedSource<Action> implements SourceListener<EvaluableAction> {
	
	private EvaluableAction best_action;
	
	public GlobalActionSource(Human actor) {
		setSourceListener(actor);
		new EatActionSource(actor).setSourceListener(this);
		best_action = null;
	}

	@Override
	public Action getResult() {
		return best_action;
	}

	@Override
	public void setCondition(SourceResultCondition condition) {}

	@Override
	public void onNewObject(Source<EvaluableAction> origin) {
		if( best_action == null ) {
			best_action = origin.getResult();
			notifyNewObject();
		}
		else if( origin.getResult().getValue() > best_action.getValue()) {
			best_action = origin.getResult();
			notifyNewObject();
		}
	}

	@Override
	public void onDeletedObject(Source<EvaluableAction> origin, EvaluableAction object) {
		if( object == best_action )  {
			best_action = null;
			notifyDeletedObject(object);
		}
	}

}
