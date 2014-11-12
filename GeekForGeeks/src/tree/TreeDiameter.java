package tree;

public class TreeDiameter {
	public static BinaryTree tree1;
	public static BinaryTree tree2;

	static {
		tree1 = new BinaryTree(1);
		tree1.left = new BinaryTree(2);
		tree1.right = new BinaryTree(3);
		tree1.left.left = new BinaryTree(4);
		tree1.left.right = new BinaryTree(5);
	}

	static {
		tree2 = new BinaryTree(1);
		tree2.left = new BinaryTree(2);
		tree2.right = new BinaryTree(3);
		tree2.left.left = new BinaryTree(4);
		tree2.left.right = new BinaryTree(5);
		
		tree2.left.left.left = new BinaryTree(6);
		tree2.left.left.right = new BinaryTree(7);
		tree2.left.left.right.left = new BinaryTree(9);
		tree2.left.left.right.left.left = new BinaryTree(12);
		tree2.left.left.right.left.right = new BinaryTree(13);
		
		tree2.left.right.right = new BinaryTree(8);
		tree2.left.right.right.left = new BinaryTree(10);
		tree2.left.right.right.right = new BinaryTree(11);
		tree2.left.right.right.right.right = new BinaryTree(14);
		
		tree2.right.right = new BinaryTree(15);
	}

	public static int GetTreeDiameterOptimized(BinaryTree root) {
		//Use a container to contain the height (both left and right.. and max..?)
		return 0;
	}

	public static int GetTreeDiameter(BinaryTree root){
		if(root == null){
			return 0;
		}

		int left = TreeUtility.TreeHeight(root.left);
		int right = TreeUtility.TreeHeight(root.right);

		int lDia = GetTreeDiameter(root.left);
		int rDia = GetTreeDiameter(root.right);

		return Math.max((Math.max(lDia, rDia)), (left + right + 1));
	}


	public static void main(String[] args) {
		//System.out.println(GetTreeDiameter(TreeDiameter.tree1));
		System.out.println(GetTreeDiameter(TreeDiameter.tree2));
		
	}
}
