package tree;

import java.util.Stack;

public class TreeInOrderNoRecursion {
	
	public static void InOrderTraverseNoRecursion(BinaryTree root){
		if(root == null)
			return ;
		
		Stack<BinaryTree> s = new Stack<BinaryTree>();
		s.push(root);
		boolean pushRight = false;
		
		while(!s.isEmpty()){
			BinaryTree top = s.peek();
			if(top == null){
				s.pop();
				pushRight = true;
			}
			
			else{
				if(pushRight){
					System.out.print(top.rootElement + " ");
					s.pop();
					s.push(top.right);
					pushRight = false;
				}
				else{
					s.push(top.left);
				}
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
		
		InOrderTraverseNoRecursion(root);
	}
}
