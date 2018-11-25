package edu.uw.empiricalstudy.algorithms;

import edu.uw.empiricalstudy.common.Util;

public class KnapsackBruteForce {

	public static int[][] result = new int[Util.N][Util.N];
	public static int totalValuesSoFar = 0;
	
	public KnapsackBruteForce(int[] values, int[] weights, int w) {
		 
//		if(w - weights[i] >= 0){
//			
////				totalValuesSoFar += values[i];
////				w -= weights[i];
//			}
		
		
	}
	
	private void calculateBruteForce(){
		
	}
	
	
	
	
	/**
	 * init result 2d array with the situation that nothing was selected.
	 */
	public void initResult(){
		for(int i = 0 ; i < result.length ; i++){
			for(int j = 0 ; j < result[i].length ; j++){
				result[i][j] = 0;
			}
		}
	}
	
	
	
}
