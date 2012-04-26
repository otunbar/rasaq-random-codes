package weka.core;

/*
 *    This program is free software; you can redistribute it and/or modify
 *    it under the terms of the GNU General Public License as published by
 *    the Free Software Foundation; either version 2 of the License, or
 *    (at your option) any later version.
 *
 *    This program is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *    GNU General Public License for more details.
 *
 *    You should have received a copy of the GNU General Public License
 *    along with this program; if not, write to the Free Software
 *    Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
 */

/*
 *    SLOCDistance.java
 *    Copyright (C) Rasaq Otunba
 *
 */

import weka.core.TechnicalInformation.Field;
import weka.core.TechnicalInformation.Type;
import weka.core.neighboursearch.PerformanceStats;

/**
 * <!-- globalinfo-start --> Implements the Spherical law of cosines distance.<br/>
 * <br/>
 * For more information, see:<br/>
 * <br/>
 * http://www.movable-type.co.uk/scripts/latlong.html
 * <p/>
 * <!-- globalinfo-end -->
 * 
 * 
 * <!-- options-start --> Valid options are:
 * <p/>
 * 
 * <pre>
 * -D
 *  Turns off the normalization of attribute 
 *  values in distance calculation.
 * </pre>
 * 
 * <pre>
 * -R &lt;col1,col2-col4,...&gt;
 *  Specifies list of columns to used in the calculation of the 
 *  distance. 'first' and 'last' are valid indices.
 *  (default: first-last)
 * </pre>
 * 
 * <pre>
 * -V
 *  Invert matching sense of column indices.
 * </pre>
 * 
 * <!-- options-end -->
 * 
 * @author Rasaq Otunba (rasaq.otunba@gmail.com)
 * @version 1.0
 */
