package core.world;

public interface WorldMaster {
	public void spawnObject(Object object);
	public void destroyObject(Object object);
	
	public WorldExecutor getExecutor();
}
