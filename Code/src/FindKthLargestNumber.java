
public class FindKthLargestNumber {
	public static int findKthLarget(int[] nums, int k){
		if(nums == null || nums.length == 0)
			return -1;
		//this nums.length + 1 - k is to count from the left end
		return findKthLargest(nums, 0, nums.length - 1, nums.length + 1 - k);
	}
	
	public static int findKthLargest(int[] nums, int start, int end, int k){
		int pivot = nums[end];
		int left = start;
		int right = end;
		
		while(true){
			while(left < right && nums[left] < pivot)
				left++;
			while(right > left && nums[right] >= pivot)
				right--;
			if(left == right)
				break;
			swap(nums, left, right); //ever meet a left >= pivot and right < pivot, swap them.
			//eventually left and right will equal
		}
		swap(nums, left, end); //since pivot is the boundary line, 
		if(left + 1 == k)
			return pivot; //left is right at the place 
		else if(k < left + 1)
			return findKthLargest(nums, start, left - 1, k);
		
		else 
			return findKthLargest(nums, left + 1, end, k);
	}
	
	public static void swap(int[] nums, int left, int right){
		int tmp = nums[left];
		nums[left] = nums[right];
		nums[right] = tmp;
	}
	
	public static void main(String[] args){
		int[] nums = {3, 4, 1, 2, 5, 9, 7, 6, 4, 8};
	}
}
