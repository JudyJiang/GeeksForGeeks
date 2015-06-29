import java.util.*;

public class CombinationSumII {
	public static List<List<Integer>> combinationSum2(int[] candidates, int target){
		List<List<Integer>> res = new LinkedList<List<Integer>>();
		if(candidates == null || candidates.length == 0)
			return res;
		
		Arrays.sort(candidates);
		List<Integer> list = new LinkedList<Integer>();
		combinationSum2(candidates, target, res, list, 0, 0);
		return res;
	}
	
	public static void combinationSum2(int[] candidates, int target, List<List<Integer>> res, List<Integer> list, int index, int sum){
		if(index >= candidates.length || sum > target)
			return ;
		
		if(sum == target){
			List<Integer> copy = new LinkedList<Integer>();
			copy.addAll(list);
			res.add(copy);
			return;
		}
		
		for(int i = index; i < candidates.length; i++){
			if(i == index || candidates[i] != candidates[i - 1]){
				int v = candidates[i];
				list.add(v);
				combinationSum2(candidates, target, res, list, i+1, sum+v);
				list.remove(list.size() - 1);
			}
		}
	}
	
	public static void main(String[] args){
		int[] candidates = {10,1,2,7,6,1,5};
		//1, 1, 2, 5, 6, 7, 10
		List<List<Integer>> res = combinationSum2(candidates, 8);
		System.out.println(res.size());
		for(List<Integer> tmp : res){
			for(Integer e : tmp)
				System.out.print(e + " ");
			System.out.println();
		}
	}
}
