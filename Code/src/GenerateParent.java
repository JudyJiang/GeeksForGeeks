import java.util.*;

public class GenerateParent {
	public static List<String> generateParent(int n){
		List<String> res = new LinkedList<String>();
		if(n == 0){
			return res;
		}
		
		Set<String> set = new HashSet<String>();
		set = generateParent(set, n);
		res.addAll(set);
		return res;
	}
	
	public static Set<String> generateParent(Set<String> set, int n){
		if(n == 0){
			set.add("");
			return set;
		}
		else{
			Set<String> prev = generateParent(set, n - 1);
			set = new HashSet<String>();
			for(String str : prev){
				for(int i = 0; i < str.length(); i++){
					if(str.charAt(i) == '('){
						String s = insertString(str, i);
						set.add(s);
					}
				}
				if(!set.contains("()" + str))
					set.add("()" + str);
			}
			return set;
		}
	}
	
	public static String insertString(String str, int index){
		String first = str.substring(0,  index + 1);
		String second = str.substring(index + 1);
		return first + "()" + second;
	}
	
	public static void main(String[] args){
		List<String> res = generateParent(2);
		System.out.println(res.size());
		for(String s : res)
			System.out.println(s);
	}
}
