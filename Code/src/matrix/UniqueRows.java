package matrix;


/**
 * Method 1. Can scan the whole array O(N^2)
 * Method 2. Construct the digit value (binary representation)
 * Method 3. Use the Trier Node. Like this.
 * @author FengjiaoJiang
 *
 */
public class UniqueRows {
	public static class BinaryNode {
		boolean isLeaf;
		BinaryNode[] subs ;//= new BinaryNode[2];
		
		public BinaryNode(){
			this.subs = new BinaryNode[2];
		}
	}
	
	
	BinaryNode root;
	
	public boolean insert(int[][] rows, int row, int col){
		int index = 0;
		if(this.root == null){
			this.root = new BinaryNode();
		}
		
		BinaryNode p = root;
		while(index < col){
			if(p.subs[rows[row][index]] == null)
				p.subs[rows[row][index]] = new BinaryNode();
			p = p.subs[rows[row][index]];
			index += 1;
		}
		
		
		if(p.isLeaf)
			return false;
		else{
			p.isLeaf = true;
			return true;
		}
	}
	
	public void findUniqueRows(int[][] mat){
		int m = mat.length, n = mat[0].length;
		for(int i = 0; i < m; i++){
			if(insert(mat, i, n)){
				for(int j = 0; j < n; j++){
					System.out.print(mat[i][j] + " ");
				}
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args){
		int[][] mat = {
				{0, 1, 0, 0, 1},
				{1, 0, 1, 1, 0},
				{0, 1, 0, 0, 1},
				{1, 1, 1, 0, 0}
		};
		
		UniqueRows sol = new UniqueRows();
		sol.findUniqueRows(mat);
	}
}
