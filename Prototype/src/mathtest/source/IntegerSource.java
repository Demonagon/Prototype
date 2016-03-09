package mathtest.source;

import mathtest.condition.SourceConditionBounded;
import mathtest.condition.SourceConditionGreaterThan;
import mathtest.condition.SourceConditionLessThan;
import mathtest.generator.BoundedGenerator;
import core.condition.SourceResultCondition;
import core.source.ChainedSource;

public class IntegerSource extends ChainedSource<Integer> implements Runnable {

	private Integer init_lower, init_upper;
	private Integer current_value;
	private BoundedGenerator generator;
	
	public IntegerSource(Integer lower, Integer upper) {
		init_lower = lower;
		init_upper = upper;
		current_value = lower;
		generator = new BoundedGenerator(lower, upper);
	}
	
	@Override
	public Integer getResult() {
		return current_value;
	}

	@Override
	public void setCondition(SourceResultCondition condition) {
		if( condition instanceof SourceConditionGreaterThan ) {
			SourceConditionGreaterThan c = (SourceConditionGreaterThan) condition;
			generator.setLower(c.getLimit());
			generator.setUpper(init_upper);
		}
		else if( condition instanceof SourceConditionLessThan ) {
			SourceConditionLessThan c = (SourceConditionLessThan) condition;
			generator.setLower(init_lower);
			generator.setUpper(c.getLimit());
		}
		else if( condition instanceof SourceConditionBounded ) {
			SourceConditionBounded c = (SourceConditionBounded) condition;
			generator.setLower(c.getLower_limit());
			generator.setUpper(c.getUpper_limit());
		}
	}

	@Override
	public void run() {
		current_value = generator.generate();
		notifyNewObject();
	}
	
}
