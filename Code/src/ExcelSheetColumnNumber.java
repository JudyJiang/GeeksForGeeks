import java.util.*;

/*
 * Attention: this is a different dimension of math problem,use the pow...
 * But the thinking, procedure is correct;
 * Need imporve seeing throught the relationships...
 */
public class ExcelSheetColumnNumber {
	public static int titleToNumber(String s) {
		if(s == null || s.length() == 0)
			return 0;
		
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int count = 1;
		for(char a = 'A'; a <= 'Z'; a++){
			map.put(a,  count++);
		}
		
		int size = s.length(), res = 0;
		for(int i = size - 1; i >= 0; i--){
			int digit = (size - 1 - i);
			res += Math.pow(26,  digit) * map.get(s.charAt(i));
		}
		return res;
	}
	
	public static void main(String[] args){
		String s = "DAM";
		System.out.println(titleToNumber(s));
		System.out.println(731 % 26);
	}

}
