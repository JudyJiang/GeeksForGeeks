package tree;

public class FindTreePathII {
	/*
	 * FindRootNodePath Returns all the nodes values along the path
	 */
	public static String FindRootNodePath(BinaryTree root, BinaryTree node) {
		return FindRootNodePath(root, node, "");
	}

	public static String FindRootNodePath(BinaryTree root, BinaryTree node,
			String path) {
		if (root == null)
			return "";

		if (root.rootElement == node.rootElement) {
			System.out.println("Equals");
			if (!path.equals(""))
				path += " ";
			path += root.rootElement.toString();
			return path;
		}

		String left = FindRootNodePath(root.left, node, path);
		if (!left.equals("")) {
			left += " " + root.rootElement.toString();
			return left;
		}

		String right = FindRootNodePath(root.right, node, path);
		if (!right.equals("")) {
			right += " " + root.rootElement.toString();
			return right;
		}

		return "";
	}

	/*
	 * FindRootToNodePath Prints all the values (left, right, ..) along the path
	 * between two nodes
	 */
	public static void FindRootToNodePath(BinaryTree root, BinaryTree node) {
		FindRootToNodePath(root, node, "");
	}

	public static void FindRootToNodePath(BinaryTree root, BinaryTree node,
			String path) {
		if (root == null)
			return;

		if (root.rootElement == node.rootElement) {
			if (!path.equals(""))
				path += " ";
			path += root.rootElement.toString();
			System.out.println(path);
		}

		FindRootToNodePath(root.left, node, path.equals("") ? " " + path
				+ "left " : path + "left ");
		FindRootToNodePath(root.right, node, path.equals("") ? " " + path
				+ "right " : path + "right ");
	}

	/*
	 * FindRootToNodePathII Return path string (left, right...) Love this one.
	 * Pay attention to the recursion part.
	 */
	public static String FindRootToNodePathII(BinaryTree root, BinaryTree node) {
		return FindRootToNodePathII(root, node, "");
	}

	public static String FindRootToNodePathII(BinaryTree root, BinaryTree node,
			String path) {
		if (root == null)
			return "";

		if (root.rootElement == node.rootElement) {
			if (!path.equals(""))
				path += " ";
			path += root.rootElement.toString();
		//	System.out.println(path);
			return path;
		}

		String left = FindRootToNodePathII(root.left, node, path + " left ");
		String right = FindRootToNodePathII(root.right, node, path + " " + left
				+ " right ");

		return left + right ;
	}
	
	
	public static int NodeDistance(String s1, String s2){
		s1 = s1.replaceAll("\\s+", " ");
		s2 = s2.replaceAll("\\s+", " ");
		
		System.out.print(s1 + "\n" + s2);
		
		int size = s1.length() > s2.length() ? s1.length() : s2.length();
		
		for(int i = 0; i < size; i++){
			
		}
		return 0;
	}
	

	public static void main(String[] args) {
		BinaryTree root = TreeUtility.GetSampleTree();
		BinaryTree p = new BinaryTree(2);
		BinaryTree q = new BinaryTree(9);

		String s1 = FindRootToNodePathII(root, p);
		String s2 = FindRootToNodePathII(root, q);
		
		NodeDistance(s1, s2);
	}
}
