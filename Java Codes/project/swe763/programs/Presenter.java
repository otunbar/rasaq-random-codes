package project.swe763.programs;

/**
 * @author Rasaq
 * @OVerview: This class has no IoC implemented i.e. null IoC
 */

public class Presenter {

	private Model _model;
	private View _view;
	private Service _service;

	public Object createView() {
		_model = new Model();
		_view = new View();
		_view.displayModel(_model);
		return _view;
	}

	public void save() {
		_service = new Service();
		_service.persist(_model);
	}
}