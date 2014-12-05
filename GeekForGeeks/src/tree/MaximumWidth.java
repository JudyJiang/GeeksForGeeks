package tree;


import java.util.ArrayList;

public class MaximumWidth {
	public static int GetMaxWidth(BinaryTree root){
		if(root == null)
			return 0;
		
		int maxWidth = 1;
		ArrayList<BinaryTree> list = new ArrayList<BinaryTree>();
		list.add(root);
		list.add(null);
		
		int tmpWidth = 0;
		while(true){
			BinaryTree front = list.get(0);
			if(front == null){
				list.remove(0);
				if(list.size() == 0)
					break;
				list.add(null);
				if(tmpWidth > maxWidth)
					maxWidth = tmpWidth;
				tmpWidth = 0;
			}
			else{
				if(front.left != null){
					list.add(front.left);
					tmpWidth += 1;
				}
				
				if(front.right != null){
					list.add(front.right);
					tmpWidth += 1;
				}
				list.remove(0);
			}
		}
		
		System.out.println(maxWidth);
		return maxWidth;
	}
	
	public static int GetMaxNum(int[] arr){
		int max = arr[0];
		for(int i = 0; i < arr.length; i++){
			System.out.print(arr[i] + " ");
			if(arr[i] > max)
				max = arr[i];
		}
		return max;
	}
	
	public static int GetMaximumWidth(BinaryTree root){
		if(root == null)
			return 0;
		
		int height = TreeUtility.TreeHeight(root);
		int[] counter = new int[height];
		//System.out.println(GetMaximumWidth(root, counter, 0).toString());
		return GetMaxNum(GetMaximumWidth(root, counter, 0));
	}
	
	public static int[] GetMaximumWidth(BinaryTree root, int[] counter, int level){
		if(level > counter.length || root == null){
			return counter;
		}
		
		counter[level]++;
		GetMaximumWidth(root.left, counter, level + 1);
		GetMaximumWidth(root.right, counter, level + 1);
		return counter;
	}
	
	public static void main(String[] args){
		Integer[] values = {1, 2, 3, 4, 5, 8, 6, 7};
		String[] positions = {"left", "right", "left", "right", 
				null, "right", null, null, null, null, "left", "right"};
		BinaryTree root = CreateBinaryTree.CreateBinaryTree(values, positions);
		GetMaximumWidth(root);
	}
}
