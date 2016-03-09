package implementation.world;

import implementation.human.Human;
import implementation.object.EatableObject;
import implementation.world.indexers.ObjectIndexer;

public class SimpleIndexMaster {
	private ObjectIndexer<EatableObject> eatable_indexer;
	private ObjectIndexer<Human> human_indexer;
	
	public SimpleIndexMaster(SimpleWorldAnalyst main_analyst) {
		eatable_indexer = new ObjectIndexer<EatableObject>(EatableObject.class);
		human_indexer = new ObjectIndexer<Human>(Human.class);
		
		main_analyst.addAnalyst(eatable_indexer);
		main_analyst.addAnalyst(human_indexer);
	}
	
	public ObjectIndexer<EatableObject> getEatableObjectIndexer() {
		return eatable_indexer;
	}
	
	public ObjectIndexer<Human> getHumanIndexer() {
		return human_indexer;
	}
}
