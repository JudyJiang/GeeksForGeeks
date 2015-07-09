
public class LongestSubstringWithoutRepeatingCharacter {
	public static int lengthOfLongestSubstring(String s){
		if(s == null || s.length() == 0){
			return 0;
		}
		
		int max = 0, end = 0, start = 0;
		boolean[] records = new boolean[256];
		
		while(end < s.length()){
			char c = s.charAt(end);

			if(records[c]){
				max = Math.max(max,  end - start);
				while(s.charAt(start) != c){//this is especially important
					//cause originally made mistake to just use the while(start < end)
					//but it actually needs to find the "first repeating character"
					records[s.charAt(start)] = true;
					start++;
				}
				start++;
			}
			
			else{
				records[c] = true;
			}
			end++;
		}
		//System.out.println(start + " " + end);
		max = Math.max(max, end - start);
		return max;
	}
	
	public static void main(String[] args){
		String s = "abcabcbb";// "dvdf"
		System.out.println(lengthOfLongestSubstring(s));
	}
}
