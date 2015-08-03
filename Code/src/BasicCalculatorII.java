import java.util.*;

public class BasicCalculatorII {
	public static int calculate(String s){
		Stack<Integer> operators = new Stack<Integer>();
		Stack<Character> operands = new Stack<Character>();
		
		char[] arr = s.toCharArray();
		int index = 0;
		boolean start = false;
		while (index < arr.length) {
			if (arr[index] == ' ') {
				index++;
				continue;
			}
			char c = arr[index];
			if (c <= '9' && c >= '0') {
				if (start) {
					int top = operators.pop();
					char op = operands.pop();
					int tmp = calculate((c - '0'), top, op);
					operators.push(tmp);
					start = false;
				}
				else
					operators.push((c - '0'));
			} else {
				operands.push(c);
				if (c == '*' || c == '/')
					start = true;
			}
		index++;
		}
		
		if(operands.isEmpty()){
			int res = operators.pop(), count = 1;
			while(!operators.isEmpty()){
				res = (int) (operators.pop() * Math.pow(10, count++) + res);
			}
			return res;
		}
		
		int tmp = 0, prev = operators.pop();
		while(!operands.isEmpty()){
			char op = operands.pop();
			int curr = operators.pop();
			System.out.println(prev + " " + curr);
			tmp = calculate(prev, curr, op);
			prev = tmp;
		}
		return prev;
	}
	
	public static int calculate(int a, int b, char c){
		switch(c){
		case '+':
			return b + a;
		case '-':
			return b - a;
		case '*':
			return b * a;
		case '/':
			return b / a;
		}
		return -1;
	}
	
	
	public static void main(String[] args){
		String s = "0-2147483647";
		System.out.println(calculate(s));
	}
} 