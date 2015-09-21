package tree;


import utility.TreeNode;
/**
 * Done, so happy.
 * @author FengjiaoJiang
 *
 */
public class CorrectTree_FengjiaoJiang {
	public static void correctBST(TreeNode root){
		TreeNode[] wrongs = new TreeNode[2];
		correctBST(root, wrongs);
		int tmp = wrongs[0].val;
		wrongs[0].val = wrongs[1].val;
		wrongs[1].val = tmp;
	}
	
	
	public static TreeNode correctBST(TreeNode root, TreeNode[] wrongs){
		if(root == null)
			return null;
		
		TreeNode left = correctBST(root.left, wrongs);
		if(left != null && left.val > root.val){
			if(wrongs[0] == null){
				wrongs[0] = left;
			}
			else{
				wrongs[1] = left;
			}
		}
		TreeNode right = correctBST(root.right, wrongs);
		if(right != null && right.val < root.val){
			if(wrongs[0] == null){
				wrongs[0] = right;
			}
			else{
				wrongs[1] = right;
			}
		}
		return right == null ? root : right;
	}
	
	public static void main(String[] args){
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(20);
		correctBST(root);
		System.out.println(root.val);
		System.out.println(root.left.val + " " + root.right.val);
		System.out.println(root.left.left.val + " " + root.left.right.val);
	}
}
