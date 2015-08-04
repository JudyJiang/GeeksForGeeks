package string;

import java.util.*;

public class MaximumDepthParentheis {
	public static int maxDepthParent(String s){
		int max = 0;
		Stack<Character> stack = new Stack<Character>();
		int index = 0;
		while(index < s.length()){
			char tmp = s.charAt(index);
			if(tmp == '('){
				stack.push(tmp);
			}
			else if(tmp == ')'){
				if(stack.size() == 0)
					return -1;
				max = Math.max(max,  stack.size());
				stack.pop();
			}
			index++;
		}
		
		if(stack.size() != 0)
			return -1;
		
		return max;
	}
	
	public static void main(String[] args){
		String s = "(b) ((c) ()";
		System.out.println(maxDepthParent(s));
	}
}
