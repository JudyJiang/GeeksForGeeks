package string;

import java.util.*;

public class SpaceString {
	public static List<String> spaceString(String s){
		List<String> res = new LinkedList<String>();
		if(s == null || s.length() == 0){
			return res;
		}
		spaceString(s, res, 0, "");
		return res;
	}
	
	public static void spaceString(String s, List<String> res, int index, String tmp){
		if(index >= s.length()){
			res.add(tmp);
			return;
		}
		
		for(int i = index; i < s.length(); i++){
			char c = s.charAt(i);
			tmp += String.valueOf(c);//this important in two parts
			//1. should be "i" not "index"
			//2. should append the character "c" not inside the recursive function (otherwise not appending)
			//3. " " is optional so put it inside the recursive function 
			spaceString(s, res, i + 1, tmp + " ");
		}
	}
	
	public static void main(String[] args){
		String s = "ABCD";
		List<String> res = spaceString(s);
		System.out.println(res.size());
		for(String str : res)
			System.out.println(str);
	}
}
