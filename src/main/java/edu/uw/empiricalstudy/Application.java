package edu.uw.empiricalstudy;

import edu.uw.empiricalstudy.algorithms.KnapsackBottomUpDp;
import edu.uw.empiricalstudy.algorithms.KnapsackBruteForce;
import edu.uw.empiricalstudy.algorithms.KnapsackTopDownDp;
import edu.uw.empiricalstudy.common.Util;

/**
 * Application interface, input will be the arrays that was mentioend inside the
 * question pdf
 * 
 * @author Navid Heydari
 *
 */
public class Application {

	private static int _W;
	private static int[] values;
	private static int[] weights;

	public static void main(String[] args) {
		 
		regressionTestScenarioWithDataSize(100,100);
	}

	/**
	 * having the same date set size and running all of the algorithm with each
	 * set.
	 */
	public static void regressionTestScenarioWithDataSize(int iteration, int dataSetSize) {
		StringBuilder sb = new StringBuilder();
 
		sb.append("Data Set Size,DP buttomUp Time(NanoSec), Brute Force Time(NanoSec), DP Top Down Time(NanoSec),").append(System.lineSeparator());

		//regression
		for (int i = 0; i < iteration; i++) {

			_W = Util.randomIntGenerator();
			values = Util.randomIntArrayGenerator(dataSetSize);
			weights = Util.randomIntArrayGenerator(values.length);//same length

			// Dp buttom up
			long start = System.nanoTime();
			new KnapsackBottomUpDp(values, weights, _W);
			long finish = System.nanoTime();

			sb.append(values.length).append(",").append((finish - start)).append(",");

			// Brute force goes here
			start = System.nanoTime();
			new KnapsackBruteForce(values, weights, _W);
			finish = System.nanoTime();

			sb.append((finish - start)).append(",");

			// top down goes here.
			start = System.nanoTime();
			new KnapsackTopDownDp(values, weights, _W);
			finish = System.nanoTime();

			sb.append((finish - start)).append(",").append(System.lineSeparator());

		}
		
		// do the IO thing
		Util.saveCsvToFile(sb.toString(), "result.csv");
		System.out.println("Finished processing");

	}

}
