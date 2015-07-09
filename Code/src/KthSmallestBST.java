import utility.*;
import java.util.*;

public class KthSmallestBST {
	public static int kthSmallestInBST(TreeNode root, int k){
		//In-order traversal...
		if(root == null || k == 0){
			return Integer.MAX_VALUE;
		}
		Stack<TreeNode> s = new Stack<TreeNode>();
		s.push(root);
		int count = 0;
		boolean done = false;
		int value = Integer.MAX_VALUE;
		while(!s.isEmpty() && count < k){
			TreeNode top = s.peek();
			if(top != null){
				if(done){
					s.pop();
					count++;
					value = top.val;
					s.push(top.right);
					done = false;
				}
				else{
					s.push(top.left);
				}
			}
			else{
				s.pop();
				done = true;
			}
		}
		
		return value;
	}
}
