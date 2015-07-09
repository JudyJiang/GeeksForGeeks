import java.util.*;
import utility.*;

public class test {
	public static List<List<Integer>> subsets(int n){
		List<List<Integer>> res = new LinkedList<List<Integer>>();
		if(n <= 0){
			return res;
		}
		
		List<Integer> list = new LinkedList<Integer>();
		subsets(n, 0, res, list, 1);
		return res;
	}
	
	public static void subsets(int n, int tmp, List<List<Integer>> res, List<Integer> list, int index){
		if(tmp > n){
			return ;
		}
		if(tmp == n){
			List<Integer> copy = new LinkedList<Integer>();
			copy.addAll(list);
			res.add(copy);
			return;
		}
		
		for(int i = index; i <= n; i++){
			if(tmp + i <= n){
				list.add(i);
				subsets(n, tmp + i, res, list, index);
				list.remove(list.size() - 1);
			}
		}
	}
	
	public static void main(String[] args){
		List<List<Integer>> res = subsets(4);
		System.out.println(res.size());
		for(List<Integer> list : res){
			for(Integer i : list){
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
}
