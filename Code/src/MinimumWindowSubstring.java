import java.util.*;
/**
 * Pay attention to the "count==tLen".
 * The count doesn't decrease when trying to shrink the substring.
 * Every time there's a match in the "toBeFind"
 * 
 * @author FengjiaoJiang
 *
 */
public class MinimumWindowSubstring {
	 public String minWindow(String s, String t) {
	        if(s == null || s.length() == 0 || t == null || t.length() == 0){
	            return "";
	        }
	        
	        if(t.length() > s.length()){
	            return "";
	        }
	        
	        HashMap<Character, Integer> target = new HashMap<Character, Integer>();
	        for(int i = 0; i < t.length(); i++){
	            char c = t.charAt(i);
	            if(!target.containsKey(c)){
	                target.put(c, 1);
	            }
	            else{
	                target.put(c, target.get(c) + 1);
	            }
	        }
	        
	        int count = 0, tLen = t.length(), minLen = s.length() + 1, start = 0;
	        String res = "";
	        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
	        for(int i = 0; i < s.length(); i++){
	            char tmp = s.charAt(i);
	            if(target.containsKey(tmp)){
	                if(map.containsKey(tmp)){
	                    if(map.get(tmp) < target.get(tmp)){
	                        count++;
	                    }
	                    map.put(tmp, map.get(tmp) + 1);
	                }
	                else{
	                    map.put(tmp, 1);
	                    count++;
	                }
	            }
	            
	            if(count == tLen){
	                char c = s.charAt(start);
	                while(!map.containsKey(c) || map.get(c) > target.get(c)){
	                    if(map.containsKey(c) && map.get(c) > target.get(c)){
	                        map.put(c, map.get(c) - 1);
	                    }
	                    start++;
	                    c = s.charAt(start);
	                }
	                if(i - start + 1 < minLen){
	                    res = s.substring(start, i + 1);
	                    minLen = i - start + 1;
	                } 
	            }
	        }
	        return res;
	    }
	 
	 
	 public String minWindowII(String s, String t) {
	        if(s == null || s.length() == 0 || t == null || t.length() == 0){
	            return "";
	        }
	        
	        if(t.length() > s.length()){
	            return "";
	        }
	        
	        int sLen = s.length(), tLen = t.length();
	        int[] toBeFind = new int[256];
	        int[] hasFound = new int[256];
	        for(int i = 0; i < tLen; i++){
	            int index = t.charAt(i) - '0';
	            toBeFind[index]++;
	        }
	        
	        int count = 0, start = 0, minLen = Integer.MAX_VALUE;
	        String res = "";
	        for(int i = 0; i < sLen; i++){
	            int index = s.charAt(i) - '0';
	            if(toBeFind[index] != 0){
	                if(hasFound[index] < toBeFind[index]){
	                    count++;
	                }
	                hasFound[index]++;
	                
	                if(count == tLen){
	                    int tmpIndex = s.charAt(start) - '0';
	                    while(toBeFind[tmpIndex] == 0 || hasFound[tmpIndex] > toBeFind[tmpIndex]){
	                        if(hasFound[tmpIndex] > toBeFind[tmpIndex]){
	                            hasFound[tmpIndex]--;
	                        }
	                        start++;
	                        tmpIndex = s.charAt(start) - '0';
	                    }
	                    
	                    if((i - start + 1) < minLen){
	                        minLen = i - start + 1;
	                        res = s.substring(start, i + 1);
	                    }
	                }
	            }
	        }
	        return res;
	    }
}
