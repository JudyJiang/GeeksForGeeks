package sorting;


/**
 * This is solved better than the GeeksForGeeks Solution.
 * @author FengjiaoJiang
 * http://www.geeksforgeeks.org/sort-array-wave-form-2/
 *
 */
public class SortArrayWave_FENGJIAO_JIANG {
	public static void sortArrayInWave(int[] arr){
		if(arr == null || arr.length <= 1){
			return;
		}
		
		boolean increase = arr[1] > arr[0] ? true : false;
		for(int i = 2; i < arr.length; i++){
			if(increase){
				if(arr[i] > arr[i - 1]){
					swap(arr, i, i - 1);
				}
			}
			else{
				if(arr[i] < arr[i - 1]){
					swap(arr, i, i - 1);
				}
			}
			increase = !increase;
		}
	}
	
	public static void swap(int[] arr, int i, int j){
		int tmp = arr[i];
		arr[i] = arr[i - 1];
		arr[i - 1] = tmp;
	}
	
	public static void main(String[] args){
		int[] arr = {2, 4, 6, 8, 10, 20};
		sortArrayInWave(arr);
		for(int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
	}
}

