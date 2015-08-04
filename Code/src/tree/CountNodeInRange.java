package tree;
import utility.*;


public class CountNodeInRange {
	public static int countRangeNodes(TreeNode root, int[] range){
		if(root == null)
			return 0;
		int res = 0;
		if(root.val > range[1]){
			res = countRangeNodes(root.left, range);
		}
		
		else if(root.val < range[0]){
			res = countRangeNodes(root.right, range);
		}
		
		else if(root.val <= range[1] && root.val >= range[0]){
			res++;
			res += countRangeNodes(root.left, range);
			res += countRangeNodes(root.right, range);
		}
		
		return res;
	}
	
	public static void main(String[] args){
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(50);
		root.left.left = new TreeNode(1);
		root.right.left = new TreeNode(40);
		root.right.right = new TreeNode(100);
		System.out.println(countRangeNodes(root, new int[]{5, 45}));
	}
}
