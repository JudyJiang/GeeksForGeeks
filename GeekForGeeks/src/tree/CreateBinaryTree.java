package tree;

import java.util.List;
import java.util.LinkedList;
import java.util.Comparator;

public class CreateBinaryTree{

	//1, 2, 3, 4, 5, 8, 6, 7
	//root, one position corresponding to a number, null means no
	//1        2       3          4      5                  8
	//root    left    right     left     right    null    right
	public static<T extends Comparable<T>> BinaryTree<T> CreateBinaryTree(T[] values, String[] positions){
		if(values == null || values.length == 0)
			return null;
		
		BinaryTree<T> root = new BinaryTree<T>(values[0]);
		LinkedList<BinaryTree> list = new LinkedList<BinaryTree>();
		list.add(root);
		int start = 1, j = 0, len1 = values.length, len2 = positions.length;
		for(; j < len2;){
			BinaryTree tmp = list.removeFirst();
			String leftPos = positions[j++];
			String rightPos = positions[j++];
			tmp.left = leftPos == null ? null : new BinaryTree(values[start++]);
			tmp.right = rightPos == null ? null : new BinaryTree(values[start++]);
			if(tmp.left != null)
				list.add(tmp.left);
			if(tmp.right != null)
				list.add(tmp.right);
		}
		return root;
	}
	
	public static void main(String[] args){
		Integer[] values = {1, 2, 3, 4, 5, 8, 6, 7};
		String[] positions = {"left", "right", "left", "right", 
				null, "right", null, null, null, null, "left", "right"};
		BinaryTree root = CreateBinaryTree(values, positions);
		System.out.println(root.right.right.right.rootElement);
	}
	
}
