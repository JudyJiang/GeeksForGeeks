/*
 * This is very similar to Merge K Sorted List
 * Both use the first element of the list or array
 * then use another collection structure and "compare to" method
 * use the heap sort
 */
import java.util.*;

public class MergeKSortedArray {
	static class ArrayContainer implements Comparable<ArrayContainer>{
		int index;
		int[] arr;
		
		public ArrayContainer(int[] arr, int index){
			this.index = index;
			this.arr = arr;
		}

		public int compareTo(ArrayContainer o) {
			if(this.arr[this.index] > o.arr[o.index])
				return 1;
			else if(this.arr[this.index] < o.arr[o.index])
				return -1;
			
			return 0;
		}
	}
	
	
	public static int[] mergeKSortedArray(int[][] arr){
		PriorityQueue<ArrayContainer> queue = new PriorityQueue<ArrayContainer>();
		int totalLen = 0;
		
		for(int i = 0; i < arr.length; i++){
			ArrayContainer tmp = new ArrayContainer(arr[i], 0);
			queue.add(tmp);
			totalLen += arr[i].length;
		}
		
		int[] result = new int[totalLen];
		int index = 0;
		while(!queue.isEmpty()){
			ArrayContainer tmp = queue.poll();
			result[index++] = tmp.arr[tmp.index];
			if(tmp.index < tmp.arr.length - 1)
				queue.add(new ArrayContainer(tmp.arr, tmp.index + 1));
		}
		
		return result;
	}
}
