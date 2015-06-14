import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


/**
 * Remove the previous unused (i + 1)
 * keypoint is the boolean array
 * @author FengjiaoJiang
 *
 */
public class Permutations {
	public static List<List<Integer>> permute(int[] nums){
		List<List<Integer>> res = new LinkedList<List<Integer>>();
		if(nums == null || nums.length == 0)
			return res;
		boolean[] available = new boolean[nums.length];
		Arrays.fill(available, true);
		List<Integer> list = new LinkedList<Integer>();
		permute(nums, res, list, available);
		return res;
	}
	
	public static void permute(int[] nums, List<List<Integer>> res, List<Integer> list, boolean[] avail){
		if(list.size() == nums.length){
			List<Integer> newList = new LinkedList<Integer>();
			newList.addAll(list);
			res.add(newList);
			return ;
		}
		
		for(int i = 0; i < nums.length; i++){
			//System.out.println(nums[i]);
			if(avail[i]){
				list.add(nums[i]);
				avail[i] = false;
				permute(nums, res, list, avail);
				avail[i] = true;
				list.remove(list.size() - 1);
			}
		}
	}
	
	public static void main(String[] args){
		int[] nums = {1, 2, 3};
		List<List<Integer>> res = permute(nums);
		for(List<Integer> tmp : res){
			for(int i : tmp){
				System.out.print(i + " ");
			}
			System.out.println();
		}
		
	}
}
