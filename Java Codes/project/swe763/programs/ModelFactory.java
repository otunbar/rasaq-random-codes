package project.swe763.programs;

/**
 * @author Rasaq
 * @OVerview: ModelFactory class for the service locator
 */

public class ModelFactory {
	private static IModel _instance = new Model();

	private ModelFactory() {
	}

	public static IModel getInstance() {
		return _instance;
	}

	// Used to register mock or stub instances in place of
	// the concrete Model class

	public static void registerInstance(IModel instance) {
		_instance = instance;
	}
}
