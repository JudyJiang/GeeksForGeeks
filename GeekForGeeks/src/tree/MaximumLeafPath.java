package tree;

/**I feel so proud of myself on this one!
 * Find Maximum Sum path within two leaves.
 * Doesn't have to through the root.
 * 
 * http://www.geeksforgeeks.org/find-maximum-path-sum-two-leaves-binary-tree/
 *                         -15
 *                        /   \
 *                       5     6
 *                      / \   / \
 *                    -8   1 3   9
 *                    / \         \
 *                   2   6         0
 *                                / \
 *                               4  -1
 *                                  /
 *                                 10
 * @author FengjiaoJiang
 *
 */

public class MaximumLeafPath {
	public static BinaryTree<Integer> ConstructSampleTree(){
		return null;
	}
	
	public static int MaximumSum(BinaryTree<Integer> root){
		int currentSum = 0, maximumSum = Integer.MIN_VALUE;
		int[] container = new int[2];
		return MaximumSum(root, container)[1]; //MaximumSum(root, currentSum, maximumSum);
	}
	
	//MaxLeft, MaxRight, root.value (check if added root.value is any larger)
	public static int[] MaximumSum(BinaryTree<Integer> root, int[] container){
		if(root == null){
			container = new int[2];
			return container;
		}
		
		int left = MaximumSum(root.left, container)[0];
		int right = MaximumSum(root.right, container)[0];
		
		int tempSum = (left > right? left : right) + root.rootElement;
		container[0] = tempSum;
		int tempMaxSum = left + right + root.rootElement;
		
		if(tempMaxSum > container[1])
			container[1] = tempMaxSum;
		
		return container;
	}
	
	public static BinaryTree<Integer> BuildSampleTree(){
		BinaryTree<Integer> root = new BinaryTree<Integer>(-15);
		root.left = new BinaryTree<Integer>(5);
		root.right = new BinaryTree<Integer>(6);

		root.left.left = new BinaryTree<Integer>(-8);
		root.left.right = new BinaryTree<Integer>(1);

		root.left.left.left = new BinaryTree<Integer>(2);
		root.left.left.right = new BinaryTree<Integer>(6);

		root.right.left = new BinaryTree<Integer>(3);
		root.right.right = new  BinaryTree<Integer>(9);

		root.right.right.right = new BinaryTree<Integer>(0);
		root.right.right.right.left = new BinaryTree<Integer>(4);
		root.right.right.right.right = new BinaryTree<Integer>(-1);

		root.right.right.right.right.left = new BinaryTree<Integer>(10);

		return root;
	}
	
	public static void main(String[] args){
		BinaryTree<Integer> root = BuildSampleTree();
		//TreeUtility.TraverseTreeLeverOrder(root);
		int sum = MaximumSum(root);
		System.out.print(sum);
	}
}
