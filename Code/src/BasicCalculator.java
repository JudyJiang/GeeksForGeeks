import java.util.*;

/**
 * Finally accepted....
 * Need really to be paid attention
 * @author FengjiaoJiang
 *
 */
public class BasicCalculator {
	public static int calculate(String s) {
		//use two stacks
		if(s == null || s.length() == 0)
			return 0;
		Stack<String> s1 = new Stack<String>();
		Stack<String> s2 = new Stack<String>();
		
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < s.length(); i++){
			char tmp = s.charAt(i);
			if(tmp != ' '){
				if(tmp == ')'){
					if(!sb.toString().equals("")){
						s1.push(sb.toString());
						sb = new StringBuilder();
					}
					calculate(s1, s2);
				}
				else{
					if(tmp == '+' || tmp == '-' || tmp == '('){
						if(!sb.toString().equals(""))
								s1.push(sb.toString());
						s1.push(String.valueOf(tmp));
						sb = new StringBuilder();
					}
					else
						sb.append(tmp);
				}
			}
		}
		
		if(!sb.toString().equals(""))
			s1.push(sb.toString());
		
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

			String res = op.equals("+") ? String.valueOf(Integer.valueOf(opr1) + Integer.valueOf(opr2)) : 
				                          String.valueOf(Integer.valueOf(opr1) - Integer.valueOf(opr2));
			s2.push(res);
		}
	}


	public static void main(String[] args) {
		String s = "(1122) + (334) - (((12)) -4)";
		int res = calculate(s);
		System.out.println(res);
	}
}
