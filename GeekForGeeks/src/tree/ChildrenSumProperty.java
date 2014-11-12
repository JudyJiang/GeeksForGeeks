package tree;

public class ChildrenSumProperty {
	/**
	 * The most important part is 
	 * 1. Post order traverse.
	 * 2. This algorithm
	 * @param root
	   @author fengjiaojiang
	 */
	public static void FixTreeSum(BinaryTree<Integer> root) {
		if (root == null)
			return;

		if (root.left == null && root.right == null)
			return;

		FixTreeSum(root.left);
		FixTreeSum(root.right);

		int value = (root.left == null ? 0 : root.left.rootElement)
				+ (root.right == null ? 0 : root.right.rootElement);

		if (value == root.rootElement)
			return;

		if (value > root.rootElement)
			root.rootElement = value;

		else {
			int leftValue = root.rootElement
					- (root.right == null ? 0 : root.right.rootElement);
			
			if(root.left != null){
				root.left.rootElement = leftValue;
				FixTreeSum(root.left);
			}
			else{
				root.right.rootElement = leftValue;
				FixTreeSum(root.right);
			}
		}
	}
	
	public static void main(String[] args){
		BinaryTree root = new BinaryTree(50);
		root.left = new BinaryTree(8);
		root.right = new BinaryTree(2);
		root.left.left = new BinaryTree(3);
		root.left.right = new BinaryTree(5);
		root.right.left = new BinaryTree(1);
		root.right.right = new BinaryTree(30);
		
		FixTreeSum(root);
		System.out.println(root.rootElement);
		System.out.println(root.left.rootElement);
		System.out.println(root.right.rootElement);
		System.out.println(root.left.left.rootElement);
		System.out.println(root.left.right.rootElement);
		System.out.println(root.right.left.rootElement);
		System.out.println(root.right.right.rootElement);
	}
}
