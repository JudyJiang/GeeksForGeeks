
public class RegularExpressionMatching {
	public static boolean isMatch(String s, String p){
		return isMatch(s, p, 0, 0);
	}
	
	public static boolean isMatch(String s, String p, int i, int j){
		//System.out.println(s + " " + p);
		if(s == null && p == null){
			System.out.println("both null");
			return true;
		}
		
		if(s == null || p == null){
			System.out.println("one null: " + s + " " + p);
			return false;
		}
		
		int ls = s.length(), lp = p.length();
		if(j == lp){
			System.out.println(i + " " + j);
			return i == ls;
		}
		
		if(j < lp - 1 && p.charAt(j + 1) != '*' || j == lp - 1){
			System.out.println("second not *: " + s + " " + p);
			return (i < ls && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') && 
					isMatch(s, p, i + 1, j + 1));
		}//current is 'i' and 'j' and 'j+1' is not '*';
		
		//current is 'i' and 'j' and 'j+1' is '*'
		while(i < ls && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')){
			System.out.println("second is *: " + s + " " + p);
			if(isMatch(s, p, i, j+ 2))
				return true;
			i++;
		}
		
		System.out.println("here: " + s + " " + p + " " + i + " " + j);
		return isMatch(s, p, i, j + 2);//this is for case lie: aab -> c*a*b 
		//and case "aa" -> "a*"
		//in line 36, the i already to the end of "aa". this is to consume all previous
		//unmatched staff before a "*" and go to next round
		
		//return false;
	}
	
	
	public static void main(String[] args){
		String s = "aa", p = "*";
		boolean res = isMatch(s, p);
		System.out.println(res);
	}
}
