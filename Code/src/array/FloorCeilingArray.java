package array;


/**
 * Lalalal~ Binary Search
 * @author FengjiaoJiang
 *
 */
public class FloorCeilingArray {
	public static int[] findFloorCeiling(int[] arr, int x){
		int[] res = new int[2];
		res[0] = Integer.MIN_VALUE;
		res[1] = Integer.MAX_VALUE;
		if(arr == null || arr.length == 0)
			return res;
		findFloorCeiling(arr, x, 0, arr.length - 1, res);
		return res;

	}
	
	public static void findFloorCeiling(int[] arr, int x, int left, int right, int[] res){
		if(left > right){
			return;
		}
		
		int mid = left + (right - left) / 2;
		if(arr[mid] == x){
//			if(mid - 1 >= 0)
//				res[0] = arr[mid-1];
//			if(mid+1 < arr.length)
//				res[1] = arr[mid+1];
			res[0] = arr[mid];
			res[1] = arr[mid];
			return ;
		}
		
		else if(arr[mid] >= x){
			res[1] = arr[mid];
			if(mid - 1 >= 0 && arr[mid-1] <= x){
				res[0] = arr[mid-1];
				return ;
			}
			else{
				findFloorCeiling(arr, x, left, mid - 1, res);
			}
		}
		
		else{
			//arr[mid] < x;
			res[0] = arr[mid];
			if(mid + 1 < arr.length && arr[mid+1] >= x){
				res[0] = arr[mid];
				res[1] = arr[mid+1];
			}
			else{
				findFloorCeiling(arr, x, mid + 1, right, res);
			}
		}
	}
	
	public static void main(String[] args){
		int[] arr = {1, 2, 8, 10, 12, 19};
		int[] res = findFloorCeiling(arr, 20);
		System.out.println(res[0] + " " + res[1]);
	}
}
