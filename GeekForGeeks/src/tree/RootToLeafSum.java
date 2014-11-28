package tree;

public class RootToLeafSum {
	public static boolean RootLeafSum(BinaryTree<Integer> root, int sum){
		if(root == null && sum != 0){
			return false;
		}
		
		if(root == null && sum == 0){
			return true;
		}
	
		return RootLeafSum(root, sum, 0);
	}
	
	public static boolean RootLeafSum(BinaryTree<Integer> root, int sum, int value){
		if(root == null){
			if(sum == value)
				return true;
			return false;
		}
		
		return RootLeafSum(root.left, sum, value + root.rootElement) ||
				RootLeafSum(root.right, sum, value + root.rootElement);
	}
	
	public static void main(String[] arg){
		BinaryTree root = new BinaryTree(10);
		root.left = new BinaryTree(8);
		root.right = new BinaryTree(2);
		root.left.left = new BinaryTree(3);
		root.left.right = new BinaryTree(5);
		root.right.left = new BinaryTree(2);
		
		System.out.println(RootLeafSum(root, 18));
	}
}
