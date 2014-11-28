package tree;

public class FindRightMost {
	
	public static BinaryTree FindRightMost(BinaryTree root){
		if(root.right == null)
			return root;
		
		return FindRightMost(root.right);
	}
}
