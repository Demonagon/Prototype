package core.object;

import core.location.Location;

public interface LocatedObject {
	Location getLocation();
	void setLocation(Location location);
}
