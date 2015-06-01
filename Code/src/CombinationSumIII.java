import java.util.*;

/*
 * Got approved in the first submit.
 * Happy now.
 */
public class CombinationSumIII {
	public static List<List<Integer>> combinationSum3(int k, int n){
		List<List<Integer>> res = new LinkedList<List<Integer>>();
		if(k <= 0 || n > 45)
			return res;
		
		List<Integer> tmp = new LinkedList<Integer>();
		combinationSum3(res, tmp, k, n, 0, 1);
		return res;
	}
	
	public static void combinationSum3(List<List<Integer>> res, List<Integer> tmp, int k, int n, int currSum, int index){
		if(currSum > n || tmp.size() > k)
			return;
		
		if(currSum == n && tmp.size() == k){
			List<Integer> added = new LinkedList<Integer>();
			added.addAll(tmp);
			res.add(added);
			return;
		}
		
		for(int i = index; i <= 9; i++){
			tmp.add(i);
			combinationSum3(res, tmp, k, n, currSum + i, i + 1);
			tmp.remove(tmp.size() - 1);
		}
	}
	
	public static void main(String[] args){
		int k = 3, n = 9;
		List<List<Integer>> res = combinationSum3(k, n);
		System.out.println(res.size());
		for(List<Integer> list : res){
			for(Integer ele : list){
				System.out.print(ele + " ");
			}
			System.out.println();
		}
	}
} 