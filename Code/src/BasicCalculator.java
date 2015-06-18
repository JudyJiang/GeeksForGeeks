import java.util.*;

public class BasicCalculator {
	public static int calculate(String s) {
		//use two stacks
		if(s == null || s.length() == 0)
			return 0;
		Stack<String> s1 = new Stack<String>();
		Stack<String> s2 = new Stack<String>();
		
		for(int i = 0; i < s.length(); i++){
			char tmp = s.charAt(i);
			if(tmp != ' '){
				if(tmp == ')'){
					calculate(s1, s2);
				}
				else{
					s1.push(String.valueOf(tmp));
				}
			}
		}
		
		if(s1.size() > 1)
			calculate(s1, s2);
		if(!s1.isEmpty())
			return Integer.valueOf(s1.peek());
		return 0;
	}
	
	public static void calculate(Stack<String> s1, Stack<String> s2){
		while(!s1.isEmpty() && !s1.peek().equals("(")){
			s2.push(s1.pop());
		}
		
		if(!s1.isEmpty() && s1.peek().equals("("))
			s1.pop();
		
		
		while(!s2.isEmpty()){
			String opr1 = s2.pop();
			if(s2.isEmpty()){
				s1.push(opr1);
				return ;
			}
			String op = s2.pop();
			String opr2 = s2.pop();
			//System.out.println(opr1 + " " + opr2);
			String res = op.equals("+") ? String.valueOf(Integer.valueOf(opr1) + Integer.valueOf(opr2)) : 
				                          String.valueOf(Integer.valueOf(opr1) - Integer.valueOf(opr2));
			s2.push(res);
		}
	}


	public static void main(String[] args) {
		String s = "(2)+(2)+(2+3)+(4-1)-(1)";
		int res = calculate(s);
		System.out.println(res);
	}
}
