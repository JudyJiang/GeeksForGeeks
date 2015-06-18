import utility.*;


public class ConvertSortedArraytoBST {
	public static TreeNode sortedArrayToBST(int[] nums){
		if(nums == null || nums.length == 0)
			return null;
		
		return sortedArrayToBST(nums, 0, nums.length);
	}
	
	public static TreeNode sortedArrayToBST(int[] nums, int left, int right){
		if(left >= right)
			return null;
		
		int mid = (left + right) / 2;
		TreeNode root = new TreeNode(nums[mid]);
		
		root.left = sortedArrayToBST(nums, left, mid);
		root.right = sortedArrayToBST(nums, mid + 1, right);
		return root;
	}
}
