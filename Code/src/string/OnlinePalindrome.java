package string;

public class OnlinePalindrome {
	public static void onlinePalindrome(String s){
		int index = 0, size = s.length();
		int updateNums = 0;
		StringBuilder first = new StringBuilder();
		StringBuilder second = new StringBuilder();
		while(index < size){
			if(index == 0){
				System.out.println("True");
				first.append(s.charAt(index));
			}
			else if(index == 1){
				second.append(s.charAt(index));
				System.out.println(first.equals(second));
			}
			else if(index % 2 == 0){
				second.deleteCharAt(0);
				second.append(s.charAt(index));
				System.out.println(first.toString().equals(second.toString()));
			}
			
			else{
				first.insert(0, s.charAt(index));
				second.append(s.charAt(index));
				System.out.println(first.toString().equals(second.toString()));
				//if(first == second), check the whole string
			}
			index++;
		}
		
	}
	
	public static void main(String[] args){
		String s = "aabaacaabaa";
		onlinePalindrome(s);
	}
}
