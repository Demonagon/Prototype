package implementation.source.move;

import core.action.EvaluableAction;
import core.actor.Actor;
import core.condition.SourceResultCondition;
import core.location.Location;
import core.source.ChainedSource;

public class MoveActionSource extends ChainedSource<EvaluableAction> implements Runnable {
	
	private MoveActionFactory factory;
	private Actor actor;
	
	public MoveActionSource(Actor actor) {
		factory = new MoveActionFactory(null);
		this.actor = actor;
	}
	
	@Override
	public EvaluableAction getResult() {
		return factory.create();
	}

	@Override
	public void setCondition(SourceResultCondition condition) {
		if( !(condition instanceof MoveParameter) ) {
			System.out.println("Warning : MoveActionSource : unrecognized condition");
			return;
		}
		
		factory.setParameters((MoveParameter) condition);
		
		actor.getWorldMaster().getExecutor().addTask(this);
	}

	@Override
	public void run() {
		notifyNewObject();
	}
	
	public static class MoveParameter implements SourceResultCondition {
		private Location origin, destination;
		
		/**
		 * Ce sera une bonne idée de rajouter le paramètre du temps limite ;
		 * pour demander au corps de générer une action de mouvement assez
		 * rapide (ou la plus rapide possible, ou la plus rapide avec
		 * un certain compromis d'effort...).
		 * @param origin
		 * @param destination
		 */
		public MoveParameter(Location origin, Location destination) {
			this.origin = origin;
			this.destination = destination;
		}
		
		public Location getOrigin() {
			return origin;
		}
		
		public Location getDestination() {
			return destination;
		}
	}

}
