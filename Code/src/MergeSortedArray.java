
public class MergeSortedArray {
	public static void merge(int[] nums1, int m, int[] nums2, int n){
		int size = m + n - 1, i = m - 1, j = n - 1;
		while(i >= 0 && j >= 0){
			if(nums1[i] >= nums1[j])
				nums1[size--] = nums1[i--];
			else
				nums1[size--] = nums2[j--];
		}
		while(j >= 0){
			nums1[size--] = nums2[j--];
		}
	}
	
	public static void main(String[] args){
		int[] nums1 = {0};
		int[] nums2 = {1};
		
		merge(nums1, 0, nums2, 1);
	}
}
