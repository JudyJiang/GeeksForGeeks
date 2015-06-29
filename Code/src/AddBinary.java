import java.util.*;
public class AddBinary {
	public static String addBinary(String a, String b){
		if(a == null || a.length() == 0)
			return b;
		if(b == null || b.length() == 0){
			return a;
		}
		
		StringBuilder sb = new StringBuilder();
		int i = a.length() - 1, j = b.length() - 1;
		int carryOne = 0;
		
		while(i >= 0 || j >= 0){
			int sum = carryOne;
			if(i >= 0)
				sum += a.charAt(i--) - '0';
			if(j >= 0)
				sum += b.charAt(j--) - '0';
			sb.append(sum % 2);
			carryOne = sum / 2;
		}
		
		if(carryOne > 0)
			sb.append(carryOne);
		return sb.reverse().toString();
	}
	
	public static void main(String[] args){
		 String s = "()";
		 if(s == null || s.length() == 0){
	           System.out.println("Null");
	        }
	        
	        Stack<Integer> stack = new Stack<Integer>();
	        char[] record = new char[s.length()];
	        
	        for(int i = 0; i < s.length(); i++){
	          char c = s.charAt(i);
	          if(c == '('){
	              stack.push(i);
	          }
	          else if(c == ')'){
	              if(!stack.isEmpty()){
	                  int top = stack.pop();
	                  record[i] = '*';
	                  record[top] = '*';
	              }
	          }
	        }
	        
	        int max = 0, currLen = 0;
	        for(int i = 0; i < record.length; i++){
	        	System.out.print(i + " " + record[i] + " ");
	            if(record[i] == '*'){
	                currLen += 1;
	            }
	            else{
	 
	                max = Math.max(max, currLen);
	                currLen = 0;
	            }
	        }
	        System.out.println(max);
	}
}
