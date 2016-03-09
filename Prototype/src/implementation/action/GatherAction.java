package implementation.action;

import core.action.Action;
import core.location.Location;
import implementation.object.GatherObject;

public class GatherAction implements Action {
	
	private GatherObject gathering_point;

	public GatherAction(GatherObject gathering_point) {
		this.gathering_point = gathering_point;
	}
	
	@Override
	public Location getFinalPoint() {
		return gathering_point.getLocation();
	}

	@Override
	public double getEffort() {
		return gathering_point.gatherEffort();
	}

	@Override
	public Object getResult() {
		return gathering_point.gatherResult();
	}
	
	@Override
	public String toString() {
		return "{Gather " + gathering_point.gatherResult() + " from " + gathering_point + "}";
	}

}
