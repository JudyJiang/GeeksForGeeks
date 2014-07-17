
public class ReverseWordsWithString {
	/*"sky is blue"*/
	
	/*
	 * Solution 1: (Personal)
	 */
	public static String reverseWordsInString(String s){
		char[] tempString = s.toCharArray();
		int i = 0, j = s.length() - 1;
		while(i < j){
			char t = tempString[i];
			tempString[i] = tempString[j];
			tempString[j] = t;
			i++;
			j--;
		}
		
		int startPos = 0, endPos = 0;
		String resultStr = "";
		for(int k = 0; k < tempString.length; k++){
			if(tempString[k] != ' ')
				endPos++;
			else{
				resultStr += new StringBuffer(
						        new String(tempString).substring(startPos, endPos)).reverse().toString() + " ";
				startPos = k + 1;
				endPos = startPos;
			}
		}
		
		resultStr += new StringBuffer(
				new String(tempString).substring(startPos, endPos)).reverse().toString();
		return resultStr;
	}
	
	
	public static void test(){
		String[] stringCollections = {"I am Judy", 
				                      "Sky is Blue",
				                      "I'm working in S&P"};
		
		for(String s : stringCollections)
			System.out.println(reverseWordsInString(s));
	}
	
	public static void main(String[] args){
		test();
	}
}
