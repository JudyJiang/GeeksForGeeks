package utility;

public class TreeNode {
	public int val; 
	public TreeNode left;
	public TreeNode right;
	
	public TreeNode(){
		this.left = this.right = null;
	}
	
	public TreeNode(int val){
		this();
		this.val = val;	
	}
	
	public int getTreeNodeNumber(){
		if(this == null)
			return 0;
		if(this.left == null && this.right == null)
			return 1;
		
		int left = this.left == null ? 0 : this.left.getTreeNodeNumber();
		int right = this.right == null ? 0 : this.right.getTreeNodeNumber();
		return left + right + 1;
	}
}
