package tree;

public class CheckBinaryTree {
	public static boolean IsBST(BinaryTree<Integer> root){
		if(root == null)
			return true;
		
		return IsBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	public static boolean IsBST(BinaryTree<Integer> root, int min, int max){
		if(root == null)
			return true;
		
		if(root.rootElement <= min || root.rootElement >= max)
			return false;
		
		return IsBST(root.left, min, root.rootElement) && IsBST(root.right, root.rootElement, max);
	}
	
	public static void main(String[] args){
		Integer[] array ={1, 2, 3, 4, 5};
		BinaryTree<Integer> root = TreeUtility.TreeFromArray(array);
		System.out.println(IsBST(root));
		root.rootElement = 19;
		System.out.println(IsBST(root));
	}
}
