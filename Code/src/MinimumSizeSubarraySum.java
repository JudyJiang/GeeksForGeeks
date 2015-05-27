import java.util.*;

public class MinimumSizeSubarraySum {
	public static int sumArray(int[] arr, int start, int end){
		int res = 0;
		for(int i = start; i <= end; i++){
			res += arr[i];
		}
		
		return res;
	}
	
	/*
	 * This method exceeds the time limits....
	 */
	public static int minSubArrayLen(int s, int[] nums){
		if(nums == null || nums.length == 0)
			return 0;
		
		int size = nums.length, start = 0, minLen = Integer.MAX_VALUE, currLen = 0;
		for(int i = 0; i < size; i++){
			if(nums[i] >= s){
				return 1;
			}
			
			
			int tmpSum = sumArray(nums, start, i);
			currLen += 1;

			if(tmpSum > s){
				//System.out.println(tmpSum + " " + start + " " + i);
				while(tmpSum >= s){
					tmpSum -= nums[start];
					start++;
					currLen--;
				}
				
				if(currLen + 1 < minLen){
					minLen = currLen + 1;
				}
			}
		}
		return minLen;
	}
	
	/*
	 * Pre-compute the window size..
	 * This is an improvement and pass the tests!! pay attention, marked below
	 */
	public static int minSubArrayLenII(int s, int[] nums){
		if(nums[0] >= s)
			return 1; // Don't forget this step
		
		int start = 0, size = nums.length, minLen = Integer.MAX_VALUE;
		int[] preComputeSum = new int[size];
		preComputeSum[0] = nums[0];
		for(int i = 1; i < size; i++){
			preComputeSum[i] = preComputeSum[i-1] + nums[i];
		}
		
		if(preComputeSum[size - 1] < s)
			return 0; // This is specified in problems
		
		for(int i = 1; i < size; i++){
			if(nums[i] >= s)
				return 1;
			
			preComputeSum[i] = preComputeSum[i-1] + nums[i];
			
			if(preComputeSum[i] >= s){
				while(preComputeSum[i] >= s){
					preComputeSum[i] -= nums[start];
					start++;
				}
				if((i - (start-1) + 1) < minLen) //i - (start - 1) + 1 serves as the current length
					minLen = (i - (start-1) + 1);
			}
		}
		
		return minLen;
	}
	
	public static void main(String[] args){
		int[] nums = {1,2, 3, 4, 5};//{2,3,1,2,4,3};//{1, 2, 3, 4, 5};
		int s = 10;
		System.out.println(minSubArrayLen(s, nums) + " " + minSubArrayLenII(s, nums));
		
	}
}
