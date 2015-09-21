package string;

import java.util.Arrays;

public class RemoveDuplicates {
	/*
	 * bcabc: abc
	 * cbacdcbc; acdb, (adcb)
	 */
	
	public static String removeDuplicates(String str){
		char[] tmpChar = str.toCharArray();
		int[] position = new int[26];
		Arrays.fill(position, -1);
		
		for(int i = 0; i < tmpChar.length; i++){
			char tmp = tmpChar[i];
			int index = tmp - 'a';
			if(position[index] == -1){
				position[index] = i;
			}
			else{
				//i-1 must be > 0 cause otherwise position would not be 0
				if(tmpChar[i - 1] > tmp){
					tmpChar[i] = '#';
				}
				else{
					int oIndex = position[index];
					if((oIndex == 0 || tmpChar[oIndex -1] < tmp) && (oIndex == tmpChar.length - 1 || tmpChar[oIndex+1] > tmp))
						tmpChar[i] = '#';
					else{
						tmpChar[oIndex] = '#';
						position[index] = i;
					}
				}
			}
		}
		
		String res = String.valueOf(tmpChar);
//		for(int i = 0; i < tmpChar.length; i++)
//			System.out.print(tmpChar[i] + " ");
		res = res.replace("#",  "");
		return res;
	}
	
	public static void main(String[] args){
		String s = "abcadaba";
		String res = removeDuplicates(s);
		System.out.println(res);
	}
}
