package core.source;


public abstract class ChainedSource<T> implements Source<T> {
	private SourceListener listener;
	
	public void setSourceListener(SourceListener l) {
		listener = l;
	}
	
	public void notifyNewObject() {
		listener.onNewObject(this);
	}
	
	public void notifyDeletedObject(T object) {
		listener.onDeletedObject(this, object);
	}
}
