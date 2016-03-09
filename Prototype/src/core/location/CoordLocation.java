package core.location;

import java.awt.geom.Point2D;

public class CoordLocation implements Location {
	private Point2D.Double point;
	
	public CoordLocation(Point2D.Double point) {
		this.point = point;
	}
	
	public CoordLocation(double x, double y) {
		this.point = new Point2D.Double(x, y);
	}
	
	public Point2D.Double getPoint() {
		return point;
	}
	
	public double distance(Location l) {
		return l.getPoint().distance(point);
	}
	
	@Override
	public String toString() {
		return "[Coord (" + point.x + ", " + point.y + ")]";
	}
}
