package core.action;

public interface EvaluableAction extends Action {
	
	//private ActionEvaluator evaluator;

	/*public EvaluableAction() {
		evaluator = null;
	}*/
	
	/*public ActionEvaluator getEvaluator() {
		return evaluator;
	}

	public void setEvaluator(ActionEvaluator evaluator) {
		this.evaluator = evaluator;
	}

	public double getValue() {
		return evaluator.evaluate(this);
	}*/
	
	public ActionEvaluator getEvaluator();
	public void setEvaluator(ActionEvaluator evaluator);
	public double getValue();
}
