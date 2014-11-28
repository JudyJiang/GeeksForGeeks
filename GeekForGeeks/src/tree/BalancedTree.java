package tree;

public class BalancedTree {
	public static boolean checkBalance(BinaryTree root){
		if(checkBalanced(root) != -1)
			return true;
		
		return false;
	}
	
	public static int checkBalanced(BinaryTree root){
		if(root == null){
			return 0;
		}
		
		if(root.left == null && root.right == null)
			return 1;
		
		int left = checkBalanced(root.left);
		if(left == -1)
			return -1;
		
		int right = checkBalanced(root.right);
		if(right == -1)
			return -1;
		
		if(Math.abs(left - right) > 1)
			return -1;
		
		return Math.max(left, right) + 1;
	}
	
	public static void main(String[] args){
		BinaryTree root = new BinaryTree(1);
		//root.left = new BinaryTree(2);
		root.right = new BinaryTree(3);
		//root.left.left = new BinaryTree(4);
		//root.left.right = new BinaryTree(5);
		
		//root.left.right.left = new BinaryTree(6);
		root.right.right = new BinaryTree(7);
		
		System.out.print(checkBalance(root));
	}
}
