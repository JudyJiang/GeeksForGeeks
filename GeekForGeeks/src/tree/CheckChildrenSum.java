package tree;

/**
 * http://www.geeksforgeeks.org/check-for-children-sum-property-in-a-binary-tree/
 * @author FengjiaoJiang
 *
 */
public class CheckChildrenSum {
	public static boolean CheckSum(BinaryTree<Integer> root){
		if(root == null)
			return true;
		
		if(root.left == null && root.right == null)
			return true;
		
		if(root.left == null){
			//System.out.println(root.rootElement + " " + root.right.rootElement);
			return root.rootElement.equals(root.right.rootElement);
		}
		
		if(root.right == null)
			return root.rootElement.equals(root.left.rootElement);
		
		if(!root.rootElement.equals(root.left.rootElement + root.right.rootElement))
			return false;
		
		
		boolean leftCheck = CheckSum(root.left);
		if(!leftCheck){
			return false;
		}
		
		boolean rightCheck = CheckSum(root.right);
		if(!rightCheck){
			return false;
		}
		
		return true;
	}
	
	public static void main(String[] args){
		BinaryTree<Integer> root = new BinaryTree<Integer>(10);
		root.left = new BinaryTree<Integer>(8);
		root.left.left = new BinaryTree<Integer>(3);
		root.left.right = new BinaryTree<Integer>(2);
		root.right = new BinaryTree(2);
		root.right.right = new BinaryTree(2);
		System.out.print(CheckSum(root));
	}
}
