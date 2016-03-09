package mathtest.condition;

import core.condition.SourceResultCondition;

public class SourceConditionLessThan implements SourceResultCondition {
	Integer lower_limit;
	
	public SourceConditionLessThan(Integer lower_limit) {
		this.lower_limit = lower_limit;
	}
	
	public Integer getLimit() {
		return lower_limit;
	}
}
