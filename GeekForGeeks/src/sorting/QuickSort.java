package sorting;

public class QuickSort {
	
	public static void Sort(int[] arr){
		if(arr == null || arr.length == 0)
			return ;
		
		quickSort(arr, 0, arr.length - 1);
	}
	
	public static void quickSort(int[] arr, int low, int high){
		if(low > high)
			return ;
		
		int i = low, j = high, pivot = arr[(low + high) / 2];
		while(i <= j){
			while(arr[i] < pivot)
				i++;
			
			while(arr[j] > pivot)
				j--;
			
			if(i <= j){
				ExchangeElement(arr, i, j);
				i++;
				j--;
			}
		}
		
		if(low < j)
			quickSort(arr, low, j);
		
		if(i < high)
			quickSort(arr, i, high);
	}
	
	public static void ExchangeElement(int[] arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	public static void Print(int[] arr){
		for(int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
	
	public static void main(String[] args){
		int[] arr = {24,2,45,20,56,75,2,56,99,53,12};
		Sort(arr);
		Print(arr);
	}
}
