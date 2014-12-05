package tree;

//http://www.geeksforgeeks.org/sorted-order-printing-of-an-array-that-represents-a-bst/

import java.util.ArrayList;

public class PrintBSTSortedOrder {
	public static void GetSortedOrderPrint(int[] arr){
		if(arr == null || arr.length == 0)
			return ;
		
		BinaryTree root = new BinaryTree(arr[0]);
		ArrayList<BinaryTree> list = new ArrayList<BinaryTree>();
		list.add(root);
		int i = 0;
		
		while(i < arr.length && !list.isEmpty()){
			
		}
	}
}
