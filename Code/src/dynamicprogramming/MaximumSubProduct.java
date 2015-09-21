package dynamicprogramming;

public class MaximumSubProduct {
	public static int maximumSubProduct(int[] arr){
		int max = Integer.MIN_VALUE, size = arr.length;
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++){
				if(i + j < size){
					int tmpProduct = calProduct(arr, i, j);
					max = Math.max(max, tmpProduct);
				}
			}
		}
		return max;
	}
	
	public static int calProduct(int[] arr, int i, int j){
		int res = 1;
		for(int k = i; k <= j; k++)
			res *= arr[k];
		return res;
	}
	
	
	public static int dpMaximumSubProduct(int[] arr){
		if(arr == null || arr.length == 0)
			return 0;
		int max = arr[0], maxLocal = arr[0], minLocal = arr[0];
		//the miniLocal is actually the negative version of running maximum when arr[i] negative 
		//is encountered. 
		for(int i = 1; i < arr.length; i++){
			int tmp = maxLocal;
			maxLocal = Math.max(Math.max(arr[i] * maxLocal, maxLocal), minLocal * arr[i]);
			minLocal = Math.min(Math.min(arr[i] * tmp, arr[i]),  minLocal * arr[i]);
			max = Math.max(maxLocal, max);
		}
		return max;
	}
}
