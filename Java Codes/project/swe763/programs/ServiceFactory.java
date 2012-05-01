package project.swe763.programs;

/**
 * @author Rasaq
 * @OVerview: ServiceFactory class for the service locator
 */
public class ServiceFactory {

	private static IService _instance = new Service();

	private ServiceFactory() {
	}

	public static IService getInstance() {
		return _instance;
	}

	// Used to register mock or stub instances in place of
	// the concrete Service class

	public static void registerInstance(IService instance) {
		_instance = instance;
	}
}
