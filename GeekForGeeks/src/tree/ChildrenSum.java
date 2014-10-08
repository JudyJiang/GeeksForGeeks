package tree;

/**
 * http://www.geeksforgeeks.org/check-for-children-sum-property-in-a-binary-tree/
 * @author FengjiaoJiang
 *
 */
public class ChildrenSum {
	public static boolean CheckSum(BinaryTree root){
		if(root == null)
			return true;
		
		if(root.left == null && root.right == null)
			return true;
		
		int left = (Integer) (root.left == null ? 0 : root.left.rootElement);
		int right = (Integer)(root.right == null ? 0 : root.right.rootElement);
		
		if(left + right != (Integer)root.rootElement){
		//	System.out.print((left + right) + " " + root.rootElement);
			return false;
		}
		
		return CheckSum(root.left) && CheckSum(root.right);
	}
	
	public static void main(String[] args){
		BinaryTree root = new BinaryTree(10);
		root.left = new BinaryTree(8);
		root.right = new BinaryTree(2);
		root.left.left = new BinaryTree(3);
		root.left.right = new BinaryTree(5);
		root.right.left = new BinaryTree(1);
		System.out.println(CheckSum(root));
	}
}
