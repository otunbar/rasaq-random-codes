package project.swe763.programs;

/**
 * @author Rasaq
 * @OVerview: This class implements the constructor dependency injectionF
 */

public class Presenter_CDI {

	private IView _view;
	private IModel _model;
	private IService _service;

	public Presenter_CDI(IView view, IService service, IModel model) {
		_view = view;
		_service = service;
		_model = model;
	}

	public Object createView() {
		_view.displayModel(_model);
		return _view;
	}

	public void save() {
		_service.persist(_model);
	}
}