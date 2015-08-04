package tree;

import utility.TreeNode;
import java.util.*;

public class KFromLeaf {
	public static void kFromLeaf(TreeNode root, int k){
		List<TreeNode> ancestors = new LinkedList<TreeNode>();
		kFromLeaf(root, k, ancestors, 0);
	}
	
	//need visited node
	public static void kFromLeaf(TreeNode root, int k, List<TreeNode> ancestors, int level){
		if(root == null)
			return ;
		if(root.left == null && root.right == null){
			if(ancestors.size() >= k)
				System.out.println(ancestors.get(ancestors.size() - k).val);
			return;
		}
		
		ancestors.add(root);
		kFromLeaf(root.left, k, ancestors, level + 1);
		kFromLeaf(root.right, k, ancestors, level + 1);
		ancestors.remove(ancestors.size() - 1);
	}
	
	public static void main(String[] args){
		TreeNode root = SampleTrees.root5;
		kFromLeaf(root, 2);
	}
}
