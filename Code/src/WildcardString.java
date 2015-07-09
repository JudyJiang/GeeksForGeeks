import java.util.*;

public class WildcardString {
	public static List<String> wildcardString(String s){
		List<String> res = new LinkedList<String>();
		if(s == null || s.length() == 0){
			return res;
		}
		
		wildcardString(s, res, "", 0);
		return res;
	}
	
	public static void wildcardString(String s, List<String> res, String tmp, int index){
		if(tmp.length() == s.length()){
			res.add(tmp);
			return ;
		}
		
		char c = s.charAt(index);
		if(c != '?')
			wildcardString(s, res, tmp + String.valueOf(c), index + 1);
		if(c == '?'){
			wildcardString(s, res, tmp + "0", index + 1);
			wildcardString(s, res, tmp + "1", index + 1);
		}
	}
	
	public static void main(String[] args){
		String s = "01?0?";
		List<String> res = wildcardString(s);
		System.out.println(res.size());
		for(String str : res)
			System.out.println(str);
	}
}
