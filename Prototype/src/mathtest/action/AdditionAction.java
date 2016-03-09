package mathtest.action;

import core.location.Location;

public class AdditionAction implements MathAction {
	private Integer a, b, c, objective;

	public AdditionAction(Integer a, Integer b, Integer c, Integer objective) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.objective = objective;
	}
	
	@Override
	public Location getFinalPoint() {
		return null;
	}

	@Override
	public double getEffort() {
		return 0;
	}

	@Override
	public Object getResult() {
		return new Integer(a + b + c);
	}

	@Override
	public double getSatisfaction() {
		return Math.abs( (a + b + c) - objective );
	}
	
	@Override
	public String toString() {
		return "" + a + " + " + b + " + " + c + " = " + (a + b + c) + " (~" + Math.abs( a + b + c - objective ) + ")";
	}
}
