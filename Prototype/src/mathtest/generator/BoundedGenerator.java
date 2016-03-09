package mathtest.generator;

import java.util.Random;

public class BoundedGenerator {
	private Integer current_lower, current_upper;

	public BoundedGenerator(Integer current_lower, Integer current_upper) {
		this.current_lower = current_lower;
		this.current_upper = current_upper;
	}

	public Integer getLower() {
		return current_lower;
	}

	public void setLower(Integer current_lower) {
		this.current_lower = current_lower;
	}

	public Integer getUpper() {
		return current_upper;
	}

	public void setUpper(Integer current_upper) {
		this.current_upper = current_upper;
	}

	public int generate() {
		Random random = new Random();
		
		//System.out.println("lower = " + current_lower + " upper = " + current_upper);
		
		if(current_lower > current_upper) throw new IllegalArgumentException();
		
		int value = Math.abs( ( random.nextInt() % ( current_upper - current_lower + 1 ) ) ) + current_lower;
		
		return value;
	}
}
