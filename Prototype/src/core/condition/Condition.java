package core.condition;

public interface Condition<T> {
	public boolean isChecked(T object);
}
