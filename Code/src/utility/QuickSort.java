package utility;

public class QuickSort {
	public static void quickSort(int[] arr){
		if(arr == null || arr.length == 0)
			return;
		int low = 0, high = arr.length - 1;
		quickSort(arr, low, high);
	}
	
	public static void quickSort(int[] arr, int low, int high){
		if(low >= high)
			return;
		
		int middle = low + (high - low) / 2; 
		int i = low, j = high, pivot = arr[middle];
		
		while(i <= j){
			while(arr[i] < pivot)
				i++;
			
			while(arr[j] > pivot)
				j--;
			
			if(i <= j){
				swap(arr, i, j);
				i++;
				j--;
			}
		}
		
		if(low < j)
			quickSort(arr, low, j);
		if(high > i)
			quickSort(arr, i, high);
	}
	
	public static void swap(int[] arr, int a, int b){
		int t = arr[a];
		arr[a] = arr[b];
		arr[b] = t;
	}
	
	public static void main(String[] args){
		int[] x = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5};//{9, 2, 4, 7, 3, 7, 10};
		quickSort(x);
		for(int i = 0; i < x.length; i++)
			System.out.print(x[i] + " ");
	}
}
