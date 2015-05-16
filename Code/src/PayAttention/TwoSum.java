package PayAttention;
import java.util.*;


/*
 * Similar with LongestConsecutiveSequence
 */
public class TwoSum {
	
	public static int[] twoSum(int[] nums, int target) {
		int[] res ={-1, -1};
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i < nums.length; i++)
			map.put(nums[i], i+1);
		System.out.println(map.size());
		
		for(int i = 0; i < nums.length; i++){
			int tmp = target - nums[i];
			if(map.containsKey(tmp) && map.containsKey(nums[i])){
				if(map.get(tmp) == i + 1)
					continue;
				res[0] = i+1;
				res[1] = map.get(tmp);
				return res;
			}
		}
		return res;
	}
	
	public static void main(String[] args){
		int[] nums = {0, 4, 3, 0};
		int[] res = twoSum(nums, 0);
		System.out.println(res[0] + " " + res[1]);
	}
}
