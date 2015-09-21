package sorting;

public class NutsAndBolts {
	public static void matching(int[] nuts, int[] bolts, int low, int high){
		if(low < high){
			int pivot = partition(nuts, low, high, bolts[high]);
			partition(bolts, low, high, nuts[pivot]);
			matching(nuts, bolts, low, pivot - 1);
			matching(nuts, bolts, pivot + 1, high);
		}
	}
	
	
	//first move the staff == pivot to the last position 
	//if smaller, the "i - start", swap.
	//actually start may point to the position which is larger.
	public static int partition(int[] arr, int low, int high, int pivot){
		int i = low;
		int tmp1, tmp2;
		for(int j = low; j < high; j++){
			if(arr[j] < pivot){
				tmp1 = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp1;
				i++;
			}
			else if(arr[j] == pivot){
				tmp1 = arr[j];
				arr[j] = arr[high];
				arr[high] = tmp1;
				j--;
			}
		}
		tmp2 = arr[i];
		arr[i] = arr[high];
		arr[high] = tmp2;
		return i;
	}
	
	public static void swap(int[] arr, int i, int j){
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	
	public static void main(String[] args){
		int[] nuts = {3, 1, 4, 8};//{3, 1, 6, 8, 7, 2, 5};
		int[] bolts = {4, 1, 8, 3};//{5, 3, 7, 6, 2, 1, 8};
		matching(nuts, bolts, 0, nuts.length - 1);
		for(int i = 0; i < nuts.length; i++){
			System.out.print(nuts[i] + " ");
		}
		System.out.println();
		for(int i = 0; i < nuts.length; i++){
			System.out.print(bolts[i] + " ");
		}
	}
}
