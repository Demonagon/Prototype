package implementation.world.indexers;

import implementation.world.listeners.ObjectRemovalAnalyst;
import implementation.world.listeners.ObjectSpawnAnalyst;

import java.util.LinkedList;
import java.util.List;

public class ObjectIndexer<T> implements Indexer<T>, ObjectRemovalAnalyst, ObjectSpawnAnalyst {

	private List< SpawnListener<T> > listeners;
	
	private List<T> objects;
	
	private Class<T> type;
	
	public ObjectIndexer(Class<T> type) {
		listeners = new LinkedList<SpawnListener<T> >();
		objects = new LinkedList<T>();
		this.type = type;
	}
	
	@Override
	public void onSpawn(Object entity) {
		if( type.isInstance(entity) ) {
			objects.add( type.cast(entity) );
			for(SpawnListener<T> l : listeners)
				l.onSpawn(type.cast(entity));
		}
	}

	@Override
	public void onRemoval(Object entity) {
		if( type.isInstance(entity) ) {
			objects.remove( type.cast(entity) );
			for(SpawnListener<T> l : listeners)
				l.onRemoval(type.cast(entity));
		}
	}

	public void addListener(SpawnListener<T> l) {
		listeners.add(l);
	}
	
	public void removeListener(SpawnListener<T> l) {
		listeners.remove(l);
	}
	
	@Override
	public List<T> getList() {
		return objects;
	}
	
	public interface SpawnListener<T> {
		public void onSpawn(T object);
		public void onRemoval(T object);
	}

}
