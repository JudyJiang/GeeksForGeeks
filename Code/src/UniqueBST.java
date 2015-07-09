import utility.*;
import java.util.*;

public class UniqueBST {
	public static int uniqueBST(int n){
		int[] res = new int[n + 1];
		res[0] = res[1] = 1;
		
		//when there's one node, two node .. n nodes.
		for(int i = 2; i <= n; i++){
			for(int j = 0; j < 2; j++){
				res[i] += res[j] + res[i - 1 - j];//minus one is the root
			}
		}
		return res[n];
	}
	
	
	//recursively construct left and right nodes..
	public static List<TreeNode> uniqueBSTII(int n){
		List<TreeNode> res = new LinkedList<TreeNode>();
		if(n <= 0){
			return res;
		}
		return null;
	}
	
	
	//separate left and right sides.
	//It's actually divide and conquer.
	//return is not a single node cause it's not uniquely decided
	public static List<TreeNode> uniqueBSTII(int left, int right){
		List<TreeNode> tmp = new LinkedList<TreeNode>();
		if(left > right){
			tmp.add(null);
			return tmp;
		}
		
		
		for(int i = left; i <= right; i++){
			List<TreeNode> lefts = uniqueBSTII(left, i - 1);
			List<TreeNode> rights = uniqueBSTII(i + 1, right);
			for(TreeNode ileft : lefts){
				for(TreeNode iright : rights){
					TreeNode root = new TreeNode(i);
					root.left = ileft;
					root.right = iright;
					tmp.add(root);
				}
			}
		}
		return tmp;
	}
}
