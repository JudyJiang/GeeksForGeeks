package tree;


/**
 * http://www.geeksforgeeks.org/find-the-minimum-element-in-a-binary-search-tree/
 * Not exactly the same version, but, yeah...
 *
 * @author FengjiaoJiang
 *
 */
public class MinimumTreeNode {
	public static BinaryTree<Integer> MinimumNode(BinaryTree<Integer> root){
		if(root == null)
			return root;
		
		return MinimumNode(root, root);
	}
	
	public static BinaryTree<Integer> MinimumNode(BinaryTree<Integer> root, BinaryTree<Integer> node){
		if(root == null)
			return node;
		
		BinaryTree<Integer> left = MinimumNode(root.left, node);
		BinaryTree<Integer> right = MinimumNode(root.right, node);
		
		BinaryTree<Integer> tmp1 = left.rootElement > right.rootElement ? right : left;
		BinaryTree<Integer> tmp2 = root.rootElement > tmp1.rootElement ? tmp1 : root;
		node = node.rootElement > tmp2.rootElement ? tmp2 : node;
		//System.out.println(left.rootElement + " " + right.rootElement+ " " + node.rootElement);
		return node;
	}
	
	public static void main(String[] args){
		BinaryTree<Integer> root = TreeUtility.GetSampleTree();
		System.out.println(MinimumNode(root).rootElement);
	}
}
