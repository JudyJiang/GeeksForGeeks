import java.util.*;

public class CombinationSum {
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(candidates == null || candidates.length == 0)
			return res;
		Arrays.sort(candidates);
		List<Integer> list = new ArrayList<Integer>();
		return null;
	}
	
	public static void combinationSum(int[] candidates, int target, int tmpSum, List<List<Integer>> res, List<Integer> tmp){
		if(tmpSum == target){
			
		}
	}
	
	public static void main(String[] args){
		int[] candidates = {2, 3, 6, 7};
		int target = 7;
		List<List<Integer>> res = combinationSum(candidates, target);
		
	}
}
