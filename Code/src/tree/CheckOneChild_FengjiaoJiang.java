package tree;


import utility.TreeNode;

public class CheckOneChild_FengjiaoJiang {
	public static boolean onlyOneChild(int[] pre){
		if(pre == null || pre.length == 0)
			return true;
		
		for(int i = 0; i < pre.length - 1; i++){
			int curr = pre[i];
			int first = pre[i+1];
			int last = pre[pre.length - 1];
			if(!((curr < first && curr < last) || 
					(curr > first && curr > last)))
					return false;
		}
		return true;
	}
	
	public static void main(String[] args){
		int[] prev = {20, 10, 11, 13, 12, 19};//{20, 10, 11, 13, 12};
		System.out.println(onlyOneChild(prev));
	}
}
