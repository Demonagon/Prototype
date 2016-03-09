package implementation.world;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import core.world.WorldExecutor;

public class SimpleWorldExecutor implements WorldExecutor {
	private ExecutorService executor;
	
	public SimpleWorldExecutor() {
		executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
	}

	@Override
	public void addTask(Runnable runnable) {
		executor.submit(runnable);
	}
	
	@Override
	public void stop() {
		executor.shutdown();
	}
}
