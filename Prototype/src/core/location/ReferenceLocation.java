package core.location;

import java.awt.geom.Point2D.Double;

import core.object.LocatedObject;

public class ReferenceLocation implements Location {
	
	private LocatedObject object;
	
	ReferenceLocation(LocatedObject object) {
		this.object = object;
	}

	@Override
	public Double getPoint() {
		return object.getLocation().getPoint();
	}

	@Override
	public double distance(Location l) {
		return object.getLocation().distance(l);
	}
}
