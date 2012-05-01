package project.swe763.programs;

/**
 * @author Rasaq 
 * @overview: interface for a Presenter class
 */

public interface IPresenter {

	/**
	 * Sets the View field of the implementing Presenter class to the IView
	 * parameter
	 * 
	 * @param value
	 */
	public void setView(IView value);

	/**
	 * Sets the Service field of the implementing Presenter class to the
	 * IService parameter
	 * 
	 * @param value
	 */

	public void setService(IService value);

	/**
	 * Sets the Model field of the implementing Presenter class to the IModel
	 * parameter
	 * 
	 * @param model
	 */
	public void setModel(IModel model);
}