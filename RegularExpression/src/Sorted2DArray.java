/**
 * A = [["a", 1], ["b", 2]] sorted all elements have different names 
 * B = [["a",2], ["c", 3]] sorted 
 * C = [["a", 3], ["b", 2], ["c", 3]] sorted
 * 
 * @author FengjiaoJiang
 * 
 */
import java.util.List;
import java.util.ArrayList;

public class Sorted2DArray {
	public static class Array{
		char character;
		int number;
		
		public Array(char c, int n){
			this.character = c;
			this.number = n;
		}
	}
	
	public static void Print2DArray(List<Array> list){
		for(int i = 0; i < list.size(); i++){
			System.out.print(list.get(i).character + " " + list.get(i).number + "\n");
		}
	}
	
	public static Array[] Get2DArray(char[] charArray, int[] intArray){
		if(charArray.length != intArray.length)
			return null;
		
		int size = charArray.length;
		Array[] array = new Array[size];
		
		for(int i = 0; i < size; i++){
			array[i] = new Array(charArray[i], intArray[i]);
		}
		
		return array;
	}
	
	public static List<Array> Sort2DArray(Array[] arr1, Array[] arr2){
		int i = 0, j = 0, size1 = arr1.length, size2 = arr2.length;
		List<Array> sortedList = new ArrayList<Array>();
		Array tempArray;
		while(i < size1 && j < size2){
			//System.out.println(i + " " + j);
			if(arr1[i].character < arr2[j].character){
				tempArray = new Array(arr1[i].character, arr1[i].number);
				i++;
			}
			
			else if(arr1[i].character > arr2[j].character){
				tempArray = new Array(arr2[j].character, arr2[j].number);
				j++;
			}
			
			else{
				tempArray = new Array(arr1[i].character, (arr1[i].number + arr2[j].number));
				i++;
				j++;
			}
			sortedList.add(tempArray);
		}
		
		if(i < size1){
			for(int k = i; k < size1; k++){
				tempArray = new Array(arr1[k].character, arr1[k].number);
				sortedList.add(tempArray);
			}
			return sortedList;
		}
		
		else if(j < size2){
			for(int k = j; k < size2; k++){
				tempArray = new Array(arr2[k].character, arr2[k].number);
				sortedList.add(tempArray);
			}
			return sortedList;
		}
		
		return sortedList;
	}
	
	
	public static void run(){
		char[] charArrayI = {'a', 'b', 'd', 'e', 'h','k', 'm'};
		int[] intArrayI = {1, 4, 6, 8, 10, 15, 19};
		
		char[] charArrayII = {'a', 'c', 'e', 'f', 'i', 'n', 'q', 's', 'z'};
		int[] intArrayII = {2, 3, 6, 7, 10, 11, 23, 30, 45};
		
		Array[] sortedArrayI = Get2DArray(charArrayI, intArrayI);
		Array[] sortedArrayII = Get2DArray(charArrayII, intArrayII);
		
		List<Array> sortedList = Sort2DArray(sortedArrayI, sortedArrayII);
		
		Print2DArray(sortedList);
	}
	
	
	public static void main(String[] args){
		run();
	}
}
