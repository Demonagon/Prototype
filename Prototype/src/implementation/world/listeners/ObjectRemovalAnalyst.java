package implementation.world.listeners;

import core.world.WorldAnalyst;

public interface ObjectRemovalAnalyst extends WorldAnalyst {
	public void onRemoval(Object entity);
}
