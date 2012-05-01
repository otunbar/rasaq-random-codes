package project.swe763.programs;

/**
 * @author Rasaq
 * @OVerview: Standard Presenter class with the service locator implemented
 */

public class Presenter_SL {

	private IView _view;
	private IModel _model;
	private IService _service;

	public Object createView(Model model) {
		_view = (IView) ViewFactory.getInstance();
		_service = (IService) ServiceFactory.getInstance();
		_view.displayModel(_model);
		return _view;
	}

	public void save() {
		_model = (IModel) ModelFactory.getInstance();
		_service.persist(_model);
	}
}
