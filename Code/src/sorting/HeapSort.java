package sorting;

//This is maximum heap, from bottom up
public class HeapSort {
	static class MaxHeap{
		int[] arr;
		
		
		public MaxHeap(int[] array){
			this.arr = array;
		}
		
		public void swap(int a, int b){
			int t = this.arr[a];
			this.arr[a] = this.arr[b];
			this.arr[b] = t;
		}
		
		public void maxHeapify(int index, int size){
			int left = (index << 1) + 1;
			int right = (index + 1) << 1;
			int largest = index;
			
			
			if(left < size && this.arr[left] > this.arr[largest])
				largest = left;
			
			if(right < size && this.arr[right] > this.arr[largest])
				largest = right;
			
			if(largest != index){
				//System.out.println(this.arr[largest] + " " + this.arr[index]);
				this.swap(index,  largest);
				this.maxHeapify(largest, size);
			}
		}
		
		
		//this is to build a max heap, not yet sorted.
		public void buildHeap(){
			//start in the middle of the array
			int size = this.arr.length;
			int[] maxHeap = new int[size];
			for(int i = size / 2; i >= 0; i--){
				this.maxHeapify(i, size);
			}
		}
		
		public void heapSort(int[] arr){
			//remove largest item and put it to the end
			MaxHeap maxHeap = new MaxHeap(arr);
			int size = maxHeap.arr.length;
			while(size > 1){
				maxHeap.swap(0, size - 1);
				size--;
				maxHeap.maxHeapify(0, size);
			}
		}
	}
	
	public static void main(String[] args){
		int[] arr = {12, 11, 13, 5, 6, 7};
		MaxHeap x = new MaxHeap(arr);
		x.buildHeap();
		for(int i = 0; i < x.arr.length; i++){
			System.out.print(x.arr[i] + " ");
		}
	}
}
