package mathtest.main;

import core.source.Source;
import core.source.SourceListener;
import mathtest.action.AdditionAction;
import mathtest.source.AdditionSource;

public class Main implements SourceListener<AdditionAction> {
	public static void main(String[] args) {
		AdditionSource source = new AdditionSource(100);
		
		source.setSourceListener(new Main());
		
		while( ! source.isObjectiveMet() ) {
			source.getASource().run();
			source.getBSource().run();
			source.getCSource().run();
		}
	}

	@Override
	public void onNewObject(Source<AdditionAction> origin) {
		System.out.println("New best solution : " + origin.getResult());
	}

	@Override
	public void onDeletedObject(Source<AdditionAction> origin,
			AdditionAction object) {}
}
