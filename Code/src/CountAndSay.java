
public class CountAndSay {
	public static String countAndSay(int n){
		String tmp = "1";
		while(n -1 > 0){
			String mid = countAndSay(tmp);
			tmp = mid;
			n--;
		}
		return tmp;
	}
	
	public static String countAndSay(String s){
		StringBuilder sb = new StringBuilder();
		char[] charArr = s.toCharArray();
		int count = 1;
		char value = charArr[0];
		for(int i = 1; i < charArr.length; i++){
			if(charArr[i] != charArr[i - 1])
			{
				sb.append(String.valueOf(count));
				sb.append(value);
				value = charArr[i];
				count = 1;
			}
			else{
				count++;
			}
		}
		
		sb.append(String.valueOf(count));
		sb.append(value);
		return sb.toString();
	}
	
	public static void main(String[] args){
		System.out.println(countAndSay(5));
	}
}
//11131221133112132113212221