package tree;

/**
 * http://www.geeksforgeeks.org/write-a-c-program-to-calculate-size-of-a-tree/
 * Number of Nodes of a Tree
 * Easy Piece
 * @author FengjiaoJiang
 *
 */
public class GetTreeSize {
	
	public static int GetSize(BinaryTree root){
		if(root == null)
			return 0;
		
		if(root.left == null && root.right == null)
			return 1;
		
		return GetSize(root.left) + GetSize(root.right) + 1;
	}
	
	public static BinaryTree GetSimpleTree(){
		BinaryTree root = new BinaryTree(1);
		root.left = new BinaryTree(2);
		root.right = new BinaryTree(3);
		root.left.left = new BinaryTree(4);
		root.left.right = new BinaryTree(5);
		return root;
	}
	
	public static void main(String[] args){
		BinaryTree root = new BinaryTree(1);
		root.left = new BinaryTree(2);
		root.right = new BinaryTree(3);
		root.left.left = new BinaryTree(4);
		root.left.right = new BinaryTree(5);
		System.out.println(GetSize(root));
	}
}
