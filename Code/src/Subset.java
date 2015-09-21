import java.util.*;

public class Subset {
	
	public static List<List<Integer>> subsets(int[] nums){
		List<List<Integer>> res = new LinkedList<List<Integer>>();
		if(nums == null || nums.length == 0)
			return res;
		
		List<Integer> list = new LinkedList<Integer>();
		subsets(nums, res, list, 0);
		return res;
	}
	
	public static void subsets(int[] nums, List<List<Integer>> res, List<Integer> list, int index){
		if(index > nums.length)
			return ;
		
		res.add(new LinkedList<Integer>(list));
		for(int i = index; i < nums.length; i++){
			list.add(nums[i]);
			subsets(nums, res, list, i + 1);
			list.remove(list.size() - 1);
		}
	}
	
	public static void main(String[] args){
		int[] nums = {1, 2, 3};
		List<List<Integer>> res = subsets(nums);
		System.out.println(res.size());
		for(List<Integer> list : res)
			System.out.println(list.toString());
	}
}
