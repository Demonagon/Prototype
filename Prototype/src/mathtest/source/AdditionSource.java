package mathtest.source;

import mathtest.action.AdditionAction;
import mathtest.condition.SourceConditionBounded;
import mathtest.condition.SourceConditionLessThan;
import core.condition.SourceResultCondition;
import core.source.ChainedSource;
import core.source.Source;
import core.source.SourceListener;

public class AdditionSource extends ChainedSource<AdditionAction> implements SourceListener<Integer> {
	
	IntegerSource a_source, b_source, c_source;
	Integer a, b, c;
	
	Integer objective;
	
	public AdditionSource(Integer objective) {
		this.objective = objective;
		this.a = null;
		this.b = null;
		this.c = null;
		this.a_source = new IntegerSource(0, objective);
		this.b_source = new IntegerSource(0, objective);
		this.c_source = new IntegerSource(0, objective);
		this.a_source.setSourceListener(this);
		this.b_source.setSourceListener(this);
		this.c_source.setSourceListener(this);
	}

	@Override
	public AdditionAction getResult() {
		if( a == null || b == null || c == null ) return null;
		
		return new AdditionAction(a, b, c, objective);
	}

	@Override
	public void setCondition(SourceResultCondition condition) {
		
	}
	
	public boolean isObjectiveMet() {
		if (a == null || b == null || c == null) return false;
		return (a + b + c) == objective;
	}
	
	public boolean isOverObjective() {
		return (a + b + c) > objective;
	}
	
	public boolean isUnderObjective() {
		return (a + b + c) < objective;
	}

	@Override
	public void onNewObject(Source<Integer> origin) {
		if( isObjectiveMet() ) return;
		
		if		( origin == a_source ) update_a();
		else if	( origin == b_source ) update_b();
		else if	( origin == c_source ) update_c();
		
		reconfigure_sources();
	}
	
	public int getValue(int a, int b, int c) {
		return Math.abs( (a + b + c) - objective );
	}
	
	public void reconfigure_sources() {
		if (a == null || b == null || c == null) return;
		
		if( isUnderObjective() ) {
			//a_source.setCondition(new SourceConditionGreaterThan(a));
			a_source.setCondition(new SourceConditionBounded(a, objective - (b + c)));
			//b_source.setCondition(new SourceConditionGreaterThan(b));
			b_source.setCondition(new SourceConditionBounded(b, objective - (a + c)));
			//c_source.setCondition(new SourceConditionGreaterThan(c));
			c_source.setCondition(new SourceConditionBounded(c, objective - (a + b)));
		}
		if( isOverObjective() ) {
			a_source.setCondition(new SourceConditionLessThan(a));
			//a_source.setCondition(new SourceConditionBounded(Math.max( (b + c) - objective, 0), a));
			b_source.setCondition(new SourceConditionLessThan(b));
			//b_source.setCondition(new SourceConditionBounded(Math.max( (a + c) - objective, 0), b));
			c_source.setCondition(new SourceConditionLessThan(c));
			//c_source.setCondition(new SourceConditionBounded(Math.max( (a + b) - objective, 0), c));
		}
	}
	
	public void update_a() {
		a = a_source.getResult();
		notifyNewObject();
	}
	
	public void update_b() {
		b = b_source.getResult();
		notifyNewObject();
	}
	
	public void update_c() {
		c = c_source.getResult();
		notifyNewObject();
	}
	
	public IntegerSource getASource() {
		return a_source;
	}
	
	public IntegerSource getBSource() {
		return b_source;
	}
	
	public IntegerSource getCSource() {
		return c_source;
	}

	@Override
	public void onDeletedObject(Source<Integer> origin, Integer object) {}

}
