package tree;

import java.util.Stack;

public class SpiritalTreeTravel {
	
	/**
	 * My method. Kind of ... not very well but the one pushed online is not much etter?
	 * @param root
	 */
	public static void SpiritalTraverse(BinaryTree root){
		if(root == null || (root.left == null && root.right == null))
			return ;
		
		Stack<BinaryTree> s1 = new Stack<BinaryTree>();
		Stack<BinaryTree> s2 = new Stack<BinaryTree>();
		
		boolean leftToRight = true;
		
		s1.push(root);
		
		while(true){
			BinaryTree top = s1.pop();
			
			System.out.print(top.rootElement + " ");
			if(s2.isEmpty()){
				leftToRight = !leftToRight;
			}
			
			if(leftToRight){
				if(top.left != null)
					s2.push(top.left);
				if(top.right != null)
					s2.push(top.right);
			}
			
			else{
				if(top.right != null)
					s2.push(top.right);
				if(top.left != null)
					s2.push(top.left);
			}
			
			if(s1.isEmpty()){
				if(s2.isEmpty()){
					break;
				}
				else{
					s1 = s2;
					s2 = new Stack<BinaryTree>();
				}
			}
		}
	}
	
	public static void SpiralTraverse(BinaryTree root){
		if(root == null || (root.left == null && root.right == null))
			return ;
		
		Stack<BinaryTree> s1 = new Stack<BinaryTree>();
		Stack<BinaryTree> s2 = new Stack<BinaryTree>();
		
		s1.push(root);
		
		
		while(!s1.isEmpty() || !s2.isEmpty()){
			while(!s1.isEmpty()){
				BinaryTree top = s1.pop();
				System.out.print(top.rootElement + " ");
				if(top.right != null)
					s2.push(top.right);
				if(top.left != null)
					s2.push(top.left);
			}
			
			while(!s2.isEmpty()){
				BinaryTree top = s2.pop();
				System.out.print(top.rootElement + " ");
				if(top.left != null)
					s1.push(top.left);
				if(top.right != null)
					s1.push(top.right);
			}
		}
		System.out.println();
	}
	
	
	/**
	 * It's a recursive method
	 * @param args
	   @author FengjiaoJiang
	 */
	public static void PrintSpiralTree(BinaryTree root){
		if(root == null || (root.left == null && root.right == null))
			return ;
		
		int height = TreeUtility.TreeHeight(root);
		System.out.println(height);
		boolean leftToRight = false;
		
		for(int i = 1; i < height; i++){
			PrintSpiralTree(root, i, leftToRight);
			leftToRight = !leftToRight;
		}
	}
	
	public static void PrintSpiralTree(BinaryTree root, int level, boolean order){
		if(root == null)
			return ;
		
		if(level == 1)
			System.out.print(root.rootElement + " ");
		
		if(level > 1){
			if(order){
				PrintSpiralTree(root.left, level - 1, order);
				PrintSpiralTree(root.right, level - 1, order);
			}
			
			else{
				PrintSpiralTree(root.right, level - 1, order);
				PrintSpiralTree(root.left, level - 1, order);  
			}
		}
	}
	
	public static void main(String[] args){
		BinaryTree root = TreeUtility.GetSampleTree();
	   //SpiritalTraverse(root);
		//SpiralTraverse(root);
		PrintSpiralTree(root);
	}
}
