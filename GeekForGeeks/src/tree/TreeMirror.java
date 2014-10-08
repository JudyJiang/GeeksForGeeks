package tree;

/**
 * http://www.geeksforgeeks.org/write-an-efficient-c-function-to-convert-a-tree-into-its-mirror-tree/
 * Ah, Happy.
 * @author FengjiaoJiang
 *
 */
public class TreeMirror {
	public static BinaryTree GetMirror(BinaryTree root){
		if(root == null)
			return null;
		
		if(root.left == null && root.right == null)
			return root;
		
		BinaryTree left = GetMirror(root.left);
		BinaryTree right = GetMirror(root.right);
		
		BinaryTree t = left;
		root.left = right;
		root.right = left;
		
		return root;
	}
	
	public static void main(String[] args){
		BinaryTree root = new BinaryTree(1);
		root.left = new BinaryTree(2);
		root.right = new BinaryTree(3);
		root.left.left = new BinaryTree(4);
		root.left.right = new BinaryTree(5);
		
		BinaryTree rootNew = GetMirror(root);
	}
}
