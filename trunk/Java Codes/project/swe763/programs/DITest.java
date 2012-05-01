package project.swe763.programs;

import java.lang.reflect.Field;

/**
 * @author Rasaq 
 * @overview: This class has the tests to satisfy mutation coverage
 *         of all classes in this package
 */
public class DITest {

	/**
	 * @return: true if instance obj created is null else false
	 */
	public String testJID_1_ModelFactory() {
		String result = "false";
		IModel obj = ModelFactory.getInstance();
		if (obj != null)
			result = result + obj.getClass().getName();
		return result;
	}

	/**
	 * @return: true if instance obj created is null else false
	 */
	public String testJID_1_ServiceFactory() {
		String result = "false";
		IService obj = ServiceFactory.getInstance();
		// result is set to true if obj is null else false
		if (obj != null)
			result = result + obj.getClass().getName();
		return result;
	}

	/**
	 * @return: true if instance obj created is null else false
	 */
	public String testJID_1_ViewFactory() {
		String result = "false";
		IView obj = ViewFactory.getInstance();
		// result is set to true if obj is null else false
		if (obj != null)
			result = result + obj.getClass().getName();
		return result;
	}

	/**
	 * @return: the string "has a static field" if instance obj has a static
	 *          field else return empty string
	 */
	public String testJSI_Presenter() {
		Presenter obj = new Presenter();
		String result = "";
		Field[] declaredFields = obj.getClass().getDeclaredFields();
		for (Field field : declaredFields) {
			if (java.lang.reflect.Modifier.isStatic(field.getModifiers())) {
				result = "has a static field";
				break;
			}
		}

		return result;
	}

	/**
	 * @return: the string "has a static field" if instance obj has a static
	 *          field else return empty string
	 */
	public String testJSI_Presenter_CDI() {
		Presenter_CDI obj = new Presenter_CDI(new View(), new Service(),
				new Model());
		String result = "";
		Field[] declaredFields = obj.getClass().getDeclaredFields();
		for (Field field : declaredFields) {
			if (java.lang.reflect.Modifier.isStatic(field.getModifiers())) {
				result = "has a static field";
				break;
			}
		}
		return result;
	}

	/**
	 * @return: the string "has a static field" if instance obj has a static
	 *          field else return empty string
	 */
	public String testJSI_Presenter_IDI() {
		Presenter_IDI obj = new Presenter_IDI();
		String result = "";
		Field[] declaredFields = obj.getClass().getDeclaredFields();
		for (Field field : declaredFields) {
			if (java.lang.reflect.Modifier.isStatic(field.getModifiers())) {
				result = "has a static field";
				break;
			}
		}
		return result;
	}

	/**
	 * @return: the string "has a static field" if instance obj has a static
	 *          field else return empty string
	 */
	public String testJSI_Presenter_SDI() {
		Presenter_SDI obj = new Presenter_SDI();
		String result = "";
		Field[] declaredFields = obj.getClass().getDeclaredFields();
		for (Field field : declaredFields) {
			if (java.lang.reflect.Modifier.isStatic(field.getModifiers())) {
				result = "has a static field";
				break;
			}
		}
		return result;
	}

	/**
	 * @return: the string "has a static field" if instance obj has a static
	 *          field else return empty string
	 */
	public String testJSI_Presenter_SL() {
		Presenter_SL obj = new Presenter_SL();
		String result = "";
		Field[] declaredFields = obj.getClass().getDeclaredFields();
		for (Field field : declaredFields) {
			if (java.lang.reflect.Modifier.isStatic(field.getModifiers())) {
				result = "has a static field";
				break;
			}
		}
		return result;
	}
}
