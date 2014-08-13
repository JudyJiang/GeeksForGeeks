package tree;

public class FindPredecessorSucessor {

	public static <T extends Comparable<T>> void FindPrecSuce(
			BinaryTree<Integer> root, BinaryTree<Integer> node,
			BinaryTree<Integer>[] holder) {
		if(root == null){
			return ;
		}
		
		if (root.rootElement == node.rootElement) {
			holder[0] = root;
			//holder[1] = root;
			FindPrecSuce(root.left, node, holder);
			FindPrecSuce(root.right, node, holder);
		}

		else if (root.rootElement > node.rootElement) {
			if (holder[1] == null || holder[1].rootElement > root.rootElement) {
				holder[1] = root;
			}
			FindPrecSuce(root.left, node, holder);
		}

		else {
			if (holder[0] == null || holder[0].rootElement < root.rootElement) {
				holder[0] = root;
			}
			FindPrecSuce(root.right, node, holder);
		}
	}

	public static void main(String[] args) {
		BinaryTree<Integer> root = TreeUtility.TreeFromArray(new Integer[] { 20,
				30, 40, 50, 60, 70, 80});
		
		BinaryTree node = new BinaryTree(49);
		BinaryTree[] holder = new BinaryTree[2];
		FindPrecSuce(root, node, holder);
		System.out.print(holder[0].rootElement + " " + holder[1].rootElement);
	}
}