package implementation.object;

import core.location.Location;

public class AppleTree implements GatherObject {
	
	public static final double gather_effort = 20;

	private Location location;
	
	public AppleTree(Location location) {
		setLocation(location);
	}
	
	@Override
	public Location getLocation() {
		return location;
	}

	@Override
	public void setLocation(Location location) {
		this.location = location;
	}

	@Override
	public Object gatherResult() {
		return new Apple(location);
	}

	@Override
	public double gatherEffort() {
		return gather_effort;
	}
	
	@Override
	public String toString() {
		return "[AppleTree]";
	}

}
