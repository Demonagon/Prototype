package implementation.world;

import core.world.World;

public class SimpleWorld implements World {
	
	private SimpleWorldAnalyst analyst;
	
	public SimpleWorld(/*Artist artist*/) {
		analyst = new SimpleWorldAnalyst(/*artist*/);
	}
	
	public void addObject(Object object) {
		analyst.onSpawn(object);
	}
	
	public void removeEntity(Object object) {
		analyst.onRemoval(object);
	}
	
	public SimpleWorldAnalyst getAnalyst() {
		return analyst;
	}
}
