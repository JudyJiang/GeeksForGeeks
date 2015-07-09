package careercup;

public class LongestPrefix {
	public static String longestPrefix(String[] strs){
		StringBuilder longest = new StringBuilder();
		int shortest = Integer.MAX_VALUE, size = strs.length;
		String shortestStr = "";
		for(int i = 0; i < size; i++){
			if(strs[i].length() < shortest){
				shortest = strs[i].length();
				shortestStr = strs[i];
			}
		}
		
		boolean prefix = false;
		for(int i = 0; i < shortest; i++){
			char tmp = shortestStr.charAt(i);
			for(int j = 0; j < strs.length; j++){
				if(strs[j].charAt(i) != tmp)
					prefix = true;
			}
			if(!prefix)
				longest.append(tmp);
			else
				break;
		}
		return longest.toString();
	}
	
	
	public static void main(String[] args){
		String[] strs = {"I love all dogs", "I love cats", "I "};
		String prefix = longestPrefix(strs);
		System.out.println(prefix);
	}
}
