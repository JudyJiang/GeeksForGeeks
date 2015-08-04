package careercup;

public class MergeSort {
	public static void mergeSort(int[] arr, int[] tmp, int left, int right){
		if(left < right){
			int mid = left + (right - left) / 2;
			mergeSort(arr, tmp, left, mid);
			mergeSort(arr, tmp, mid + 1, right);
			merge(arr, tmp, left, mid, right);
		}
	}
	
	public static void merge(int[] arr, int[] tmp, int lowIndex, int mid, int highIndex){
		for(int i = lowIndex; i <= highIndex; i++)
			tmp[i] = arr[i];
		
		int i = lowIndex;
		int j = mid + 1;
		int k = lowIndex;
		while(i <= mid && j <= highIndex){
			if(tmp[i] <= tmp[j]){
				arr[k] = tmp[i];
				i++;
			}
			else{
				arr[k] = tmp[j];
				j++;
			}
			k++;
		}
		while(i <= mid){
			arr[k] = tmp[i];
			i++;
			k++;
		}
	}
	
	public static void main(String[] args){
		int[] arr = {2, 7, 5, 5, 7, 0, 8, 1, 0};
		int[] res = new int[arr.length];
		mergeSort(arr, res, 0, arr.length - 1);
		for(int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
	}
}
