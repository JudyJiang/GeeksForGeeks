import java.util.*;

/*
 * It's really easy....
 */
public class ContainDuplicatesII {
	public static boolean containsNearbyDuplicate(int[] nums, int k){
		if(nums == null || nums.length < k)
			return false;
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i < nums.length; i++){
			if(!map.containsKey(nums[i])){
				map.put(nums[i], i);
			}
			else{
				int dis = i - map.get(nums[i]);
				if(dis <= k)
					return true;
			}
		}
		return false;
	}
}
