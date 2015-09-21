package sorting;

import java.util.*;

/*
 * This is ~ I'm smart.
 */
public class FindCommonValueInThreeSortedArray {
	public static List<Integer> findCommon(int[] arr1, int[] arr2, int[] arr3){
		int i = 0, j = 0, k = 0;
		int l1 = arr1.length, l2 = arr2.length, l3 = arr3.length;
		List<Integer> res = new LinkedList<Integer>();
		while(i < l1 && j < l2 && k < l3){
			if(arr1[i] == arr2[j] && arr2[j] == arr3[k]){
				res.add(arr1[i]);
				i++;
				j++;
				k++;
			}
			
			else if(arr1[i] < arr2[j]){
				i++;
			}
			else if(arr1[i] > arr2[j])
				j++;
			else
				k++;
		}
		return res;
	}
}
