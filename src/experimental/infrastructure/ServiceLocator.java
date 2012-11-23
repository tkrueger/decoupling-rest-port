package experimental.infrastructure;

import java.util.HashMap;

/**
 * Well Known Interface used to hold services in a registry as a placeholder for
 * DI to come.
 * <p>
 * Will have to be initialized at startup through {@link #wire(Class, Object)},
 * for example through a ServlectContectListener.
 */
@SuppressWarnings("unchecked")
public class ServiceLocator {

	private static ServiceLocator instance = new ServiceLocator();

	private HashMap<Object, Object> serviceRegistry = new HashMap<Object, Object>();

	private ServiceLocator() {
	}

	public <C> C lookup(Class<C> type) {
		return (C) serviceRegistry.get(type);
	}

	public <C> C wire(Class<C> type, C instance) {
		return (C) serviceRegistry.put(type, instance);
	}

	public static ServiceLocator get() {
		return instance;
	}
	
	public void clear() {
		serviceRegistry.clear();
	}
}
