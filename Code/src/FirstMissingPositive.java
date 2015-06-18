import java.util.Arrays;

/**
 * Since it asks for O(n) solutions can't sort.
 * @author FengjiaoJiang
 *
 */
public class FirstMissingPositive {
	/*
	 * This is my own solution, use sorting, easier but a lot details
	 * 1. ignore the negative and 0;
	 * 2. after filtering all negatives situation of [2] or [3] or [2, 3, ..] should return 1;
	 * 3. duplicates [1, 1, 2, 2] return 3, ignore adjacent duplicates
	 */
	public static int firstMissingPositiveSorted(int[] nums){
		if(nums == null || nums.length == 0)
			return 1;
		
		Arrays.sort(nums);
		int index = 0, size = nums.length;
		while(index < size && nums[index] <= 0){
			index++;
		}
		
		if(index < size && nums[index] > 1)
			return 1;
		
		for(int i = index; i < size - 1; i++){
			if(nums[i] == nums[i + 1])
				continue;
			if(nums[i] + 1 != nums[i + 1])
				return nums[i] + 1;
		}
		
		return nums[size - 1] + 1;
	}
	
	/*
	 * This is to swap all the number into corresponding index positions
	 */
	public static int firstMissingPositive(int[] nums){
		if(nums == null || nums.length == 0)
			return -1;
		
		int i = 0, j = nums.length;
		while(i < j){
			//this doesn't care if negative are all at the front
			//as long as each num[i] are at index "i - 1" 
			//Then if nums[i] != i + 1, i + 1 is the first missing even nums[i] <= 0
			if(nums[i] != i + 1 && nums[i] >= 1 && nums[i] <= j && nums[nums[i] - 1] != nums[i])
				swap(nums, i, nums[i] - 1);
			else
				i++;
		}
		
		for(int k = 0; k < j; k++){
			if(nums[k] != k + 1)
				return k + 1;
		}
		return j + 1;
	}
	
	public static void swap(int[] nums, int a, int b){
		int t = nums[a];
		nums[a] = nums[b];
		nums[b] = t;
	}
	
	public static void main(String[] args){
		int[] nums = {0, 2, 2, 1, 1};//{3, 4, -1, 1};//{1, 2, 0};//{-1, -1, 2, 3};
		int res = firstMissingPositiveSorted(nums);
		System.out.println(res);
	}
}
