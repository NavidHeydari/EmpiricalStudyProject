package edu.uw.empiricalstudy.algorithms;

import java.util.HashMap;
import java.util.Map;
/**
 * 
 * @author Sri
 *
 */
public class KnapsackTopDownDp {

    class Index {
        int remainingWeight;
        int remainingItems;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Index index = (Index) o;

            if (remainingWeight != index.remainingWeight) return false;
            return remainingItems == index.remainingItems;

        }

        @Override
        public int hashCode() {
            int result = remainingWeight;
            result = 31 * result + remainingItems;
            return result;
        }
    }
    

    public int topDownRecursiveUtil(int values[], int weights[], int remainingWeight, int totalItems, int currentItem, Map<Index, Integer> map) {
        //if currentItem exceeds total item count or remainingWeight is less than 0 then
        //just return with 0;
        if(currentItem >= totalItems || remainingWeight <= 0) {
            return 0;
        }

        //fom a key based on remainingWeight and remainingCount
        Index key = new Index();
        key.remainingItems = totalItems - currentItem -1;
        key.remainingWeight = remainingWeight;

        //see if key exists in map. If so then return the maximumValue for key stored in map.
        if(map.containsKey(key)) {
            return map.get(key);
        }
        int maxValue;
        //if weight of item is more than remainingWeight then try next item by skipping current item
        if(remainingWeight < weights[currentItem]) {
            maxValue = topDownRecursiveUtil(values, weights, remainingWeight, totalItems, currentItem + 1, map);
        } else {
            //try to get maximumValue of either by picking the currentItem or not picking currentItem
            maxValue = Math.max(values[currentItem] + topDownRecursiveUtil(values, weights, remainingWeight - weights[currentItem], totalItems, currentItem + 1, map),
                    topDownRecursiveUtil(values, weights, remainingWeight, totalItems, currentItem + 1, map));
        }
        //memoize the key with maxValue found to avoid recalculation
        map.put(key, maxValue);
        return maxValue;

    }
	
	public KnapsackTopDownDp(int[] values, int[] weights, int w) {
		 //map of key(remainingWeight, remainingCount) to maximumValue they can get.
        Map<Index, Integer> map = new HashMap<>();
        topDownRecursiveUtil(values, weights, w, values.length, 0, map);
	}
}
