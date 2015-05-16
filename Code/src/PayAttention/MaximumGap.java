package PayAttention;
import java.util.*;

/*
 * ...Unbelievable.. this is marked as "hard" on leetcode
 *   !! because I sorted it!
 *   How to solve in linear space??
 *   
 *   
 *   Initially I tried to just use two variable (min, max)
 *   but that's impossible, cause even with updates on min and max 
 *   when iterating the whole array.it can't maintain (this is important)
 *   "relative" (min, max) for the entire sequence. So
 *   Bucket sort is useful here cause it maintails the relative range 
 *   and bound them each to a bucket.
 *   SOLUTION:
 *   1. First get the double (interval) cause bucket initially is for uniform distribution;
 *   2. Match each element to its bucket;
 *   3. For each element keep min and max for each bucket;
 *   4. Go through each bucket to get the relative largest range.
 */
public class MaximumGap {
	
	public class Bucket{
		int low;
		int high;
		Bucket(){
			this.low = -1;
			this.high = -1;
		}
	}
	
	public static int maximumGap(int[] nums) {
		if(nums == null || nums.length < 2)
			return 0;
		Arrays.sort(nums);
		int res = Integer.MIN_VALUE;
		for(int i = 0; i <= nums.length - 2; i++){
			System.out.println(i);
			res = Math.max(res,  nums[i+1] - nums[i]);
		}
		return res;
	}
	
	public static int maximumGapII(int[] nums){
		if(nums == null || nums.length < 2)
			return 0;
		int min = nums[0], max = nums[0];
		for(int i = 1; i < nums.length; i++){
			min = Math.min(min, nums[i]);
			max = Math.max(max, nums[i]);
		}
		
		Bucket[] buckets = new Bucket[nums.length + 1];
		double interval = (double)nums.length / (max - min);
		for(int i = 0; i < nums.length; i++){
			int index = (int)((nums[i] - min) * interval);
			if(buckets[index].low == -1){
				buckets[index].low = nums[i];
				buckets[index].high = nums[i];
			}
			else{
				buckets[index].low = Math.min(nums[i], buckets[index].low);
				buckets[index].high = Math.max(nums[i], buckets[index].high);
			}
		}
		
		int diff = 0;
		int prev = buckets[0].high;
		for(int i = 0; i < buckets.length; i++){
			if(buckets[i].low != -1){
				diff = Math.max(diff,  buckets[i].low - prev);
				prev = buckets[i].high;
			}
		}
		return diff;
	}
	
	
	public static void main(String[] args){
		int[] nums = {3, 6, 9, 1};//{3, 2, 100, 1};
	}
}
