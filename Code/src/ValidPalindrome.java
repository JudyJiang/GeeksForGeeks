public class ValidPalindrome {
	public static boolean validPalindrome(String s){
		if(s == null || s.length() <= 1)
			return true;
		s = s.toLowerCase();
		s = s.replaceAll("\\s+", "");
		s = s.replaceAll("[^a-zA-Z0-9]", "");
		System.out.println(s);
		int i = 0, j = s.length() - 1;
		while(i <= j){
			if(s.charAt(i) != s.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;
	}
	public static void main(String[] args){
		String s = "A man, a plan, a canal: Panama";
		s = "0k.;r0.k;";
		System.out.println(validPalindrome(s));
	}
}
