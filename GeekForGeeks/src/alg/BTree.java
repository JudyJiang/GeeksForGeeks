package alg;

import java.util.*;

public class BTree<Key extends Comparable<? super Key>, Value> {
	private Node root;
	private final int M;
	private final int N;

	public BTree(int n) {
		this(n, n);
	}

	public BTree(int m, int n) {
		this.M = m;
		this.N = n;
		// root = new LNode();
	}

	public Value find(Key key) {
		Node node = root;
		while (node instanceof BTree.InnerNode) {
			InnerNode inNode = (InnerNode) node;
			int idx = inNode.getLoc(key);
			node = inNode.children[idx];
		}

		LeafNode leaf = (LeafNode) node;
		int idx = leaf.getLoc(key);
		if (idx < leaf.num && leaf.keys[idx].equals(key))
			return leaf.values[idx];
		return null;
	}

	public void dump() {

	}

	public void insert(Key key, Value value) {
		Split result = root.insert(key, value);
		if (result != null) {
			InnerNode _root = new InnerNode();
			_root.num = 1;
			_root.keys[0] = result.key;
			_root.children[0] = result.left;
			_root.children[1] = result.right;
			root = _root;
		}
	}

	class Split {
		public final Key key;
		public final Node left;
		public final Node right;

		public Split(Key k, Node l, Node r) {
			key = k;
			left = l;
			right = r;
		}
	}

	abstract class Node {
		protected int num; // number of keys, common property for both leaf and
							// inner nodes;
		protected Key[] keys;

		abstract public int getLoc(Key key);

		abstract public Split insert(Key key, Value value);
	}

	class LeafNode extends Node {
		final Value[] values = (Value[]) new Object[M];
		{
			keys = (Key[]) new Comparable[M];
		}

		@Override
		public int getLoc(Key key) {
			for (int i = 0; i < num; i++) {
				if (keys[i].compareTo(key) >= 0)
					return i;
			}
			return 0;
		}

		@Override
		public Split insert(Key key, Value value) {
			int i = getLoc(key);

			if (i == M) {// if it's full
				int mid = (M + 1) / 2;
				int siblingNum = this.num - mid;
				LeafNode sibling = new LeafNode();
				sibling.num = siblingNum;
				System.arraycopy(this.keys, mid, sibling.keys, 0, siblingNum);
				System.arraycopy(this.values, mid, sibling.values, 0,
						siblingNum);
				this.num = mid;

				if (i < mid) {
					this.insertNonFull(key, value, i);
				} else {
					sibling.insertNonFull(key, value, i - mid);
				}

				Split result = new Split(sibling.keys[0], this, sibling);
				return result;
			}

			else {
				this.insertNonFull(key, value, i);
				return null;
			}
		}

		public void insertNonFull(Key key, Value value, int index) {
			if (index < this.num && keys[index].equals(key))
				values[index] = value;
			else {
				System.arraycopy(keys, index, keys, index + 1, this.num - index);
				System.arraycopy(values, index, values, index + 1, this.num
						- index);
			}
			keys[index] = key;
			values[index] = value;
			num++;
		}

	}

	class InnerNode extends Node {
		final Node[] children = new BTree.Node[N + 1]; // inner nodes have N
														// Keys but N + 1
														// children....
		{
			keys = (Key[]) new Comparable[N];
		}

		@Override
		public int getLoc(Key key) {
			for (int i = 0; i < num; i++) {
				if (keys[i].compareTo(key) > 0)
					return i;
			}
			return 0;
		}

		@Override
		public Split insert(Key key, Value value) {
			if (this.num == N) {
				int mid = (N + 1) / 2;
				int siblingNum = this.num - mid;
				InnerNode sibling = new InnerNode();
				sibling.num = siblingNum;
				System.arraycopy(this.keys, mid, sibling.keys, 0, siblingNum);
				System.arraycopy(this.children, mid, sibling.children, 0,
						siblingNum);
				this.num = mid - 1;

				Split result = new Split(this.keys[mid - 1], this, sibling);
				if (key.compareTo(result.key) < 0)
					this.insertNonFull(key, value);
				else
					sibling.insertNonFull(key, value);
				return result;

			}

			else {
				this.insertNonFull(key, value);
				return null;
			}

		}

		public void insertNonFull(Key key, Value value) {
			int idx = this.getLoc(key);
			Split result = children[idx].insert(key, value);
			if (result != null) {
				// there's a split
				if (idx == this.num) { // current inner node is full
					keys[idx] = result.key;
					children[idx] = result.left;
					children[idx + 1] = result.right;
					num++;
				}

				else {
					System.arraycopy(key, idx, keys, idx + 1, this.num - idx);
					System.arraycopy(children, idx, children, idx + 1, this.num
							- idx + 1);
					children[idx] = result.left;
					children[idx + 1] = result.right;
					keys[idx] = result.key;
					num++;
				}
			}
			// else current node is not affected
		}
	}

	public static List<Integer> GrayCode(int n) {
		List<Integer> list = new ArrayList<Integer>();
		return GrayCode(n, list, n);
	}

	public static List<Integer> GrayCode(int n, List<Integer> res, int times) {
		if (n == 0) {
			res.add(0);
			return res;
		}

	    GrayCode(n - 1, res, times);
		for(Integer integer : res){
			int start = 1;
			int offset = 0;
			for(int i = 0; i < times; i++){
				offset = start << i;
				int tmp = offset | integer;
				System.out.print(tmp + " ");
			}
		}
		System.out.println();
		return null;
	}

	public static void main(String[] args) {
		List<Integer> res = GrayCode(3);
		//System.out.println(res.size());
//		for(Integer i : res){
//			System.out.println(i);
//		}
		
	}
}
