package implementation.source.eat;

import implementation.human.Human;
import implementation.object.EatableObject;
import implementation.world.SimpleWorldMaster;
import implementation.world.indexers.ObjectIndexer;
import core.condition.SourceResultCondition;
import core.source.ChainedSource;

public class EatableObjectSource extends ChainedSource<EatableObject> implements ObjectIndexer.SpawnListener<EatableObject> {

	public EatableObject current_object;
	
	public EatableObjectSource(Human human) {
		current_object = null;
		SimpleWorldMaster master = (SimpleWorldMaster) human.getWorldMaster();
		master.getWorldAnalyst().getIndexMaster().getEatableObjectIndexer().addListener(this);
	}
	
	@Override
	public EatableObject getResult() {
		return current_object;
	}

	@Override
	public void setCondition(SourceResultCondition condition) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onSpawn(EatableObject object) {
		this.current_object = object;
		notifyNewObject();
	}

	@Override
	public void onRemoval(EatableObject object) {
		if( object == current_object ) {
			EatableObject old = current_object;
			current_object = null;
			notifyDeletedObject(old);
		}
	}

}
