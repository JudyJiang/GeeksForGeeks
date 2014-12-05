package linkedin;

import java.util.Arrays;

public class IsomorphicWords {
	public static boolean IfIsomorphic(String s1, String s2){
		if(s1.length() != s2.length())
			return false;
		char[] charS1 = SortingOfApperance(s1);
		char[] charS2 = SortingOfApperance(s2);
		
		for(int i = 0; i < charS1.length; i++){
			if(charS1[i] != charS2[i])
				return false;
		}
		
		return true;
	}
	
	public static char[] SortingOfApperance(String s){
		char[] charStr = s.toCharArray();
		Arrays.sort(charStr);
		StringBuilder sb = new StringBuilder();
		int count = 1;
		for(int i = 0; i < charStr.length - 1; i++){
			if(charStr[i] == charStr[i + 1])
				count++;
			else{
				sb.append(String.valueOf(count));
				count = 1;
			}
		}
		sb.append(String.valueOf(count));
		String appearanceStr = sb.toString();
		charStr = appearanceStr.toCharArray();
		Arrays.sort(charStr);
		return charStr;
	}
	
	public static void main(String[] args){
		String s1 = "ab", s2 = "ca";
		System.out.println(IfIsomorphic(s1, s2));
	}
}
