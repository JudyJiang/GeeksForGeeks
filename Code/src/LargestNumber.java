import java.util.*;


/**
 * To revise Collections.sort(? super.)
 * Collections (Arrays).sort(List<?>, new Comparator<?>)
 * the new Comparator can be a new class defined
 * class NewSortClass implements Comparator<?>
 * 'implements compare method'
 * 
 * 
 * @author FengjiaoJiang
 *
 */
public class LargestNumber {
	
	//3, 30, 34, 5, 9
	public static String largestNumber(int[] nums){
		return "";
	}
	
	public static void main(String[] args){
		String[] strs = {"3", "30", "34", "5", "9"};

		Arrays.sort(strs, new Comparator<String>(){
			public int compare(String s1, String s2){
				if(s1 == null || s1.length() == 0)
					return -1;
				if(s2 == null || s2.length() == 0)
					return 1;
				if(s1.equals(s2))
					return 0;
				
				int len = s1.length() <= s2.length() ? s1.length() : s2.length();
				if(s1.charAt(0) != s2.charAt(0))
					return s1.compareTo(s2);
				
				String prefix = "";
				int preIndex = 0;
				for(int i = 0; i < len; i++){
					if(s1.charAt(i) == s2.charAt(i)){
						preIndex++;
						continue;
					}
					
					prefix = s1.substring(0, preIndex+1);
					String first = s1.substring(preIndex + 1);
					String second = s2.substring(preIndex + 1);
//					if(first.length() == 0){
//						return prefix.compareTo(second);
//					}
//					else if(second.length() == 0)
//						return prefix.compareTo(first);
//					else
//						return first.compareTo(second); this may need to be changed to select which part to pick, first or second
				}
				return -1;
			}
		});
	}
}
