package string;

public class LongestKCharacterSubstring {
	public static String longestSubstring(String s, int k){
		int start = 0, i = 0, max = 0, count = 0;
		String res = "";
		int[] records = new int[256];
		for(i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			if(records[c] == 0){
				records[c]++;
				count += 1;
				if(count > k){
					if(i - start > max){
						max = Math.max(max, i - start);
						res = s.substring(start, i);
					}
					
					while(start <= i){
						records[s.charAt(start)]--;
						if(records[s.charAt(start)] == 0){
							count -= 1;
							if(count <= k){
								break;
							}
						}
						start++;
					}
					start++;
				}
			}
			else{
				records[c] += 1;
			}
		}
		if(i - start > max){
			max = i - start;
			res = s.substring(start, i);
		}
		System.out.println(max + " " + res);
		return s.substring(start, i);
	}
	
	public static void main(String[] args){
		String str = "aabacbebebe";
		longestSubstring(str, 2);
	}
}
