/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.streaming.clusterers;

import edu.streaming.cluster.Clustering;
import edu.streaming.core.Measurement;
import weka.core.Instance;

/**
 *
 * @author jansen
 */
public class DStream extends AbstractClusterer {

    @Override
    public void resetLearningImpl() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void trainOnInstanceImpl(Instance inst) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected Measurement[] getModelMeasurementsImpl() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void getModelDescription(StringBuilder out, int indent) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean isRandomizable() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public double[] getVotesForInstance(Instance inst) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Clustering getClusteringResult() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
