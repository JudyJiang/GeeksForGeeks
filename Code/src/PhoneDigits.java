import java.util.*;

public class PhoneDigits {
	public static List<String> letterCombinations(String digits) {
        List<String> res = new LinkedList<String>();
        if(digits == null || digits.length() == 0){
            return res;
        }
        
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("0", "");
        map.put("1", null);
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");
        combination(digits, map, "", res, 0);
        return res;
    }
    
    public static void combination(String digits, HashMap<String, String> map, String tmp, List<String> res, int index){
        if(tmp.length() == digits.length()){
            res.add(tmp);
            return ;
        }
        
        String digitStr = map.get(String.valueOf(digits.charAt(index)));
       
        for(int i = 0; i < digitStr.length(); i++){
        	combination(digits, map, tmp+String.valueOf(digitStr.charAt(i)), res, index+1);
        }
    }
    
    public static void main(String[] args){
    	String digits = "22";
    	List<String> res = letterCombinations(digits);
    	System.out.println(res.size());
    	for(String s : res)
    		System.out.println(s);
    }
}
