package string;

import java.util.*;
public class RecursivePrintSentence {
	public static void printString(List<List<String>> lists){
		int m = lists.size(), n = lists.get(0).size();
		String[] output = new String[m];
		
		for(int i = 0; i < n; i++){
			printString(lists, 0, i, output);
		}
	}
	
	
	public static void printString(List<List<String>> lists, int m, int n, String[] output){	
		output[m] = lists.get(m).get(n);
		
		if(m == lists.size() - 1){
			for(int i = 0; i < output.length; i++)
				System.out.print(output[i] + " ");
			System.out.println();
			return ;
		}//finish condition is very important. 
		
		
		for(int i = 0; i < lists.get(m + 1).size(); i++){//should be (m+1) not current size
				printString(lists, m + 1, i, output);
		}
	}
	
	public static void main(String[] args){
		List<List<String>> lists = new LinkedList<List<String>>();
		lists.add(Arrays.asList(new String[]{"You", "We"}));
		lists.add(Arrays.asList(new String[]{"Have", "Are"}));
		lists.add(Arrays.asList(new String[]{"Sleep", "Eat", "Drink"}));
		printString(lists);
	}
}
