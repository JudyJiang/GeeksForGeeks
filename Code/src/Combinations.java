import java.util.*;

public class Combinations {
	public static List<List<Integer>> combine(int n, int k){
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(k > n)
			return res;
		
		List<Integer> list = new ArrayList<Integer>();
		combine(n, k, 1, res, list);
		return res;
	}
	
	public static void combine(int n, int k, int index, List<List<Integer>> res, List<Integer> list){
		if(index > n)
			return ;
		if(list.size() == k){
			List<Integer> tmp = new ArrayList<Integer>();
			tmp.addAll(list);
			res.add(tmp);
			return ;
		}
		
		for(int i = index; i <= n; i++){
			if(list.size() == 0 || list.get(list.size() - 1) != i){
				list.add(i);
				combine(n, k, i, res, list);
				list.remove(list.size() - 1);
			}
		}
	}
	
	public static void main(String[] args){
		List<List<Integer>> res= combine(4, 2);
		System.out.println(res.size());
		System.out.println(res.get(0));
	}
}
