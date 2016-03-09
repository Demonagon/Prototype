package core.location;

import java.awt.geom.Point2D;

public interface Location {
	
	public Point2D.Double getPoint();
	
	public double distance(Location l);
	
	public static boolean isInSquareAround(Location l, Location l_center, double size) {
		return 	! isLeftToSquare(l, l_center, size) &&
				! isRightToSquare(l, l_center, size) &&
				! isOverSquare(l, l_center, size) &&
				! isUnderSquare(l, l_center, size);
	}
	
	public static boolean isLeftToSquare(Location l, Location l_center, double size) {
		Point2D.Double point = l.getPoint();
		Point2D.Double center = l_center.getPoint();
		return point.getX() < center.getX() - size/2;
	}
	
	public static boolean isRightToSquare(Location l, Location l_center, double size) {
		Point2D.Double point = l.getPoint();
		Point2D.Double center = l_center.getPoint();
		return point.getX() > center.getX() + size/2;
	}
	
	public static boolean isOverSquare(Location l, Location l_center, double size) {
		Point2D.Double point = l.getPoint();
		Point2D.Double center = l_center.getPoint();
		return point.getY() < center.getY() - size/2;
	}
	
	public static boolean isUnderSquare(Location l, Location l_center, double size) {
		Point2D.Double point = l.getPoint();
		Point2D.Double center = l_center.getPoint();
		return point.getY() > center.getY() + size/2;
	}
}
