import java.util.*;

/**
 * if array is the same length,  it's easier I think
 * http://www.geeksforgeeks.org/median-of-two-sorted-arrays/ 
 * (array with the same size)
 * @author FengjiaoJiang
 *
 */


public class MedianOfSortedArray {
	public static int getMedian(int[] arr1, int[] arr2){
		int m = arr1.length, n = arr2.length;
		if((m + n) % 2 != 0){
			return getMedian(arr1, arr2, (m+n)/2, 0, m - 1, 0, n - 1);
		}
		else{
			return (int) ((getMedian(arr1, arr2, (m+n)/2, 0, m - 1, 0, n - 1) + getMedian(arr1, arr2, (m+n)/2-1, 0, m - 1, 0, n - 1)) * 0.5);
		}
	}
	
	//2, 4, 6, 8, 10, 12, 14
	//5, 12, 17, 23, 38, 44, 77, 84, 90  median = 8
	public static int getMedian(int[] arr1, int[] arr2, int k, int aLeft, int aRight, int bLeft, int bRight){
		int aLen = aRight - aLeft + 1;
		int bLen = bRight - bLeft + 1;
		
		if(aLen == 0){
			return arr2[bLeft + k];
		}
		
		if(bLen == 0){
			return arr1[aLeft + k];
		}
		
		if(k == 0){
			return Math.min(arr1[aLeft], arr2[bLeft]);
		}
		
		//portion of arr1 (get arr1's k-portion based on this portion)
		int aMid = aLen / (aLen + bLen) * k;
		int bMid = k - 1 - aMid; //left in arr1;
		
		aMid += aLeft;
		bMid += bLeft;
		
		if(arr1[aMid] > arr2[bMid]){
			k = k - (bMid - bLeft + 1); //Don't understand this part
			aRight = aMid;
			bLeft = bMid + 1;
		}
		
		else{
			k = k - (aMid - aLeft + 1);
			aLeft = aMid + 1;
			bRight = bMid;
		}
		
		return getMedian(arr1, arr2, k, aLeft, aRight, bLeft, bRight);
	}
}
