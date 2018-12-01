package edu.uw.empiricalstudy.algorithms;

import edu.uw.empiricalstudy.common.Util;
/**
 * 
 * @author Navid
 *
 */
public class KnapsackBottomUpDp {

	public KnapsackBottomUpDp(int[] values, int[] weights, int capacity) {

		//n * W = n X capacity
		int[][] selection = new int[values.length+1][capacity+1]; 
		
		for(int w =  0 ; w <= capacity;w++){
			selection[0][w] = 0; //row 0 = 0
		}
		
		int n = weights.length;
		for(int i =  0 ; i <= n ;i++){
			selection[i][0] = 0;// all items in col 0 = 0
		}
		
		//start picking
		for(int i = 1 ; i <= n ; i++){
			for(int w =  1 ; w <= capacity;w++){
				//can we go forward based on the remaining weights
				if(weights[i-1] <= w){
					//compare and see if it needs to pick it or not.
					if( values[i-1] + selection[i-1][w-weights[i-1]] >= selection[i-1][w]){
						//picked that since we still have place inside the knapsack
						selection[i][w] = values[i-1] + selection[i-1][w-weights[i-1]];
					}else{
						selection[i][w] = selection[i-1][w]; //didn't pick that
					}
				}
			}
		}
		//TODO cleanup after finish testing
//		Util.printPrettyArray(selection);
//		System.out.println(selection[n][capacity]);
		
	}

//	public static void main(String[] args) {
//
//		int values[] = new int[] { 60, 100, 120 };
//		int weights[] = new int[] { 10, 20, 30 };
//		int capacity = 50; 
//		
//		new KnapsackBottomUpDp(values, weights, capacity);
//
//	}

}
