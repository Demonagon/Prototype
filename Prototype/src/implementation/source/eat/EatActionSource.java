package implementation.source.eat;

import implementation.human.Human;
import implementation.object.EatableObject;
import implementation.source.move.MoveActionSource;
import core.action.EvaluableAction;
import core.condition.SourceResultCondition;
import core.source.BasicSource;
import core.source.ChainedSource;
import core.source.Source;
import core.source.SourceListener;

public class EatActionSource extends ChainedSource<EvaluableAction> implements SourceListener {

	private EatActionFactory factory;
	private EatableObjectSource food_source;
	private MoveActionSource move_method_source;
	
	public EatActionSource(Human human) {
		factory = new EatActionFactory();
		factory.setActor(human);
		
		food_source = new EatableObjectSource(human);
		food_source.setSourceListener(this);
		
		move_method_source = new MoveActionSource(human);
		move_method_source.setSourceListener(this);
	}
	
	@Override
	public EvaluableAction getResult() {
		return factory.create();
	}

	@Override
	public void setCondition(SourceResultCondition condition) {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public void onNewObject(BasicSource origin) {
		if( origin == food_source )
			onNewFood( (Source<EatableObject>) origin);
		else if( origin == move_method_source )
			onNewMoveMethod( (Source<EvaluableAction>) origin);
	}

	public void onNewFood(Source<EatableObject> source) {
		if( factory.isBetter(source.getResult()) ) {
			factory.setFood(source.getResult());
			factory.caliberMove(move_method_source);
		}
	}
	
	public void onNewMoveMethod(Source<EvaluableAction> source) {
		
	}

	@Override
	public void onDeletedObject(BasicSource origin, Object object) {
		if( factory.getFood() == object ) {
			EvaluableAction old = factory.create();
			factory.setFood(null);
			this.notifyDeletedObject(old);
		}
	}

}
