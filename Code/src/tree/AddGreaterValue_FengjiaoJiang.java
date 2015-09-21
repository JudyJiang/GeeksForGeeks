package tree;

import utility.TreeNode;
/**
 * ...In java, this int[] is really important to replace the pointer in C++...
 * @author FengjiaoJiang
 *
 */
public class AddGreaterValue_FengjiaoJiang {
	public static void addGreaterValue(TreeNode root){
		int[] added = new int[1];
		addGreaterValue(root, added);
	}
	
	public static int addGreaterValue(TreeNode root, int[] addValue){
		if(root == null)
			return 0;
		
		int greater = addGreaterValue(root.right, addValue);
		root.val = root.val + addValue[0] + greater;
		addValue[0] = root.val;
		int next = addGreaterValue(root.left, addValue);
		addValue[0] = 0;
		return root.left == null ? root.val : root.left.val;
	}
	
	public static void main(String[] args){
		TreeNode root = new TreeNode(50);
		root.left = new TreeNode(30);
		root.right = new TreeNode(70);
		root.left.left = new TreeNode(20);
		root.left.right = new TreeNode(40);
		root.right.left = new TreeNode(60);
		root.right.right = new TreeNode(80);
		addGreaterValue(root);
		System.out.println(root.val);
		System.out.println(root.left.val);
		System.out.println(root.right.val);
		System.out.println(root.left.left.val);
		System.out.println(root.left.right.val);
		System.out.println(root.right.left.val);
		System.out.println(root.right.right.val);
	}
}
