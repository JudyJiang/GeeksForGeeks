import java.util.*;

//My thought here is ... use mode. %
public class ExcelSheetColumnTitle {
	public static String convertToTitle(int n){
		if(n <= 0)
			return null;
		
		HashMap<Integer, Character> map = new HashMap<Integer, Character>();
		char value = 'A'; 
		for(int i = 1; i <= 26; i++){
			map.put(i,  value++);
		}
		
		
		int res = 0, remain = 0;
		StringBuilder title = new StringBuilder();
		while(true){
			break;
		}
		return "";
	}
	
	public static void main(String[] args){
		
	}
}
