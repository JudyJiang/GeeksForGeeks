import utility.*;

public class FlattenBinaryTreeToLinkedList {
	public static TreeNode findRightNode(TreeNode root){
		if(root == null)
			return root;
		
		TreeNode curr = root;
		while(curr.right != null){
			curr = curr.right;
		}
		return curr;
	}
	
	public static void flatten(TreeNode root){
		if(root == null || (root.left == null && root.right == null))
			return ;
		
		TreeNode curr = root;
		while(curr != null){
			TreeNode right = curr.right;
			if(curr.left != null){
				TreeNode leftRight = findRightNode(curr.left);
				leftRight.right = right;
				curr.right = curr.left;
				curr.right = curr.left;
				curr.left = null;
			}
			curr = curr.right;
		}
	}
	
	public static void main(String[] args){
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.right = new TreeNode(6);
		
//		TreeNode res = findRightNode(root.left.left);
//		System.out.println(res.val);
		flatten(root);
		while(root != null){
			System.out.println(root.val);
			root = root.left;
		}
	}
}
