import java.util.*;

/**
 * I love myself! Love Love Love!
 * @author fengjiaojiang
 *
 */
public class RestoreIPAddress {
	public static List<String> restoreIpAddresses(String s) {
        List<String> res = new LinkedList<String>();
        if(s == null || s.length() == 0){
            return res;
        }
        
        restore(s, res, "", 0, 0);
        return res;
    }
    
    public static void restore(String s, List<String> res, String tmp, int index, int depth){
       if(depth == 4 && index == s.length()){
    	   res.add(tmp);
    	   return;
       }
       
       if(depth == 4){
    	   return ;
       }
       
       if(tmp.length() != 0){
    	   tmp += ".";
       }
       
       for(int i = index; i < s.length(); i++){
    	   String subStr = s.substring(index, i + 1);
    	   if(subStr.startsWith("0") && subStr.length() > 1)
    		   continue;
    	   if(subStr != null && subStr.length() != 0 && Double.valueOf(subStr) <= 255){
    		   restore(s, res, tmp+subStr, i + 1, depth+1);
    	   }
       }
    }
    
    
    public static void main(String[] args){
    	String s = "010010";
    	List<String> res = restoreIpAddresses(s);
    	System.out.println(res.size());
    	for(String str : res)
    		System.out.println(str);
    }
}
