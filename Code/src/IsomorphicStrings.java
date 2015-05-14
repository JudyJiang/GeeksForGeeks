import java.util.*;

public class IsomorphicStrings {
	public static boolean ismorphicString(String s, String t){
		char[] sChar = s.toCharArray();
		char[] tChar = t.toCharArray();
		Arrays.sort(sChar);
		Arrays.sort(tChar);
		
		return true;
	}
	public static void main(String[] args){
		
	}
}