public class SLOCDistance extends NormalizableDistance implements
		TechnicalInformationHandler {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** for serialization. */

	/**
	 * Constructs a SLOCDistance object, Instances must be still set.
	 */
	public SLOCDistance() {
		super();
	}

	/**
	 * Constructs a SLOCDistance object and automatically initializes the
	 * ranges.
	 * 
	 * @param data
	 *            the instances the distance function should work on
	 */
	public SLOCDistance(Instances data) {
		super(data);
	}

	/**
	 * Returns a string describing this object.
	 * 
	 * @return a description of the evaluator suitable for displaying in the
	 *         explorer/experimenter gui
	 */
	public String globalInfo() {
		return "Implements the spherical law of cosines distance. \n\n"
				+ "For more information, see:\n\n"
				+ getTechnicalInformation().toString();
	}

	/**
	 * Returns an instance of a TechnicalInformation object, containing detailed
	 * information about the technical background of this class, e.g., paper
	 * reference or book this class is based on.
	 * 
	 * @return the technical information about this class
	 */
	public TechnicalInformation getTechnicalInformation() {
		TechnicalInformation result;

		result = new TechnicalInformation(Type.MISC);
		result.setValue(Field.AUTHOR, "Movable Type Scripts");
		result.setValue(Field.TITLE,
				"Calculate distance, bearing and more between Latitude/Longitude points");
		result.setValue(Field.URL,
				"http://www.movable-type.co.uk/scripts/latlong.html");

		return result;
	}

	/**
	 * Calculates the distance between two instances.
	 * 
	 * @param first
	 *            the first instance
	 * @param second
	 *            the second instance
	 * @return the distance between the two given instances
	 */
	public double distance(Instance first, Instance second) {

		return distance(first, second, Double.POSITIVE_INFINITY, null);

	}

	/**
	 * Calculates geodetic distance between two points specified by
	 * latitude/longitude using Spherical Law of Cosines
	 * 
	 * @param lat1
	 *            first point latitude in decimal degrees
	 * @param lon1
	 *            first point longitude in decimal degrees
	 * @param lat2
	 *            second point latitude in decimal degrees
	 * @param lon2
	 *            second point longitude in decimal degrees
	 * 
	 * @returns distance in Km between points
	 * 
	 * @see http://www.movable-type.co.uk/scripts/latlong-vincenty.html
	 */
	private static double spherLawOfCos(double lat1, double lon1, double lat2,
			double lon2) {
		final double R = 6371.0; // earths mean radius in km

		// convert coordinates to radians
		lat1 = Math.toRadians(lat1);
		lon1 = Math.toRadians(lon1);
		lat2 = Math.toRadians(lat2);
		lon2 = Math.toRadians(lon2);

		return (R * (Math.acos((Math.sin(lat1) * Math.sin(lat2))
				+ (Math.cos(lat1) * Math.cos(lat2) * Math.cos(lon2 - lon1)))));
	}

	/**
	 * Calculates the distance (or similarity) between two instances. Need to
	 * pass this returned distance later on to postprocess method to set it on
	 * correct scale. <br/>
	 * P.S.: Please don't mix the use of this function with distance(Instance
	 * first, Instance second), as that already does post processing. Please
	 * consider passing Double.POSITIVE_INFINITY as the cutOffValue to this
	 * function and then later on do the post processing on all the distances.
	 * 
	 * @param first
	 *            the first instance
	 * @param second
	 *            the second instance
	 * @param stats
	 *            the structure for storing performance statistics.
	 * @return the distance between the two given instances or
	 *         Double.POSITIVE_INFINITY.
	 */
	public double distance(Instance first, Instance second,
			PerformanceStats stats) { // debug method pls remove after use
		return distance(first, second, Double.POSITIVE_INFINITY, stats);

	}

	public double distance(Instance first, Instance second, double limit,
			PerformanceStats stats) { // debug method pls remove after use
		
            /*Dataset needs to have only three attributes, 
	      three attributes (latitude, longitude, cityandstate) e.g.
	      “38.846212”, “-77.32787”, “Fairfax,VA” */
		double paramOne = first.value(0); //get latitude of the first instance
		double paramTwo = first.value(1); //get longitude of the first instance
		double paramThree = second.value(0); //get latitude of the second instance
		double paramFour = second.value(1); //get longitude of the second instance

		return spherLawOfCos(paramOne, paramTwo, paramThree, paramFour);

	}

	/**
	 * Updates the current distance calculated so far with the new difference
	 * between two attributes. The difference between the attributes was
	 * calculated with the difference(int,double,double) method.
	 * 
	 * @param currDist
	 *            the current distance calculated so far
	 * @param diff
	 *            the difference between two new attributes
	 * @return the update distance
	 * @see #difference(int, double, double)
	 */
	protected double updateDistance(double currDist, double diff) {

		return 0;
	}

	/**
	 * Returns the radian difference of two values of an attribute.
	 * 
	 * @param index
	 *            the attribute index
	 * @param val1
	 *            the first value
	 * @param val2
	 *            the second value
	 * @return the radian difference
	 */
	public double sqDifference(int index, double val1, double val2) {
		double val = difference(index, val1, val2);
		return Math.toRadians(val);
	}

	/**
	 * Returns value in the middle of the two parameter values.
	 * 
	 * @param ranges
	 *            the ranges to this dimension
	 * @return the middle value
	 */
	public double getMiddle(double[] ranges) {

		double middle = ranges[R_MIN] + ranges[R_WIDTH] * 0.5;
		return middle;
	}

	/**
	 * Returns the index of the closest point to the current instance. Index is
	 * index in Instances object that is the second parameter.
	 * 
	 * @param instance
	 *            the instance to assign a cluster to
	 * @param allPoints
	 *            all points
	 * @param pointList
	 *            the list of points
	 * @return the index of the closest point
	 * @throws Exception
	 *             if something goes wrong
	 */
	public int closestPoint(Instance instance, Instances allPoints,
			int[] pointList) throws Exception {
		double minDist = Integer.MAX_VALUE;
		int bestPoint = 0;
		for (int i = 0; i < pointList.length; i++) {
			double dist = distance(instance, allPoints.instance(pointList[i]),
					Double.POSITIVE_INFINITY);
			if (dist < minDist) {
				minDist = dist;
				bestPoint = i;
			}
		}
		return pointList[bestPoint];
	}

	/**
	 * Returns true if the value of the given dimension is smaller or equal the
	 * value to be compared with.
	 * 
	 * @param instance
	 *            the instance where the value should be taken of
	 * @param dim
	 *            the dimension of the value
	 * @param value
	 *            the value to compare with
	 * @return true if value of instance is smaller or equal value
	 */
	public boolean valueIsSmallerEqual(Instance instance, int dim, double value) { // This
																					// stays
		return instance.value(dim) <= value;
	}

	/**
	 * Returns the revision string.
	 * 
	 * @return the revision
	 */
	public String getRevision() {
		return RevisionUtils.extract("$Revision: 5953 $");
	}
}


