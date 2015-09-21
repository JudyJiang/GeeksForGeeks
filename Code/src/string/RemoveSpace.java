package string;

public class RemoveSpace {
	//"g  eeks     for ge  eeks  "
	//can also use string builder
	public static void removeSpace(String s){
		int count = -1, curr = 0;
		char[] str = s.toCharArray();
		while(curr < s.length()){
			if(s.charAt(curr) != ' ')
				str[++count] = s.charAt(curr);
			curr++;
		}
		s = String.valueOf(str).substring(0,  count+1);
		System.out.println(s);
	}
	
	public static void main(String[] args){
		String s = "g  eeks     for ge  eeks  ";
		removeSpace(s);
	}
}
