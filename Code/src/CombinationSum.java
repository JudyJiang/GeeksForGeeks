import java.util.*;

public class CombinationSum {
	public static List<List<Integer>> combinationSum(int[] candidates, int target){
		List<List<Integer>> res = new LinkedList<List<Integer>>();
		if(candidates == null || candidates.length == 0)
			return res;
		
		Arrays.sort(candidates);
		List<Integer> list = new LinkedList<Integer>();
		combinationSum(candidates, res, target, list, 0, 0);
		return res;
	}
	
	public static void combinationSum(int[] candicates, List<List<Integer>> res, int target, List<Integer> list, int index, int tmpSum){
		if(tmpSum == target){
			List<Integer> copy = new LinkedList<Integer>();
			copy.addAll(list);
			res.add(copy);
		}
		if(index >= candicates.length || tmpSum > target)
			return ;//if not specified this, then it will use index 0 forever, cause tmpSum even > target won't return
		
		for(int i = index; i < candicates.length; i++){
			
			if(index == 0 || candicates[i] != candicates[i - 1]){
				list.add(candicates[i]);
				combinationSum(candicates, res, target, list, i, tmpSum+candicates[i]);
				list.remove(list.size() - 1);
			}
		}
	}
	
	public static void main(String[] args){
		int[] candidates = {2, 3, 6, 7};
		List<List<Integer>> res = combinationSum(candidates, 7);
		System.out.println(res.size());
		for(List<Integer> l : res){
			for(Integer e : l)
				System.out.print(e + " ");
			System.out.println();
		}
	}
}
