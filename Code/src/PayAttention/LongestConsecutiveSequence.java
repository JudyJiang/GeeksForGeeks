package PayAttention;
import java.util.*;

public class LongestConsecutiveSequence {
	public static int longestConsecutive(int[] nums) {
		int maxLen = 0;
		HashSet<Integer> map = new HashSet<Integer>();
		for(Integer i : nums)
			map.add(i);
		
		for(Integer num : nums){
			maxLen = Math.max(maxLen,  getContinuousLength(map, num + 1, true) + getContinuousLength(map, num - 1, false) + 1);
		}
		return maxLen;
	}
	
	public static int getContinuousLength(HashSet<Integer> map, int value, boolean increase){
		int count = 0;
		while(map.contains(value)){
			count++;
			map.remove(value); //if not removed, unlinear.
			if(increase)
				value++;
			else
				value--;
		}
		return count;
	}
	
	public static void main(String[] args){
		int[] nums = {100, 4, 200, 1, 3, 2};
		System.out.println(longestConsecutive(nums));
	}
}
