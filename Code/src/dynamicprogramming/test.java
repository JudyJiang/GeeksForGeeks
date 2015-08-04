package dynamicprogramming;

import java.util.*;

public class test {
	public static boolean canBreakSubsets(int[] arr){
		int sum = 0;
		for(int i = 0; i < arr.length; i++)
			sum += arr[i];
		
		if(sum % 2 != 0)
			return false;
		
		return canBreak(arr, 0, 0, sum / 2);
	}
	
	public static boolean canBreak(int[] arr, int index, int tmpSum, int sum){
		if(tmpSum > sum || index >= arr.length)
			return false;
		
		if(tmpSum == sum){
			return true;
		}
		
		for(int i = index; i < arr.length; i++){
			if(canBreak(arr, i + 1, tmpSum + arr[i], sum))
				return true;
		}
		return false;
	}
	
	public static void main(String[] args){
		int[] arr = {1, 5, 3, 1};//{1, 5, 11, 5};
		
		System.out.println(canBreakSubsets(arr));
	}
}
