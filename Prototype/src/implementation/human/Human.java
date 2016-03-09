package implementation.human;

import implementation.source.GlobalActionSource;
import core.action.Action;
import core.actor.Actor;
import core.location.Location;
import core.source.BasicSource;
import core.source.SourceListener;
import core.world.WorldMaster;

public class Human implements Actor, SourceListener {

	private Location location;
	private WorldMaster master;
	
	/* Current action must be thread safe */
	private volatile Action current_action;
	private volatile Object current_action_lock;
	
	private GlobalActionSource source;
	private String name;

	public Human(WorldMaster master, Location location, String name) {
		setWorldMaster(master);
		setLocation(location);
		source = new GlobalActionSource(this);
		this.name = name;
		current_action = null;
		current_action_lock = new Object();
	}
	
	public Human(WorldMaster master, Location location) {
		setWorldMaster(master);
		setLocation(location);
		source = new GlobalActionSource(this);
		name = "Bob";
		current_action = null;
		current_action_lock = new Object();
	}
	
	@Override
	public Location getLocation() {
		return location;
	}

	@Override
	public void setLocation(Location location) {
		this.location = location;
	}

	@Override
	public void run() {
		synchronized(current_action_lock) {
			if( current_action == null ) return;
			// exécuter action
		}
	}

	@Override
	public void setWorldMaster(WorldMaster master) {
		this.master = master;
	}
	
	public WorldMaster getWorldMaster() {
		return master;
	}
	
	public Action getAction() {
		return current_action;
	}

	@Override
	public void onNewObject(BasicSource origin) {
		synchronized(current_action_lock) {
			current_action = source.getResult();
		}
	}

	@Override
	public void onDeletedObject(BasicSource origin, Object action) {
		synchronized(current_action_lock) {
			if(current_action == action)
				current_action = null;
		}
	}
	
	@Override
	public String toString() {
		return "[" + name + " (Human)]";
	}

}
