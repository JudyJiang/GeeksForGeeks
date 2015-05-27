import java.util.*;

public class MinStack {
	/*
	 * Another solution is everytime, the stack insert a specific node,
	 * public class Node{
	 *   public int value;
	 *   public int min;
	 *   
	 *   each inserted node carries the current minimum value.
	 * }
	 */
	Stack<Integer> s1;
	Stack<Integer> s2;
	
	public MinStack(){
		s1 = new Stack<Integer>();
		s2 = new Stack<Integer>();
		s2.push(Integer.MAX_VALUE);
	}
	
	public void push(int x){
		s1.push(x);
		
		if(!s2.isEmpty()){
			int top = s2.peek();
		//	System.out.println(s2.peek());
			if(top >= x){
				s2.push(x);
			}
		}
		
	}
	
	public void pop(){
		int top = s1.peek();
		if(top == s2.peek())
			s2.pop();
		s1.pop();
	}
	
	public int top(){
		if(!s1.isEmpty())
			return s1.peek();
		return -1;
	}
	
	public int getMin(){
		return s2.peek();
	}
	
	public static void main(String[] args){
		MinStack s = new MinStack();
		s.push(0);
		s.push(1);
		s.push(0);
		System.out.println(s.getMin());
		s.pop();
		System.out.println(s.getMin());
	}
}
