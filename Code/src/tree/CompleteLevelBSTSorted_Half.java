package tree;


import utility.TreeNode;
/**
 * Partially solved the problem. ....
 * @author FengjiaoJiang
 *
 */
public class CompleteLevelBSTSorted_Half {
	
	public static void printSortedOrder(int[] tree){
		printSortedOrder(tree, 0);
	//	printSortedOrder(tree, 0, tree.length - 1);
	}
	
	public static void printSortedOrder(int[] tree, int level){
		if(level >= tree.length || 2 * level + 1 >= tree.length)
			return;
		
		printSortedOrder(tree, level + 1);
		int left = 2 * level + 1;
		if(left < tree.length && tree[left] != -1){
			System.out.print(tree[left] + " ");
			tree[left] = -1;
		}
		if(tree[level] != -1){
			System.out.print(tree[level] + " ");
			tree[level] = -1;
		}
		int right = 2 * level + 2;
		if(right < tree.length && tree[right] != -1){
			System.out.print(tree[right] + " ");
			tree[right] = -1;
		}
	}
	
	public static void printSortedOrder(int[] tree, int start, int end){
		if(start > end)
			return;
		
		printSortedOrder(tree, 2 * start + 1, end);
		System.out.print(tree[start] + " ");
		printSortedOrder(tree, 2 * start + 2, end);
	}
	
	public static void main(String[] args){
		int[] tree = {4, 2, 7, 1, 3};
		printSortedOrder(tree);
	}
}
