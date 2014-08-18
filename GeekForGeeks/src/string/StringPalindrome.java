package string;

/**
 * If a string is a recombination of a palindrome Example: 1. "aaaab"-> yes 2.
 * "abc" -> no
 * 
 * @author FengjiaoJiang
 * 
 */
public class StringPalindrome {

	/* 1. Personal Solution, might be wrong, need additional test cases */
	public static boolean IsPlindromeRotation(String str) {
		int[] characters = new int[26];

		for (int i = 0; i < str.length(); i++) {
			characters[str.charAt(i) - 'a']++;
		}

		boolean oneOdd = false;

		for (int i = 0; i < characters.length; i++) {
			if (characters[i] % 2 != 0) {
				if (oneOdd)
					return false;
				else
					oneOdd = true;
			}
		}

		return true;
	}

	/*
	 * 2. The most simple solution. Give every rotation of the string Check if
	 * it's a palidrome.
	 */
	public static boolean IsPlindromeRotationII(String str) {
		String rotateStr = "";

		for (int i = 0; i < str.length(); i++) {
			String part1 = str.substring(i, str.length() - 1);
			String part2 = str.substring(0, i);
			rotateStr = part1 + part2;
			if(IsPalindrome(rotateStr)){
				return true;
			}
		}
		return false;
	}

	public static boolean IsPalindrome(String str) {
		int i = 0, j = str.length() - 1;
		
		while(i < j){
			if(str.charAt(i) != str.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;
	}
	
	public static void main(String[] args){
		String testStr = "aabb";
		System.out.println(IsPlindromeRotationII(testStr));
		
	}

}
