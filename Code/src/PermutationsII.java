import java.util.*;

public class PermutationsII {
	public static List<List<Integer>> permuteUnique(int[] nums){
		List<List<Integer>> res = new LinkedList<List<Integer>>();
		if(nums == null || nums.length == 0)
			return res;
		Arrays.sort(nums);
		
		List<Integer> list = new LinkedList<Integer>();
		boolean[] avail = new boolean[nums.length];
		Arrays.fill(avail, true);
		permute(nums, res, list, avail);
		return res;
	}
	
	public static void permute(int[] nums, List<List<Integer>> res, List<Integer> list, boolean[] avail){
		if(list.size() == nums.length){
			List<Integer> copy = new LinkedList<Integer>();
			copy.addAll(list);
			res.add(copy);
			return ;
		}
		
		for(int i = 0; i < nums.length; i++){
			//this step is more important!. save lines of codes
			//the avail[i - 1] means now it's the i's turn to be put into list
			//but the nums[i-1] equals nums[i] and nums[i-1] is also available.
			//whatever permutation it's going to contruct must have already been done 
			//during the nums[i-1] value turn
			if(i > 0 && nums[i] == nums[i - 1] && avail[i - 1])
				continue;
			if(avail[i]){
				list.add(nums[i]);
				avail[i] = false;
				permute(nums, res, list, avail);
				avail[i] = true;
				list.remove(list.size() - 1);
			}
		}
	}
}
