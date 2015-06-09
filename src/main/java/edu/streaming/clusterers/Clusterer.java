/*
 *    Clusterer.java
 *    Copyright (C) 2009 University of Waikato, Hamilton, New Zealand
 *    @author Albert Bifet (abifet@cs.waikato.ac.nz)
 *
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
package edu.streaming.clusterers;

import edu.streaming.MOAObject;
import edu.streaming.cluster.Clustering;
import edu.streaming.core.InstancesHeader;
import edu.streaming.core.Measurement;
import edu.streaming.gui.AWTRenderable;
import edu.streaming.options.OptionHandler;
import weka.core.Instance;

public interface Clusterer extends MOAObject, OptionHandler, AWTRenderable {

	public void setModelContext(InstancesHeader ih);

	public InstancesHeader getModelContext();

	public boolean isRandomizable();

	public void setRandomSeed(int s);

	public boolean trainingHasStarted();

	public double trainingWeightSeenByModel();

	public void resetLearning();

	public void trainOnInstance(Instance inst);

	public double[] getVotesForInstance(Instance inst);

	public Measurement[] getModelMeasurements();

	public Clusterer[] getSubClusterers();

	public Clusterer copy();

    public Clustering getClusteringResult();

    public boolean implementsMicroClusterer();

    public Clustering getMicroClusteringResult();
    
    public boolean keepClassLabel();

}
