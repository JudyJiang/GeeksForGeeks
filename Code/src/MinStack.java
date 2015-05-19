import java.util.*;

public class MinStack {
	Stack<Integer> s1;
	Stack<Integer> s2;
	
	public MinStack(){
		s1 = new Stack<Integer>();
		s2 = new Stack<Integer>();
	}
	
	public void push(int x){
		s1.push(x);
		if(!s2.isEmpty()){
			int top = s2.peek();
			while(top > x){
				s2.pop();
			}
		}
		s2.push(x);
	}
	
	public void pop(){
		int top = s1.peek();
		if(top == s2.peek())
			s2.pop();
		s1.pop();
	}
	
	public int top(){
		return s1.peek();
	}
	
	public int getMin(){
		return s2.peek();
	}
}
