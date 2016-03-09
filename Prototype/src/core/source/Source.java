package core.source;

import core.condition.SourceResultCondition;

public interface Source <T> extends BasicSource {
	public T getResult();
	public void setCondition(SourceResultCondition condition);
}
