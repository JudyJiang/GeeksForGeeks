package sorting;

public class SearchInAlmostSortedArray {
	public static int searchInAlmostSortedArray(int[] arr, int x){
		return searchInAlmostSortedArray(arr, 0, arr.length - 1, x);
	}
	
	public static int searchInAlmostSortedArray(int[] arr, int l, int r, int x){
		if(l > r)
			return -1;
		
		int mid = l + (r - l) / 2;
		if(arr[mid] == x)
			return mid;
		
		if(mid - 1 > l && arr[mid - 1] == x)
			return mid - 1;
		if(mid + 1 < r && arr[mid + 1] == x)
			return mid + 1;
		
		if(arr[mid] > x)
			return searchInAlmostSortedArray(arr, l, mid - 2, x);
		else
			return searchInAlmostSortedArray(arr, mid + 2, r, x);
	}
}
