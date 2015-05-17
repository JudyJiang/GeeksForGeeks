import java.util.*;

/*
 * This is similar with the TwoSum, continuous staff. 
 */
public class WordSubstringConcatenations {
	public static List<Integer> findSubstring(String s, String[] words){
		List<Integer> res = new ArrayList<Integer>();
		if(s == null || words == null || s.length() == 0 || words.length == 0)
			return res;
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		int num = words.length, oneLength = words[0].length();
		for(String word: words){
			if(!map.containsKey(word)){
				map.put(word,  1);
			}
			else{
				map.put(word,  map.get(word) + 1);
			}
		}
		for(int i = 0; i < s.length()-oneLength*num; i++){
			String tmp = s.substring(i, i+oneLength*num);
			if(isConcatenation(tmp, words, map)){
				res.add(i);
			}
		}
		
		return res;
	}
	
	public static boolean isConcatenation(String tmp, String[] words, HashMap<String, Integer> map){
		Map<String, Integer> copy = new HashMap<String, Integer>();
		int index = 0, oneLength = words[0].length(), num = words.length;
		while(index < tmp.length()){
			String subStr = tmp.substring(index,  index + oneLength);
			if(!map.containsKey(subStr))
				return false;
			
			else{
				if(!copy.containsKey(subStr))
					copy.put(subStr, 1);
				else{
					int times = copy.get(subStr);
					if(times + 1 > map.get(subStr))
						return false;
					copy.put(subStr, copy.get(subStr) + 1);
				}
			}
			index += oneLength;
		}
		return true;
	}
}
 