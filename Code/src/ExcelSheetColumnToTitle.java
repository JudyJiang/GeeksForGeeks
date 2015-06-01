
import java.util.*;
//http://www.programcreek.com/2014/03/leetcode-excel-sheet-column-title-java/
public class ExcelSheetColumnToTitle {
	public static String convertToTitle(int n){
		if(n <= 0)
			return null;
		StringBuilder sb = new StringBuilder();
		while(n > 0){
			n--;
			char c = (char)(n % 26 + 'A');
			n /= 26;
			sb.append(c);
		}
		
		sb.reverse();
		return sb.toString();
	}
	
	public static void main(String[] args){
		int n = 26;
		System.out.println(convertToTitle(n));
	}
}
