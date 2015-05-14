import java.util.*;

public class WordBreakII {
	public static List<String> wordBreak(String s, Set<String> wordDict) {
		List<String> res = new ArrayList<String>();
		if(!WordBreak.wordBreak(s, wordDict))
			return res;
		System.out.println("Breakable");
		res = wordBreak(s, wordDict, "", 0, res);
		return res;
	}
	
	public static List<String> wordBreak(String s, Set<String> wordDict, String str, int index, List<String> list){
		if(index >= s.length()){
			list.add(str);
			return list;
		}
		
		for(int i = index; i <= s.length(); i++){
			String tmp = s.substring(index, i);
			if(wordDict.contains(tmp)){
				wordBreak(s, wordDict, str + (index==0?"":" ") + tmp, i, list);
			}
		}
		return list;
	}
	
	public static void main(String[] args){
		String s = "catsanddog";
		Set<String> wordDict = new HashSet<String>(Arrays.asList("cat", "cats", "and", "sand","dog"));
		s = "aaaaaaa";
		wordDict = new HashSet<String>(Arrays.asList("aaaa", "aaa"));
		List<String> res = wordBreak(s, wordDict);
		System.out.println(res.size());
		for(String str: res)
			System.out.println(str);
	}
}
