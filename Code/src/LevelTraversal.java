import java.util.*;
import utility.*;

public class LevelTraversal {
	public static List<List<Integer>> levelOrder(TreeNode root){
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
		
		return res;
	}
	
	
	public static void main(String[] args){
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		List<List<Integer>> res = levelOrder(root);
		
		for(List<Integer> l: res){
			for(Integer ele : l){
				System.out.print(ele + " ");
			}
			System.out.println();
		}
	}
}
