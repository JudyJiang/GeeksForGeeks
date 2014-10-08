package tree;

/**
 * http://www.geeksforgeeks.org/given-a-binary-tree-print-out-all-of-its-root-to
 * -leaf-paths-one-per-line/
 * Need some attention;
 * @author FengjiaoJiang
 * 
 */
public class EachRootLeafPath {
	public static void FindPath(BinaryTree root) {
		if (root == null)
			return;

		BinaryTree[] path = new BinaryTree[GetTreeLength(root) + 1];
		FindPath(root, path, 0);
	}

	public static void FindPath(BinaryTree root, BinaryTree[] path, int level) {
		if(root == null)
			return ;
		
		path[level] = root;
		level++;
		
		if (root.left == null && root.right == null) {
			PrintList(path);
			return;
		}

		FindPath(root.left, path, level);
		for(int i = level + 1; i < path.length; i++)
			path[i] = null;//This step is really, really important!
		FindPath(root.right, path, level);
	}

	public static void PrintList(BinaryTree[] path) {
		for (int i = 0; i < path.length; i++)
			if (path[i] != null)
				System.out.print(path[i].rootElement + " ");
		System.out.println();
	}

	public static int GetTreeLength(BinaryTree root) {
		if (root == null)
			return 0;

		return Math.max(GetTreeLength(root.left), GetTreeLength(root.right)) + 1;
	}

	public static void main(String[] args) {
		BinaryTree root = GetTreeSize.GetSimpleTree();
		FindPath(root);
	}
}
