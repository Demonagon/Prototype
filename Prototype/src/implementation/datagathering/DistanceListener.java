package implementation.datagathering;

import core.object.LocatedObject;

public interface DistanceListener {
	public double getRange();
	public void notifyDistance(LocatedObject object);
}
