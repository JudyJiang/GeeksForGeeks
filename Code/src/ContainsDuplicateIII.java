import java.util.*;

public class ContainsDuplicateIII {
	public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t){
		if(nums == null || nums.length == 0){
			return false;
		}
		
		TreeSet<Integer> set = new TreeSet<Integer>();
		for(int i = 0; i < nums.length; i++){
			int value = nums[i];
			if((set.floor(value) != null && set.floor(value) + t >= value) ||
			(set.ceiling(value) != null && set.ceiling(value) - t <= value)){
			    return true;
			}
			
			set.add(value);
			if(i >= k)
				set.remove(nums[i - k]);
		}
		return false;
	}
	
	public static void main(String[] args){
		TreeSet<Integer> set = new TreeSet<Integer>();
		set.add(49);
		set.add(68);
		set.add(54);
		set.add(80);
		set.add(1);
		set.add(43);
		System.out.println(set.floor(70));
	}
}
