package careercup;

import java.util.*;

public class Computation {
	private static String[] operands = {"+", "-", "*", "/"};
	
	
	public static List<int[]> permutations(int[] nums){
		return null;
	}
	
	
	public static String evaluate(int[] nums, int target){
		List<int[]> perms = permutations(nums);
		Stack<Integer> s = new Stack<Integer>();
		List<List<String>> trace = new LinkedList<List<String>>();
		List<String> expression = new LinkedList<String>();
	
		for(int[] list : perms){
			for(int i : list)
				s.push(i);
			evaluate(s, target, trace);
		}
		return "";
	}
	
	public static void evaluate(Stack<Integer> s, int target, List<List<String>> trace){
		if(s.size() == 1 && s.peek() == target){
			return ;
		}
		
		if(s.size() == 1 && s.peek() != target){
			
		}
		
		int a = s.pop();
		int b = s.pop();
		for(int i = 0; i < operands.length; i++){
			s.push(compute(a, b, operands[i]));
			evaluate(s, target, trace);
			s.pop();
		}
	}
	
	
	public static int compute(int a, int b, String oper){
		int val = 0;
		switch(oper){
		case "+":
			val = b + a;
			break;
		case "-":
			val = b - a;
			break;
		case "*":
			val = b * a;
			break;
		case "/":
			val = b / a;
			break;
		}
		return val;
	}
	
	public static void main(String[] args){
		System.out.println("I hate life");
	}
}
