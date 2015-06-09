
public class ReverseWordInString {
	public static String reverseWord(String s){
		if(s == null)
			return null;
		s = s.trim();
		if(s.length() == 0)
			return "";
		
		StringBuilder sb = new StringBuilder();
		int curr = s.length() - 1, end = s.length();
		while(curr >= 0){
			char tmpChar = s.charAt(curr);
			if(tmpChar == ' '){
				String tmp = s.substring(curr+1, end);
				sb.append(tmp);
				sb.append(" ");
				while(tmpChar == ' '){
					curr--;
					tmpChar = s.charAt(curr);
				}
				end = curr + 1;
			}
			curr--;
		}
		String tmp = s.substring(0,  end);
		sb.append(tmp);
		return sb.toString().trim();
	}
	
	public static void main(String[] args){
		String s = "the sky is blue";
		String res = reverseWord(s);
		System.out.println(res);
	}
}
