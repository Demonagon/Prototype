package core.source;

public interface SourceListener {
	public void onNewObject(BasicSource source);
	public void onDeletedObject(BasicSource source, Object object);
}
