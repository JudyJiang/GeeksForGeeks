package tree;

/**
 * http://www.geeksforgeeks.org/write-a-c-program-to-get-count-of-leaf-nodes-in-a-binary-tree/
 * Easy Piece
 * @author FengjiaoJiang
 *
 */
public class CountLeafNode {
	public static int CountLeaf(BinaryTree root){
		if(root == null)
			return 0;
		
		if(root.left == null && root.right == null)
			return 1;
		
		return CountLeaf(root.left) + CountLeaf(root.right);
	}
	
	public static void main(String[] args){
		BinaryTree root1 = TreeUtility.GetSampleTree();//GetTreeSize.GetSimpleTree();
		System.out.println(CountLeaf(root1));
	}
}
