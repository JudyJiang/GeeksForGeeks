import java.util.*;


public class ContainDuplicates {
	public static boolean containsDuplicate(int[] nums){
		if(nums == null || nums.length == 0)
			return true;
		
		Arrays.sort(nums);
		for(int i = 1; i < nums.length; i++){
			if(nums[i - 1] == nums[i])
				return false;
		}
		
		return true;
	}
	
	public static boolean containsDuplicateII(int[] nums){
		if(nums == null || nums.length == 0)
			return true;
		
		HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
		for(int i = 0;i < nums.length; i++){
			if(!map.containsKey(nums[i]))
				map.put(nums[i], true);
			else
				return true;
		}
		return false;
	}
}
