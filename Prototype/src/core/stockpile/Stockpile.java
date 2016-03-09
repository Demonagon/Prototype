package core.stockpile;

public interface Stockpile<T> {
	public void save(T object);
	public void dismiss(T object);
	public T load();
}
