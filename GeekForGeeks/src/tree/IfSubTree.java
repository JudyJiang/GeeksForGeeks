package tree;

public class IfSubTree {

	public static boolean IsSubTree(BinaryTree root, BinaryTree node){
		if(root == null && node == null){
			return true;
		}

		else if(root == null || node == null){
			return false;
		}

		else if(root.rootElement == node.rootElement){
			boolean matchOnce =  MatchSubTree(root, node);
			if(matchOnce){
				return true;
			}
		}

		return IsSubTree(root.left, node) || IsSubTree(root.right, node);
	}

	public static boolean MatchSubTree(BinaryTree root, BinaryTree node){
		if(root == null && node == null){
			return true;
		}

		if(root == null || node == null){
			return false;
		}

		if(root.rootElement != node.rootElement){
			return false;
		}

		return MatchSubTree(root.left, node.left) && MatchSubTree(root.right, node.right);
	}

	public static void main(String[] args){
		BinaryTree root = TreeUtility.GetSampleTree();
		BinaryTree node1 = root.left.right;
		BinaryTree node2 = new BinaryTree(root.right.right.rootElement);
		node2.left = new BinaryTree(23);
		node2.right = new BinaryTree(1);

		System.out.println(IsSubTree(root, node1));
		System.out.println(IsSubTree(root, node2));

	}
}
