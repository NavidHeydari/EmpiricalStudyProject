package edu.uw.empiricalstudy.algorithms;

public class KnapsackBruteForce {

	
	public KnapsackBruteForce(int[] values, int[] weights, int w) {

		int indexAtThisPoint = values.length-1;
		int finalValueSelection = calculateBruteForce(values, weights, w,indexAtThisPoint);
//		System.out.println("final result BruteForce with: Value So far:"+finalValueSelection + ", "); 
	}

	private int calculateBruteForce(int[] values, int[] weights, int capacity, int index) {
//		System.out.println("called BruteForce with: \n\tcapacity So far:"+capacity + ", indexAtThispoint:"+index);// + " val=" + values[index] + " | weigth="+weights[index]); 
		
		//base case
		if(capacity <= 0 || index < 0 || index == values.length){
//			System.out.println("buttom rock! cap="+capacity + " | index="+index);
			return 0;//nothing to pick and put into bag with 0 cap!
			//or we iterated everything 
		}
		
		//recursive parts 
		return Math.max(values[index] + calculateBruteForce(values,weights,capacity-weights[index],index-1)
		, calculateBruteForce(values,weights,capacity,index-1));
		
//		int notPicked = calculateBruteForce(values,weights,capacity,index-1);
//		System.out.println("finished not picked. with index="+index + " not picked value="+notPicked);
//		int picked = values[index] + calculateBruteForce(values,weights,capacity-weights[index],index-1);
//		System.out.println("finished picked. with index="+index+ " picked value="+picked);
//		
//		System.out.println(picked + "?"+notPicked);
//		if(picked >= notPicked){
//			System.out.println("PICKED value[" + index+"]="+values[index]+" weight[" +index+"]="+weights[index] + " | remaining Capacity=" + (capacity-weights[index]) + " | value so far=" + picked ); 
//			return picked;
//		}else{
//			System.out.println("NOT PICKED value[" + index+"]="+values[index]+" weight[" +index+"]="+weights[index] + " | remaining Capacity=" + (capacity) + " | value so far=" + notPicked ); 
//			return notPicked;
//		}
	}

	//TODO clean up after testing 
//	public static void main(String[] args) {
//
//		int values[] = new int[] {1,2,5,9};//{ 60, 100, 120 };
//		int weights[] = new int[] {2,3,3,4};//{ 10, 20, 30 };
//		int capacity = 7;//50; 
//		
//		//result is 220
//		
//		new KnapsackBruteForce(values, weights, capacity);
//
//	}

}
