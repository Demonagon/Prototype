package mathtest.action;

import core.location.Location;

public class MultiplicationAction implements MathAction {
	private Integer a, b, c, objective;

	public MultiplicationAction(Integer a, Integer b, Integer c, Integer objective) {
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
		return new Integer(a * b * c);
	}

	@Override
	public double getSatisfaction() {
		return Math.abs( (a * b * c) - objective );
	}
}
