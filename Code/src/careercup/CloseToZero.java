package careercup;

import java.util.Arrays;

public class CloseToZero {
	public static int[] closeToZero(int[] nums){
		int[] res = new int[2];
		Arrays.sort(nums);
		int min = Integer.MAX_VALUE;
		int i = 0, j = nums.length - 1;
		while(i < j){
			//System.out.println(nums[i] + " " + eeenums[j]);
			int tmp = nums[i] + nums[j];
			if(tmp == 0){
				res[0] = nums[i];
				res[1] = nums[j];
				return res;
			}
			if(min > Math.abs(tmp)){
				//System.out.println("here");
				min = Math.abs(tmp);
				res[0] = nums[i];
				res[1] = nums[j];
			}
			if(tmp > 0)
				j--;
			else
				i++;
		}
		return res;
	}
	
	public static void main(String[] args){
		int[] nums = {10, -50, -20, 1, 2, -5, 51, 70};
		int[] res = closeToZero(nums);
		System.out.println(res[0] + " " + res[1]);
	}
}
