package tree;

public class InPreOrderTree {
	private static int preIndex = 0;
	
	public static BinaryTree PreInTree(char[] in, char[] pre){
		return PreInTree(in, pre,0, pre.length);
	}
	
	public static BinaryTree PreInTree(char[] in, char[] pre, int start, int end){
		if(start >= end){
			return null;
		}
		
		BinaryTree root = new BinaryTree(pre[preIndex++]);
		int searchIndex = Search(in, start,end, (Character)(root.rootElement));
		

		/*
		 * This step if very important. Otherwise will be null forever.
		 */
		 if(searchIndex == -1)
		 return root;
		
		root.left = PreInTree(in, pre,start, searchIndex);
		root.right = PreInTree(in, pre, searchIndex + 1, end);//This step is wrong cause can't jump to the "E"
		
		
		return root;
		
	}
	
	public static int Search(char[] list, int start, int end, char value){
		for(int i = start; i <= end; i++)
			if(list[i] == value)
				return i;
		
		return -1;
	}
	
	
	public static void main(String[] args){
		char[] in = {'D', 'B', 'E', 'A', 'F', 'C'};
		char[] pre = {'A', 'B', 'D', 'E', 'C', 'F'};
		
		BinaryTree root = PreInTree(in, pre);
		System.out.println(root.rootElement);
		System.out.println(root.left.rootElement + " " + root.right.rootElement);
		System.out.println(root.left.left.rootElement + " " +  root.left.right.rootElement);
		System.out.println(root.right.left.rootElement);
	}
}
