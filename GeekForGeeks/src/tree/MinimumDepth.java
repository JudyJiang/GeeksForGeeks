package tree;

/**
 * http://www.geeksforgeeks.org/write-a-c-program-to-find-the-maximum-depth-or-height-of-a-tree/
 * Only be careful the two conditions (if)
 * @author FengjiaoJiang
 *
 */
public class MinimumDepth {
	public static int MinimumDepth(BinaryTree root){
		if(root == null)
			return 0;
		
		if(root.left == null && root.right == null)
			return 1;
		
		//int left = 0, right = 0;
		if(root.left == null)
			return MinimumDepth(root.right) + 1;
		
		if(root.right == null)
			return MinimumDepth(root.left) + 1;
		
		return Math.min(MinimumDepth(root.left), MinimumDepth(root.right)) + 1;
	}
	
	public static void main(String[] args){
		BinaryTree root = TreeUtility.GetSampleTree();
		System.out.println(MinimumDepth(root));
	}
}
