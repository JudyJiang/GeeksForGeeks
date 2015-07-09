package careercup;

import java.util.*;

public class Computation {
	private static String[] operands = {"+", "-", "*", "/"};
	
	
	public static List<List<Integer>> permutations(int[] nums){
		List<List<Integer>> res = new LinkedList<List<Integer>>();
		boolean[] visited = new boolean[nums.length];
		List<Integer> list = new LinkedList<Integer>();
		permutations(nums, res, list, visited);
		return res;
	}
	
	public static void permutations(int[] nums, List<List<Integer>> res, List<Integer> list, boolean[] visited){
		if(list.size() == nums.length){
			List<Integer> copy = new LinkedList<Integer>();
			copy.addAll(list);
			res.add(copy);
			return ;
		}
		
		for(int i = 0; i < nums.length; i++){
			if(!visited[i]){
				list.add(nums[i]);
				visited[i] = true;
				permutations(nums, res, list, visited);
				visited[i] = false;
				list.remove(list.size() - 1);
			}
		}
	}
	
	
	public static String evaluate(int[] nums, int target){
		List<List<Integer>> perms = permutations(nums);
		Stack<Integer> s = new Stack<Integer>();
		List<List<String>> trace = new LinkedList<List<String>>();
		List<String> expression = new LinkedList<String>();
	
		for(List<Integer> list : perms){
			for(int i : list)
				s.push(i);
			evaluate(s, target, trace);
			s = new Stack<Integer>();
		}
		return "";
	}
	
	public static void evaluate(Stack<Integer> s, int target, List<List<String>> trace){
		if(s.size() == 0)
			return;
		if(s.size() == 1 && s.peek() == target){
			System.out.println("Yes, here");
			return ;
		}
		
		if(s.size() == 1 && s.peek() != target){
			//System.out.println("final res: " + s.peek());
			return ;
		}
		
		int a = s.pop(), b = s.pop();
		for(int i = 0; i < operands.length; i++){
			//System.out.println(a + " " + b + " " + compute(a, b, operands[i]));
			s.push(compute(a, b, operands[i]));
			evaluate(s, target, trace);
			if(!s.isEmpty())
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
			val = a - b;
			break;
		case "*":
			val = b * a;
			break;
		case "/":
			val = a / b;
			break;
		}
		return val;
	}
	
	public static void main(String[] args){
		//2 + 3 - 1 * 6
		int[] nums = {2, 3, 1, 6};
		evaluate(nums, 24);
	}
}
