package utility;

import java.util.*;

public class test {
	
	public static void selectionSort(int[] arr){
		if(arr == null || arr.length == 0)
			return;
		
		for(int i = 0; i < arr.length; i++){
			int minIndex = i;
			for(int j = i; j < arr.length; j++){
				if(arr[j] < arr[minIndex]){
					minIndex = j;
				}
			}
			swap(arr, i, minIndex);
		}
	}
	
	public static void bubbleSort(int[] arr){
		if(arr == null || arr.length == 0)
			return ;
		
		for(int i = 0; i < arr.length; i++){
			for(int j = i + 1; j < arr.length; j++){
				if(arr[j] < arr[i])
					swap(arr, i, j);
			}
		}
	}
	
	public static void swap(int[] arr, int a, int b){
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
	
	
	/*
	 * lol~ I solved the merge sort by myself.
	 */
	public static void mergeSort(int[] arr){
		mergeSort(arr, 0, arr.length - 1);
	}
	
	public static void mergeSort(int[] arr, int l, int r){
		if(l < r){
			int m = l + (r - l) / 2;
			mergeSort(arr, l, m);
			mergeSort(arr, m + 1, r);
			merge(arr, l, m, r);
		}
	}
	
	public static void merge(int[] arr, int l, int m, int r){
		int size = r - l + 1;
		int[] tmp = new int[size];
		int i = l, j = m + 1, k = 0;
		while(i <= m && j <= r){
			if(arr[i] < arr[j]){
				tmp[k++] = arr[i++];
			}
			else if(arr[i] > arr[j]){
				tmp[k++] = arr[j++];
			}
			else{
				tmp[k++] = arr[i++];
				tmp[k++] = arr[j++];
			}
		}
		while(i <= m){
			tmp[k++] = arr[i++];
		}
		while(j <= r)
			tmp[k++] = arr[j++];
		
		for(int ii = 0; ii < size; ii++){
			arr[l+ii] = tmp[ii];
		}
	}
	/*************************************************/
	
	public static void quickSort(int[] arr){
		if(arr == null || arr.length == 0)
			return ;
		quickSort(arr, 0, arr.length - 1);
	}
	
	public static void quickSort(int[] arr, int l, int r){
		if(l < r){
			int p = partition(arr, l, r);

			if(l < p - 1)
				quickSort(arr, l, p - 1);
			if(r > p + 1)
				quickSort(arr, p + 1, r);       
		}
	}
	
	public static int partition(int[] arr, int l, int r){
		if(l >= r)
			return l - 1;
		int pivot = arr[(l + r) / 2];
		int i = l, j = r;
		
		while(i <= j){
			while(i <= j && arr[i] < pivot)
				i++;
			while(i <= j && arr[j] > pivot)
				j--;
			if(i <= j){
				swap(arr, i, j);
				i++;
				j--;
			}
			
		}
		return i - 1;
	}
	/*********************************************************/
	
	
	
	public static void bucketSort(int[] arr){
		
	}
	
	public static void main(String[] args){
		int[] arr = {64, 25, 12, 22, 11};
		quickSort(arr);
		for(int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		
		HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
		System.out.println(map.get(1));
		
	}
	
}
