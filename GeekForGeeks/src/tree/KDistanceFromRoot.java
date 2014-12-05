package tree;

public class KDistanceFromRoot {
	public static void PrintNodeKDistanceFromRoot(BinaryTree root, int k){
		if(root == null)
			return ;
		
		PrintNodeKDistanceFromRoot(root, 0, k);
	}
	
	public static void PrintNodeKDistanceFromRoot(BinaryTree root, int level, int k){
		if(root == null || level > k){
			return ;
		}
		
		if(level == k){
			System.out.print(root.rootElement + " ");
			return ;
		}
		
		PrintNodeKDistanceFromRoot(root.left, level + 1, k);
		PrintNodeKDistanceFromRoot(root.right, level + 1, k);
	}
	
	public static void main(String[] args){
		Integer[] values = {1, 2, 3, 4, 5, 8};
		String[] positions = {"left", "right", "left", "right", "left", null};
		BinaryTree root = CreateBinaryTree.CreateBinaryTree(values, positions);
		PrintNodeKDistanceFromRoot(root, 2);
	}
}
