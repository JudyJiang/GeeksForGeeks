package sorting;

public class Quicksort {
	public static void quicksort(int[] arr, int l, int h){
		if(l < h){
			int p = partition(arr, l, h);
			quicksort(arr, l, p - 1);
			quicksort(arr, p + 1, h);
		}
	}
	
	public static int partition(int[] arr, int l, int h){
		int x = arr[h];
		int i = l - 1;
		
		for(int j = l; j < h; j++){
			if(arr[j] < x){
				i++;
				swap(arr, i, j);
			}
		}
		swap(arr, i + 1, h);
		return (i + 1);
	}
	
	public static void swap(int[] arr, int a, int b){
		int t = arr[a];
		arr[a] = arr[b];
		arr[b] = t;
	}
	
	//http://www.geeksforgeeks.org/iterative-quick-sort/
	/*
	 * A stack can be used to avoid recurson
	 */
}
