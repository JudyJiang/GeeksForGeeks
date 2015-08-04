package tree;

import utility.*;

public class SampleTrees {
	static TreeNode root1;
	static TreeNode root2;
	static TreeNode root3;
	static TreeNode root4;
	static TreeNode root5;
	
	static{
		/*
		 * 			12
		 * 		   /  \
		 * 		  5    7
		 *       /      \
		 *      3        1
		 */
		root1 = new TreeNode(12);
		root1.left = new TreeNode(5);
		root1.right = new TreeNode(7);
		root1.left.left = new TreeNode(3);
		root1.right.right = new TreeNode(1);
	}
	
	static{
		/*
		 * 			12
		 * 		   /  \
		 * 		  5    7
		 * 		 /
		 * 		3
		 */
		root2 = new TreeNode(12);
		root2.left = new TreeNode(5);
		root2.right = new TreeNode(7);
		root2.left.left = new TreeNode(3);
	}
	
	static{
		/*
		 * 		      6
		 * 		   /     \ 
		 *        3       5
		 *       / \     / \
		 *      7   8   1   3
		 */
		root4 = new TreeNode(6);
		root4.left = new TreeNode(3);
		root4.right = new TreeNode(5);
		root4.left.left = new TreeNode(7);
		root4.left.right = new TreeNode(8);
		root4.right.left = new TreeNode(1);
		root4.right.right = new TreeNode(3);
	}
	
	static{
		/*
		 *          12
		 *         /  
		 *        5  
		 *       / \
		 *      3   9
		 *     /   /
		 *    1   2
		 *      
		 */
		root3 = new TreeNode(12);
		root3.left = new TreeNode(5);
		root3.left.left = new TreeNode(3);
		root3.left.left.left = new TreeNode(1);
		root3.left.right = new TreeNode(9);
		root3.left.right.left = new TreeNode(2);
	}
	
	static {
		/*
		 * 			1
		 * 		  /   \
		 *       2     3
		 *      /     / \
		 *     4     5   6
		 *            \   \
		 *             7   8
		 *            /     \
		 *           9      10
		 *                  /
		 *                 11
		 */
		root5 = new TreeNode(1);
		root5.left = new TreeNode(2);
		root5.right = new TreeNode(3);
		root5.left.left = new TreeNode(4);
		root5.right.left = new TreeNode(5);
		root5.right.right = new TreeNode(6);
		root5.right.left.right = new TreeNode(7);
		root5.right.left.right.left = new TreeNode(9);
		root5.right.right.right = new TreeNode(8);
		root5.right.right.right.right = new TreeNode(10);
		root5.right.right.right.right.left = new TreeNode(11);
	}
}
