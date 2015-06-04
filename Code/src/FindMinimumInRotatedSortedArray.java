
public class FindMinimumInRotatedSortedArray {
	
	public static int findMin(int[] nums, int left, int right){
		if(left == right)
			return nums[left];
		
		if(right - left == 1)
			return Math.min(nums[left], nums[right]);
		
		int mid = (left + right) / 2; //left + (right - left) / 2
		//if no rotation ....this is important cause if there's rotation
		//left is going to be bigger than right
		if(nums[left] < nums[right]) //4, 5, 6, 7, 0, 1, 2
			return nums[left];
		
		//go to left;
		else if(nums[left] > nums[mid]){
			return findMin(nums, left, mid);
		}
		//go right
		else{
			return findMin(nums, mid, right);
		}
	}
	
	public static int findMin(int[] nums){
		if(nums == null || nums.length == 0)
			return Integer.MAX_VALUE;
		
		int min = Integer.MAX_VALUE;
		
		return findMin(nums, 0, nums.length - 1);
	}
	
	
	public static int findMax(int[] nums){
		/*
		 * same thoughts, just change the left, middle and right 
		 */
		return 1;
	}
	
	public static void main(String[] args){
		int[] nums = {0, 1, 2, 4, 5, 6, 7};
		System.out.println(findMin(nums));
	}
}
