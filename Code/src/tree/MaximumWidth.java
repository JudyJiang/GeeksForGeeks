package tree;

import utility.TreeNode;
import java.util.*;


public class MaximumWidth {
	public static int maxWidth(TreeNode root){
		if(root == null)
			return 0;
		
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		int max = 0, count = 0;
		queue.add(root);
		queue.add(null);
		while(true){
			TreeNode top = queue.poll();
			if(top == null){
				max = Math.max(max, count);
				count = 0;
				if(queue.size() == 0){
					return max;
				}
				queue.add(null);
			}
			
			else{
				if(top.left != null){
					queue.add(top.left);
					count += 1;
				}
				if(top.right != null){
					queue.add(top.right);
					count += 1;
				}
			}
		}
	}
}
