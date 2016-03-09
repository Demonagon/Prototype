package core.actor;

import core.object.LocatedObject;
import core.world.WorldMaster;

public interface Actor extends LocatedObject, Runnable {
	public void setWorldMaster(WorldMaster master);
	public WorldMaster getWorldMaster();
}
