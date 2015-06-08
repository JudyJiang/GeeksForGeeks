import java.util.*;

/*
 * Use Stack differently, store the position (index) instead of
 * store the actual '(' or ')'
 */
public class LongestValidParentheses {
	/*
	 * store when '(' appears When ')' appears at position i 1. if stack is
	 * empty(), then i is the last index of valid parentheses 2. if stack is not
	 * empty(), distance minus the stack peek value (since stack stores the
	 * index value)
	 */
	public static int longestValidParentheses(String s) {
		if (s == null || s.length() == 0)
			return 0;

		Stack<Integer> stack = new Stack<Integer>();
		int maxLen = 0, len = s.length(), lastIndex = -1;
		//cause every valid current length should be i - poped() previous.
		for (int i = 0; i < len; i++) {
			if (s.charAt(i) == '(') {
				stack.push(i);
				//keep updates lastIndex value when there's a '(' so 
				//when popped one, can track the last index
			} else {
				if (stack.isEmpty()) {
					lastIndex = i;
				} else {
					stack.pop();
					if(stack.isEmpty())
						maxLen = Math.max(maxLen, i - lastIndex);
					else
						maxLen = Math.max(maxLen, i - stack.peek());
				}
			}
		}
		return maxLen;
	}
	
	//this method keeps track of continues valid parentheses, mark them to "*"
	//then go through the array for "longest continuous '*'"
	//easier than the previous one
	public static int longestValidParenthesesII(String s){
		if(s == null || s.length() == 0)
			return 0;
		int maxLen = 0, len = s.length();
		char[] sChar = s.toCharArray();
		Stack<Integer> stack = new Stack<Integer>();
		for(int i = 0; i < len; i++){
			if(sChar[i] == '('){
				stack.push(i);
			}
			else{
				if(!s.isEmpty()){//make sure it's valid
					sChar[i] = '*';
					sChar[stack.peek()] = '*';
					stack.pop();
				}
			}
		}
		
		int currLen = 0;
		for(int i = 0; i < len; i++){
			if(sChar[i] == '*')
				currLen++;
			else{
				maxLen = Math.max(currLen, maxLen);
				currLen = 0;
			}
		}
		maxLen = Math.max(currLen, maxLen);
		return maxLen;
	}
	
	public static void main(String[] args){
		String s = "()";
		int res = longestValidParentheses(s);
		System.out.println(res);
	}
}
