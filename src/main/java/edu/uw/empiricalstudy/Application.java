package edu.uw.empiricalstudy;

import javax.swing.JOptionPane;

import edu.uw.empiricalstudy.algorithms.KnapsackBottomUpDp;
import edu.uw.empiricalstudy.algorithms.KnapsackBruteForce;
import edu.uw.empiricalstudy.algorithms.KnapsackTopDownDp;
import edu.uw.empiricalstudy.common.Util;

/**
 * Application interface, input will be the arrays that was mentioend inside the
 * question pdf
 * 
 * @author Navid Heydari
 * @author Srivatsan
 *
 */
public class Application {

	private static int _W;
	private static int[] values;
	private static int[] weights;

	public static void main(String[] args) {
		try {
			int iteration = Integer.valueOf(args[0]);
			int dataSetSize = Integer.valueOf(args[1]);
			int testScenario = Integer.valueOf(args[2]);
			switch (testScenario) {
			case 1:
				// same N differnet W
				testRegressionAllAlgorithmsDifferentDataSetInEachIteration(iteration, dataSetSize);
				break;
			case 2:
				//same N and same W
				testRegressionDP_SameNSameW(iteration, dataSetSize);
				break;
			case 3:
				// same N and W for all iterations.
				testRegressionAllAlgorithmsSameDataSetInAllIteration(iteration, dataSetSize);
				break;
			case 4:
				// same n and different W  
				testRegressionDP_SameNDifferentW(iteration, dataSetSize);
				break;

			default:
				System.out.println(
						"<testScenarios> are like: \n\t1=testRegressionAllAlgorithmsDifferentDataSetInEachIteration\n\t2=Dynamic Programming same n and same W\n\t3=testRegressionAllAlgorithmsSameDataSetInAllIteration\n\t4=Testing Dynamic Programming same N differnet W");
				break;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"Input will be translated like this \n <Iteration> <dataSetSize> <testScenarios> are like: \n\t1=testRegressionAllAlgorithmsDifferentDataSetInEachIteration\n\t2=Dynamic Programming same n and same W\n\t3=testRegressionAllAlgorithmsSameDataSetInAllIteration\n\t4=Testing Dynamic Programming same N differnet W");
			System.out.println(
					"Input will be translated like this \n <Iteration> <dataSetSize> <testScenarios> are like: \n\t1=testRegressionAllAlgorithmsDifferentDataSetInEachIteration\n\t2=Dynamic Programming same n and same W\n\t3=testRegressionAllAlgorithmsSameDataSetInAllIteration\n\t4=Testing Dynamic Programming same N differnet W");
		}

	}

	/**
	 * having the same date set size and running all of the algorithm with each
	 * set. in each iteration/regression, executing with the same n but
	 * differnet W
	 */
	public static void testRegressionAllAlgorithmsDifferentDataSetInEachIteration(int iteration, int dataSetSize) {
		StringBuilder sb = new StringBuilder();

		sb.append(
				"Data Set Size,Capacity, Brute Force Time(NanoSec),DP buttomUp Time(NanoSec), DP Top Down Time(NanoSec),")
				.append(System.lineSeparator());

		// regression
		for (int i = 0; i < iteration; i++) {

			_W = Util.randomIntGenerator();
			values = Util.randomIntArrayGenerator(dataSetSize);
			weights = Util.randomIntArrayGenerator(values.length);// same length

			sb.append(dataSetSize).append(",").append(_W).append(",");
			// Brute force goes here
			long start = System.nanoTime();
			new KnapsackBruteForce(values, weights, _W);
			long finish = System.nanoTime();
			System.out.println("bruteforce finished");

			sb.append((finish - start)).append(",");

			// DP buttom up goes here
			start = System.nanoTime();
			new KnapsackBottomUpDp(values, weights, _W);
			finish = System.nanoTime();
			System.out.println("dp buttom up finished");

			sb.append((finish - start)).append(",");

			// DP top down goes here.
			start = System.nanoTime();
			new KnapsackTopDownDp(values, weights, _W);
			finish = System.nanoTime();
			System.out.println("dp top down finished");
			sb.append((finish - start)).append(",").append(System.lineSeparator());

		}

		// finished now do the IO thing
		Util.saveCsvToFile(sb.toString(), "testRegressionAllAlgorithmsDifferentDataSetInEachIteration.csv");
		System.out.println("Finished processing");

	}

