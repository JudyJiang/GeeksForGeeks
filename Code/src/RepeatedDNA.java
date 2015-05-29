import java.util.*;

public class RepeatedDNA {
	public static List<String> findRepeatedDnaSequences(String s) {
		List<String> result = new ArrayList<String>();
		int len = s.length();
		if(len < 10)
			return result;
		
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('A', 0);
		map.put('C', 1);
		map.put('G', 2);
		map.put('T', 3);
		
		int hash = 0;
		Set<Integer> tmp = new HashSet<Integer>();
		Set<Integer> added = new HashSet<Integer>();
		
		for(int i = 0; i < len; i++){
			if(i < 9){
				hash = (hash << 2) + map.get(s.charAt(i));
				//System.out.println(i + " " + hash + " " + s.charAt(i));
				//System.out.println(Integer.toBinaryString(hash) + "\n");
			}
			else{
				hash = (hash << 2) + map.get(s.charAt(i));
				System.out.println(Integer.toBinaryString(hash));
				hash = hash & (1 << 20) - 1;
				System.out.println(Integer.toBinaryString(hash) + "\n");
				//two bit for one character, 10 character sequence
				//then 20 bits
				if(tmp.contains(hash) && !added.contains(hash)){
					added.add(hash);
					result.add(s.substring(i - 9, i + 1));
				}
				else{
					tmp.add(hash);
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args){
		String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
		findRepeatedDnaSequences(s);
	
	}
}
