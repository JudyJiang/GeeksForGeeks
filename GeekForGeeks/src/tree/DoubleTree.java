package tree;

public class DoubleTree {
	
	public static void CreateDoubleTree(BinaryTree root){
		if(root == null)
			return ;
		
		CreateDoubleTree(root.left);
		BinaryTree node = new BinaryTree(root.rootElement);
		node.left = root.left == null ? null : root.left;
		root.left = node;
		CreateDoubleTree(root.right);
	}
	
	
	public static void main(String[] args){
		BinaryTree root = new BinaryTree(2);
		root.left = new BinaryTree(1);
		root.right = new BinaryTree(3);
		CreateDoubleTree(root);
		TreeUtility.TraverseTreeLeverOrder(root);
	}
}
