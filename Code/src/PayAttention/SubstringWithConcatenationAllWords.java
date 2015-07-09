package PayAttention;
import java.util.*;

public class SubstringWithConcatenationAllWords {
	public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new LinkedList<Integer>();
        if(s == null || s.length() == 0 || words == null || words.length == 0){
            return res;
        }
        
        int oneLen = words[0].length(), totalLen = words[0].length() * words.length;
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        //This is because it can contain duplicate words
        for(String word : words){
            if(!map.containsKey(word)){
                map.put(word, 1);
            }
            else{
                map.put(word, map.get(word) + 1);
            }
        }
        
        for(int i = 0; i <= s.length() - totalLen; i++){
            String tmpWord = s.substring(i, i + totalLen);
            if(containsAllWords(tmpWord, map, oneLen)){
                res.add(i);
            }
        }
        return res;
    }
    
    public boolean containsAllWords(String s, HashMap<String, Integer> map, int oneWord){
        HashMap<String, Integer> copy = new HashMap<String, Integer>();
        int index = 0;
        while(index < s.length()){
            String tmpStr = s.substring(index, index + oneWord);
            if(!map.containsKey(tmpStr)){
                return false;
            }
            else{
               if(!copy.containsKey(tmpStr)){
                   copy.put(tmpStr, 1);
               } 
               else{
                   int value = copy.get(tmpStr);
                   if(value + 1 > map.get(tmpStr)){
                       return false;
                   }
                   copy.put(tmpStr, copy.get(tmpStr) + 1);
               }
            }
            index += oneWord;
        }
        return true;
    }
	
	public static void main(String[] args){
		char[] arr = new char[256];
		arr['a'] = '4';
		for(int i = 0; i < arr.length; i++){
			System.out.println(i + " " + arr[i]);
		}
		
	}
}
