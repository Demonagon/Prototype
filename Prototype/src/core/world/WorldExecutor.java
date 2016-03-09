package core.world;

public interface WorldExecutor {
	public void addTask(Runnable runnable);
	public void stop();
}
