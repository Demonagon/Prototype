package implementation.world;

import core.world.WorldExecutor;
import core.world.WorldMaster;

public class SimpleWorldMaster implements WorldMaster {

	private SimpleWorld world;
	private SimpleWorldExecutor executor;
	
	public SimpleWorldMaster() {
		this.world = new SimpleWorld();
		this.executor = new SimpleWorldExecutor();
	}
	
	@Override
	public void spawnObject(Object object) {
		world.addObject(object);
	}

	@Override
	public void destroyObject(Object object) {
		world.removeEntity(object);
	}
	
	public SimpleWorldAnalyst getWorldAnalyst() {
		return world.getAnalyst();
	}

	@Override
	public WorldExecutor getExecutor() {
		return executor;
	}

}
