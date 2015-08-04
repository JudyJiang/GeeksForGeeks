package careercup;

import java.util.Arrays;
import java.util.Random;

public class SecondMost {
	
	public static int[] secondMost(int[] nums){
		Arrays.sort(nums);
		int mid = (0 + nums.length) / 2;
		if(nums.length % 2 != 0)
			mid += 1;
		int[] res = new int[nums.length];
		int i = 0, j = mid, k = 0;
		for(; k < nums.length; ){
			if(i < mid)
				res[k++] = nums[i++];
			if(j < nums.length)
				res[k++] = nums[j++];
		}
		return res;
	}

	
	//http://www.careercup.com/question?id=5681702473039872
	//O(n) solution, increment by 2
	public static void main(String[] args){
		int[] nums = {1, 4, 5, 2, 3};
		int[] res = secondMost(nums);
		for(int i = 0; i < res.length; i++)
			System.out.print(res[i] + " ");
	}
}
