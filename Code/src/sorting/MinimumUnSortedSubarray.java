package sorting;


/*
 * Thing in the correct direction, but be more careful
 */
public class MinimumUnSortedSubarray {
	public static int[] miniIndexRange(int[] arr){
		if(arr == null || arr.length == 0)
			return null;
		
		int[] res = new int[2];
		int size = arr.length, leftIndex = -1, rightIndex = size;
		for(int i = 0; i < size - 2; i++){
			if(arr[i] > arr[i + 1]){
				leftIndex = i;
				break;
			}
		}
		
		if(leftIndex == -1)
			return null;
		for(int i = size - 1; i > 0; i--){
			if(arr[i - 1] > arr[i]){
				rightIndex = i;
				break;
			}
		}
		if(rightIndex == -1)
			return null;
		
		int min = arr[leftIndex], max = arr[leftIndex];
		for(int i = leftIndex; i <= rightIndex; i++){
			min = Math.min(min, arr[i]);
			max = Math.max(max, arr[i]);
		}
		//System.out.println(min + " " + max);
		
		for(int j = leftIndex; j >= 0; j--){
			if(arr[j] < min){
				leftIndex = j + 1;
				break;
			}
		}
		
		for(int j = rightIndex; j < size; j++){
			if(arr[j] > max){
				rightIndex = j - 1;
				break;
			}
		}
		res[0] = leftIndex;
		res[1] = rightIndex;
		return res;
	}
	
	public static void main(String[] args){
		int[] arr1 = {10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60};
		int[] arr2 = {0, 1, 15, 25, 6, 7, 30, 40, 50};
		int[] res = miniIndexRange(arr2);
		System.out.println(res[0] + " " + res[1]);
	}
}
