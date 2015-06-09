/*
 *    CFCluster.java
 *    Copyright (C) 2010 RWTH Aachen University, Germany
 *    @author Jansen (moa@cs.rwth-aachen.de)
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

package edu.streaming.cluster;
import java.util.Arrays;
import weka.core.Instance;

public abstract class CFCluster extends SphereCluster {

	private static final long serialVersionUID = 1L;

	protected double radiusFactor = 1.8;

	/**
	 * Number of points in the cluster.
	 */
	protected double N;
	/**
	 * Linear sum of all the points added to the cluster.
	 */
	public double[] LS;
	/**
	 * Squared sum of all the points added to the cluster.
	 */
	public double[] SS;

	/**
	 * Instantiates an empty kernel with the given dimensionality.
	 * @param dimensions The number of dimensions of the points that can be in
	 * this kernel.
	 */
	public CFCluster(Instance instance, int dimensions) {
		this(instance.toDoubleArray(), dimensions);
	}

	protected CFCluster(int dimensions) {
		this.N = 0;
		this.LS = new double[dimensions];
		this.SS = new double[dimensions];
		Arrays.fill(this.LS, 0.0);
		Arrays.fill(this.SS, 0.0);
	}

	public CFCluster(double [] center, int dimensions) {
		this.N = 1;
		this.LS = center;
		this.SS = new double[dimensions];
		for (int i = 0; i < SS.length; i++) {
			SS[i]=Math.pow(center[i], 2);
		}
	}

	public CFCluster(CFCluster cluster) {
		this.N = cluster.N;
		this.LS = Arrays.copyOf(cluster.LS, cluster.LS.length);
		this.SS = Arrays.copyOf(cluster.SS, cluster.SS.length);
	}

	public void add(CFCluster cluster ) {
		this.N += cluster.N;
		addVectors( this.LS, cluster.LS );
		addVectors( this.SS, cluster.SS );
	}

	public abstract CFCluster getCF();

	/**
	 * @return this kernels' center
	 */
	 @Override
	 public double[] getCenter() {
		 assert (this.N>0);
		 double res[] = new double[this.LS.length];
		 for ( int i = 0; i < res.length; i++ ) {
			 res[i] = this.LS[i] / N;
		 }
		 return res;
	 }


	 @Override
	 public abstract double getInclusionProbability(Instance instance);

	 /**
	  * See interface <code>Cluster</code>
	  * @return The radius of the cluster.
	  */
	 @Override
	 public abstract double getRadius();

	 /**
	  * See interface <code>Cluster</code>
	  * @return The weight.
	  * @see Cluster#getWeight() 
	  */
	 @Override
	 public double getWeight() {
		 return N;
	 }

	 public void setN(double N){
		 this.N = N;
	 }

	 public double getN() {
		 return N;
	 }

	 /**
	  * Adds the second array to the first array element by element. The arrays
	  * must have the same length.
	  * @param a1 Vector to which the second vector is added.
	  * @param a2 Vector to be added. This vector does not change.
	  */
	 public static void addVectors(double[] a1, double[] a2) {
		 assert (a1 != null);
		 assert (a2 != null);
		 assert (a1.length == a2.length) : "Adding two arrays of different "
			 + "length";

		 for (int i = 0; i < a1.length; i++) {
			 a1[i] += a2[i];
		 }
	 }
}
