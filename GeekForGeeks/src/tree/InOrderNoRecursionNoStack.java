package tree;

public class InOrderNoRecursionNoStack {
	
	public static void TraverseInChain(BinaryTree root){
		if(root == null)
			return ;
		
		BinaryTree tmp = root;
		while(tmp != null){
			if(root.left != null){
				tmp = root.left;
				root.left = null;
				BinaryTree node = FindRightMost.FindRightMost(root.left);
				node.right = root;
			}
			
			else{
				System.out.print(root.rootElement + " ");
				tmp = root;
			}
		}
	}
	
	public static void main(String[] args){
		BinaryTree root = new BinaryTree("A");
		root.left = new BinaryTree("B");
		root.right = new BinaryTree("G");
		root.left.left = new BinaryTree("C");
		root.left.right = new BinaryTree("F");
		root.left.left.left = new BinaryTree("E");
		root.left.left.right = new BinaryTree("D");
		
		TraverseInChain(root);
	}
}
