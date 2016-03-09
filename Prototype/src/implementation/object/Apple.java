package implementation.object;

import core.location.Location;

public class Apple implements EatableObject {
	
	public static final double apple_nutrition = 20;
	
	private Location location;
	private String name;
	
	public Apple(Location location) {
		this.location = location;
		this.name = "";
	}
	
	public Apple(Location location, String name) {
		this.location = location;
		this.name = name;
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
	public double getNutritionValue() {
		return apple_nutrition;
	}
	
	@Override
	public String toString() {
		if( name.equals("") ) return "[Apple]";
		else return "[Apple \"" + name + "\"]";
	}

}
