package project.swe763.programs;

/**
 * @author Rasaq
 * @OVerview: ViewFactory class for the service locator
 */

public class ViewFactory {

	private static IView _instance = new View();

	private ViewFactory() {
	}

	public static IView getInstance() {
		return _instance;
	}

	// Used to register mock or stub instances in place of
	// the concrete View class

	public static void registerInstance(IView instance) {
		_instance = instance;
	}
}