	/**
	 * testing in regression mode for 2 dynamic programming using the same data
	 * set and capacity to make sure it decrease the effect of cold and warm in
	 * memory.
	 * 
	 * the same n and same W
	 * 
	 * @param iteration
	 * @param dataSetSize
	 */
	public static void testRegressionDP_SameNSameW(int iteration, int dataSetSize) {

		StringBuilder sb = new StringBuilder();

		sb.append("Data Set Size, Capacity, DP buttomUp Time(NanoSec), DP Top Down Time(NanoSec),")
				.append(System.lineSeparator());

		_W = Util.randomIntGenerator();
		values = Util.randomIntArrayGenerator(dataSetSize);
		weights = Util.randomIntArrayGenerator(values.length);// same length

		// regression
		for (int i = 0; i < iteration; i++) {

			sb.append(dataSetSize).append(",").append(_W).append(",");
			// DP buttom up goes here
			long start = System.nanoTime();
			new KnapsackBottomUpDp(values, weights, _W);
			long finish = System.nanoTime();
			System.out.println("dp buttom up finished");

			sb.append((finish - start)).append(",");

			// DP top down goes here.
			start = System.nanoTime();
			new KnapsackTopDownDp(values, weights, _W);
			finish = System.nanoTime();
			System.out.println("dp top down finished");
			sb.append((finish - start)).append(",").append(System.lineSeparator());

		}

		// finished now do the IO thing
		Util.saveCsvToFile(sb.toString(), "testResultDP_sameNSameW.csv");
		System.out.println("Finished processing");

	}

	/***
	 * same N and different W for each iteration.
	 * 
	 * @param iteration
	 * @param dataSetSize
	 */
	public static void testRegressionDP_SameNDifferentW(int iteration, int dataSetSize) {

		StringBuilder sb = new StringBuilder();

		sb.append("Data Set Size, Capacity, DP buttomUp Time(NanoSec), DP Top Down Time(NanoSec),")
				.append(System.lineSeparator());

		// regression
		for (int i = 0; i < iteration; i++) {

			_W = Util.randomIntGenerator();
			values = Util.randomIntArrayGenerator(dataSetSize);
			weights = Util.randomIntArrayGenerator(values.length);// same length

			sb.append(dataSetSize).append(",").append(_W).append(",");
			// DP buttom up goes here
			long start = System.nanoTime();
			new KnapsackBottomUpDp(values, weights, _W);
			long finish = System.nanoTime();
			System.out.println("dp buttom up finished");

			sb.append((finish - start)).append(",");

			// DP top down goes here.
			start = System.nanoTime();
			new KnapsackTopDownDp(values, weights, _W);
			finish = System.nanoTime();
			System.out.println("dp top down finished");
			sb.append((finish - start)).append(",").append(System.lineSeparator());

		}

		// finished now do the IO thing
		Util.saveCsvToFile(sb.toString(), "testResultDP_sameNDifferentW.csv");
		System.out.println("Finished processing");

	}

	/**
	 * same n and w for all the iterations.
	 * 
	 * @param iteration
	 * @param dataSetSize
	 */
	public static void testRegressionAllAlgorithmsSameDataSetInAllIteration(int iteration, int dataSetSize) {
		StringBuilder sb = new StringBuilder();

		sb.append(
				"Data Set Size,Capacity, Brute Force Time(NanoSec),DP buttomUp Time(NanoSec), DP Top Down Time(NanoSec),")
				.append(System.lineSeparator());

		_W = Util.randomIntGenerator();
		values = Util.randomIntArrayGenerator(dataSetSize);
		weights = Util.randomIntArrayGenerator(values.length);// same length
		// regression
		for (int i = 0; i < iteration; i++) {

			sb.append(dataSetSize).append(",").append(_W).append(",");
			// Brute force goes here
			long start = System.nanoTime();
			new KnapsackBruteForce(values, weights, _W);
			long finish = System.nanoTime();
			System.out.println("bruteforce finished");

			sb.append((finish - start)).append(",");

			// DP buttom up goes here
			start = System.nanoTime();
			new KnapsackBottomUpDp(values, weights, _W);
			finish = System.nanoTime();
			System.out.println("dp buttom up finished");

			sb.append((finish - start)).append(",");

			// DP top down goes here.
			start = System.nanoTime();
			new KnapsackTopDownDp(values, weights, _W);
			finish = System.nanoTime();
			System.out.println("dp top down finished");
			sb.append((finish - start)).append(",").append(System.lineSeparator());

		}

		// finished now do the IO thing
		Util.saveCsvToFile(sb.toString(), "testRegressionAllAlgorithmsSameDataSetInAllIteration.csv");
		System.out.println("Finished processing");

	}

}
