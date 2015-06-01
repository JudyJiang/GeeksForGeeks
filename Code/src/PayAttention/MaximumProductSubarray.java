package PayAttention;

//http://www.programcreek.com/2014/03/leetcode-maximum-product-subarray-java/
public class MaximumProductSubarray {
	public static int maxProduct(int[] nums){
		if(nums == null || nums.length == 0){
			return 0;
		}
		
		int maxLocal = nums[0], minLocal = nums[0], global = nums[0];
		for(int i = 1; i < nums.length; i++){
			int tmp = maxLocal;
			maxLocal = Math.max(Math.max(nums[i]*maxLocal, nums[i]), nums[i]*minLocal);
			minLocal = Math.min(Math.min(nums[i]*tmp, nums[i]), nums[i]*minLocal);
			global = Math.max(global, maxLocal);
		}
		return global;
	}
	
	public static void main(String[] args){
		int[] nums = {2, -5, -2, -4, 3};//{3, 2, -3, 1, -4};//{2, 3, -2, 4};
		System.out.println(maxProduct(nums));
	}
}
