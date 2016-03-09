package mathtest.condition;

import core.condition.SourceResultCondition;

public class SourceConditionBounded implements SourceResultCondition  {

	Integer lower_limit, upper_limit;
	
	public SourceConditionBounded(Integer lower_limit, Integer upper_limit) {
		this.lower_limit = lower_limit;
		this.upper_limit = upper_limit;
	}

	public Integer getLower_limit() {
		return lower_limit;
	}

	public void setLower_limit(Integer lower_limit) {
		this.lower_limit = lower_limit;
	}

	public Integer getUpper_limit() {
		return upper_limit;
	}

	public void setUpper_limit(Integer upper_limit) {
		this.upper_limit = upper_limit;
	}
	
}
