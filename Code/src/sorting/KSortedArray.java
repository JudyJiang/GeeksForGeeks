package sorting;

/*
 * http://www.geeksforgeeks.org/nearly-sorted-algorithm/
 */
public class KSortedArray {
	//3, 4, 1, 5, 9, 2, 6
	//if use insertion sort, will need O(nk) 
	
	/*
	 * Build min-heap with the first K items (don't haev to worry if the first
	 * K are smallest cause every item is "k" distance sorted
	 * 
	 * Every time remove the top from the min-heap and use the next i the array
	 * This takes O(logK), overally O((N-K)*logK) +O(K) (for building min-heap)
	 */
	
	static class MinHeap{
		int[] arr;

		public MinHeap(int[] arr, int size){
			this.arr = arr;
			this.buildHeap();
		}
		
		public void buildHeap(){
			int size = this.arr.length;
			for(int i = size / 2; i >= 0; i--){
				this.minHeapify(i, size);
			}
		}
		
		public int extractMin(){
			int top = this.arr[0];
			int size = this.arr.length;
			while(size > 1){
				this.arr[0] = this.arr[size - 1];
				size--;
				this.minHeapify(0, size);
			}
			return top;
		}
		
		public int replaceMin(int x){
			int top = this.arr[0];
			this.arr[0] = x;
			if(top < x){
				this.minHeapify(0, this.arr.length);
			}
			return top;
		}
		
		public void minHeapify(int index, int size){
			int left = 2*index + 1;
			int right= 2 * index + 2;
			int smallest = index;
			if(left < size && this.arr[left] < this.arr[smallest])
				smallest = left;
			if(right < size && this.arr[right] < this.arr[smallest])
				smallest = right;
			
			if(smallest != index){
				this.swap(smallest, index);
				this.minHeapify(smallest, size);
			}
		}
		
		public void swap(int a, int b){
			int t = this.arr[a];
			this.arr[a] = this.arr[b];
			this.arr[b] = t;
		}
	}
	
	
	public void sortK(int[] arr, int k){
		int[] res = new int[k + 1];
		for(int i = 0; i <= k && i < arr.length; i++){
			res[i] = arr[i];
		}
		
		MinHeap heap = new MinHeap(res, k + 1);
		for(int i = k + 1, j = 0; j < arr.length; i++, j++){
			if(i < arr.length){
				arr[j] = heap.replaceMin(arr[i]);
			}
			else{//process the last K in the min-heap (thought now the last K largest values
				arr[j] = heap.extractMin();
			}
		}
	}
}
