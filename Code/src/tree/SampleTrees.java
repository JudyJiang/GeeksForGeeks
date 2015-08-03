package tree;

import utility.*;

public class SampleTrees {
	static TreeNode root1;
	static TreeNode root2;
	static TreeNode root3;
	static TreeNode root4;
	
	static{
		root1 = new TreeNode(12);
		root1.left = new TreeNode(5);
		root1.right = new TreeNode(7);
		root1.left.left = new TreeNode(3);
		root1.right.right = new TreeNode(1);
	}
	
	static{
		root2 = new TreeNode(12);
		root2.left = new TreeNode(5);
		root2.right = new TreeNode(7);
		root2.left.left = new TreeNode(3);
	}
	
	static{
		root4 = new TreeNode(6);
		root4.left = new TreeNode(3);
		root4.right = new TreeNode(5);
		root4.left.left = new TreeNode(7);
		root4.left.right = new TreeNode(8);
		root4.right.left = new TreeNode(1);
		root4.right.right = new TreeNode(3);
	}
	
	static{
		root3 = new TreeNode(12);
		root3.left = new TreeNode(5);
		root3.left.left = new TreeNode(3);
		root3.left.left.left = new TreeNode(1);
		root3.left.right = new TreeNode(9);
		root3.left.right.left = new TreeNode(2);
	}
}
