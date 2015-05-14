import java.util.*;

import utility.*;

public class LevelTraversalII {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(root == null)
			return res;
		
		LinkedList<TreeNode> list = new LinkedList<TreeNode>();
		List<Integer> level = new ArrayList<Integer>();
		list.add(root);
		list.add(null);
		res.add(new ArrayList<Integer>(Arrays.asList(root.val)));
		while(true){
			TreeNode top = list.removeFirst();
			if(list.isEmpty())
				break;
			if(top == null){
				res.add(level);
				level = new ArrayList<Integer>();
				list.add(null);			
			}
			else{
				if(top.left != null){
					list.add(top.left);
					level.add(top.left.val);
				}
				if(top.right != null){
					list.add(top.right);
					level.add(top.right.val);
				}
			}
		}
		Collections.reverse(res);
		return res;
	}
}
