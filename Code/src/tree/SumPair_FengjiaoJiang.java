package tree;

import java.util.*;
import utility.TreeNode;

/**
 * 
 * @author fengjiaojiang
 *
 */

/*
 * 1. Brute force. for each of the "current root" find if (target - root.val) exist in its substree
 * return true if find one for current root, recursively doing so.
 */

/*
 * 2. Traverse the tree to linked-list. Then it's the typical "Two Sum" problem for an linked list or sorted array
 */

/*
 * 3. My solution. Use a stack, Time O(n), Space O(logN) N is the nuber of the tree.
 * 1. Go left until target is larger than root val (no use if target is smaller than root value)
 * 2. Use a stack to hold all left branch values. 
 * 3. Go in order traversal to the right branch of the root (carrying the stack).
 * Every time compare the peek value within the stack with the current traversing value
 * If sum larger than target. stack pop one
 * if sum smaller than target. go to the next value.
 */
public class SumPair_FengjiaoJiang {
	public static boolean findSumPair(TreeNode root, int target){
		Stack<TreeNode> s = new Stack<TreeNode>();
		leftBranch(root, s);//while(target < root.val),root = root.left;
		return findSumPair(s, root.right, target);
	}
	
	public static boolean findSumPair(Stack<TreeNode> s, TreeNode root, int target){
		if(root == null || s.isEmpty())
			return false;
	
		boolean res = findSumPair(s, root.left, target);
		if(res)
			return true;
		int twoSum = s.peek().val + root.val;
		System.out.println(s.peek().val + " " + root.val);
		if(target == twoSum)
			return true;
		while(!s.isEmpty() && twoSum > target){
			s.pop();
			if(s.isEmpty())
				break;
			twoSum = s.peek().val + root.val;
			if(twoSum == target){
				return true;
			}
		}
		if(twoSum > target && s.isEmpty())
			return false;
		
		if(twoSum < target){
			s.push(root);
			//return false;
		}
		
		res = findSumPair(s, root.right, target);
		return res;
	}
	
	public static void leftBranch(TreeNode root, Stack<TreeNode> s){
		if(root == null)
			return;
		leftBranch(root.left, s);
		s.push(root);
	}
	
	public static void main(String[] args){
		TreeNode root = new TreeNode(15);
		root.left = new TreeNode(10);
		root.left.left = new TreeNode(8);
		root.left.right = new TreeNode(12);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(16);
		root.right.right = new TreeNode(25);
		System.out.println(findSumPair(root, 45));
	}
}
