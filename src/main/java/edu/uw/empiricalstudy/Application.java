package edu.uw.empiricalstudy;

import edu.uw.empiricalstudy.algorithms.KnapsackBottomUpDp;
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
	 
		_W = Util.randomIntGenerator();
		values = Util.randomIntArrayGenerator(3);
		weights = Util.randomIntArrayGenerator(values.length);
		
		//Dp buttom up
		long start = System.nanoTime();
		new KnapsackBottomUpDp(values, weights, _W);
		long finish = System.nanoTime();
		
		Util.saveCsvToFile((finish-start), values.length, "result.csv");
		
		
	}
	
	
	
	
	//TODO clean up in future if you need to just run the algorithm using random generator and not reading the file.
//	public static void main(String... args) {
//
//		try {
//			String path = JOptionPane
//					.showInputDialog("Enter the file location input contains number for values Array:");
//
//			values = Util.readInputFileToArrays(path);
//			
//			path = JOptionPane
//					.showInputDialog("Enter the file location input contains number for weights Array:");
//
//			weights = Util.readInputFileToArrays(path);
//			
//			
//			String cap = JOptionPane
//			.showInputDialog("Enter the total Capacity of Knapsack:");
//			_W = Integer.valueOf(cap);
//			
//			
//		
//			
//		} catch (IOException e) { 
////			e.printStackTrace();
//			
//			JOptionPane.showMessageDialog(null, "The input format or input address wasn't proper. please try again. Details:" + e.getClass());
//		}
//
//	}

	
	
	
}
