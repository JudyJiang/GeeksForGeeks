package array;

import java.util.*;

/**
 * Made a stupid mistake initially, but correct it ~~
 * 
 * @author FengjiaoJiang
 *
 */
public class DigitsInterpretation_FengjiaoJiang {
	static HashMap<Integer, Character> map = new HashMap<Integer, Character>();
	
	static {
		char start = 'a';
		for(int i = 0; i < 26; i++)
			map.put(i+1, (char)(start++));
	}
	
	public static List<String> digitInteprete(int[] arr){
		List<String> res = new LinkedList<String>();
		if(arr == null || arr.length == 0)
			return res;
		digitInteprete(arr, res, "", 0);
		return res;
	}
	
	public static void digitInteprete(int[] arr, List<String> res, String str, int index){
		if(index >= arr.length){
			res.add(str);
			return;
		}
		
//		for(int i = index; i < arr.length; i++){
//			char tmp = map.get(arr[i]);
//			digitInteprete(arr, res, str + tmp, i +1);
//			if(i+1<arr.length && (arr[i] == 1 || (arr[i] == 2 && arr[i+1] <= 6))){
//				tmp = map.get(arr[i] * 10 + arr[i+1]);
//				digitInteprete(arr, res, str + tmp, i + 2);
//			}
//		}
		
		char tmp = map.get(arr[index]);
		digitInteprete(arr, res, str + tmp, index + 1);
		if(index + 1 < arr.length && (arr[index] == 1 || (arr[index] == 2 && arr[index + 1] <= 6))){
			tmp = map.get(arr[index] * 10 + arr[index + 1]);
					digitInteprete(arr, res, str + tmp, index + 2);
		}
	}
	
	public static void main(String[] args){
		int[] arr = {9, 1, 8};
		List<String> res = digitInteprete(arr);
		System.out.println(res.size());
		for(String s : res)
			System.out.println(s);
	}
}
