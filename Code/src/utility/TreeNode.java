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
	
	
}
