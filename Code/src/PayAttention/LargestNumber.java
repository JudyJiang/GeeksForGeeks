package PayAttention;
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
		String[] strs = {"121", "12"};//{"3", "30", "34", "5", "9"};
		
		Arrays.sort(strs, new Comparator<String>(){
			public int compare(String s1, String s2){
				String left = s1 + s2;
				String right = s2 + s1;
				return -left.compareTo(right);
			}
		});
		
		for(int i = 0;i < strs.length; i++){
			System.out.print(strs[i] + " ");
		}
		
	}
}
