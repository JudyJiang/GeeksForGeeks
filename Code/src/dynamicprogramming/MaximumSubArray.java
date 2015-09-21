package dynamicprogramming;

public class MaximumSubArray {
	public static int maximumSubArray(int[] arr){
		if(arr == null || arr.length == 0)
			return Integer.MIN_VALUE;
		
		int max = arr[0];
		int[] sum = new int[arr.length];
		sum[0] = arr[0];
		for(int i = 1; i < arr.length; i++){
			sum[i] = Math.max(sum[i-1] + arr[i],  arr[i]);
			max = Math.max(max, sum[i]);
		}
		return max;
	}
	
	//how to return the index?
	//maxIndex i, maxIndexj and localIndexi, localIndexj
	//if arr[i] > sum[i-1]. localIndexi change to current i
	//if current sum[i] > max
	//maxIndexi, j change. j change if j != i;
}
