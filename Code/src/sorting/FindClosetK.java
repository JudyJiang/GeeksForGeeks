package sorting;

public class FindClosetK {
	public static int[] closetK(int[] arr, int X, int k){
		int left = findCrossOver(arr, 0, arr.length - 1, X);
		int right = left + 1;
		if(arr[left] == X)
			left--;
		int count = 0;
		int[] res = new int[k];
		//now it's like every merge two sorted array or linked list
		while(left >= 0 && right < arr.length && count < k){
			int leftV = X - arr[left];
			int rightV = arr[right] - X;
			if(leftV < rightV){
				res[count++] = arr[left--];
			}
			else if(leftV > rightV){
				res[count++] = arr[right++];
			}
			else{
				res[count++] = arr[left--];
				res[count++] = arr[right++];
			}
		}
		return res;
	}
	
	public static int findCrossOver(int[] arr, int left, int right, int x){
		//base case:
		if(arr[right] <= x)
			return right;
		
		if(arr[left] > x)
			return left;
		
		int mid = left + (right - left) / 2;
		//find cross point
		if(arr[mid] <= x && arr[mid + 1] > x)
			return mid;
		
		else if(arr[mid] < x)
			return findCrossOver(arr, mid + 1, right, x);
		
		else
			return findCrossOver(arr, left, mid - 1, x);
	}
}
