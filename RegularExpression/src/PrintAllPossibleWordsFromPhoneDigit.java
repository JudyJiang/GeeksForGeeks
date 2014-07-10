import java.util.*;


public class PrintAllPossibleWordsFromPhoneDigit {
	public static HashMap<Integer, String[]> map = new HashMap<Integer, String[]>();
	static {
		map.put(0, null);
		map.put(1, null);
		map.put(2, new String[]{"A", "B", "C"});
		map.put(3, new String[]{"D", "E", "F"});
		map.put(4, new String[]{"G", "H", "I"});
		map.put(5, new String[]{"J", "K", "L"});
		map.put(6, new String[]{"M", "N", "O"});
		map.put(7,  new String[]{"P", "Q", "R", "S"});
		map.put(8,  new String[]{"T", "U", "V"});
		map.put(9,  new String[]{"W", "Y", "Z"});
	}
	
	
	public static void printAllCombinatinos(int originalNumber, String currentString, List<String> list, int wordIndex, int index){ 
		/*
		 * originalNumber: length of each combination
		 * currentString: string during procedure
		 * list: hold all the combinations
		 * wordIndex; specific String[] within one map match of index
		 * index: 
		 */
		if(currentString.length() == originalNumber){
			list.add(currentString);
			return ;
		}
		
		for(int i = 0; i < map.size(); i++){
			String[] temp = map.get(i);
			int length = temp.length;
			
			for(int j = wordIndex; j < length; j++){
				
			}
		}
	}
	
	
	public static void printAllCombinations(int number){
		List<String> results = new ArrayList<String>();
		String initialString = "";
		//printAllCombinations(results, number, 0, 0, initialString);
	}
}
