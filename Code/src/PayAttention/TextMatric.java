package PayAttention;
import java.util.*;

public class TextMatric {
	public static void findGuard(char[][] mat){
		int M = mat.length, N = mat[0].length;
		for(int i = 0; i < M; i++){
			for(int j = 0; j < N; j++){
				if(mat[i][j] == 'G'){
					dfs(mat, i, j);
				}
			}
		}
	}
	
	public static void dfs(char[][] mat, int x, int y){
		int M = mat.length, N = mat[0].length;
		LinkedList<Integer> q = new LinkedList<Integer>();
		q.add(x*M+y);
		int level = q.size();
		int len = 0;
		while(!q.isEmpty()){
			int top = q.removeFirst();
			int i_x = top / M, i_y = top % N;
			
			if(mat[i_x][i_y] == '.' || Integer.valueOf(mat[i_x][i_y]) < level){
				mat[i_x][i_y] = (char)(len + '0');
			}
			
			List<Integer> neis = getNeighbor(i_x, i_y, mat);
			for(Integer nei : neis){
				int nei_x = nei/M, nei_y = nei%N;
				if(isVisited(mat, nei_x, nei_y)){
					q.add(nei);
				}
			}
			level--;
			if(level == 0){
				len++;
				level = q.size();//use level to control every time q the size
				//count one time neighbours... 
			}
		}
	}
	
	public static boolean isVisited(char[][] mat, int x, int y){
		char c = mat[x][y];
		return c != '.';
	}
	
	public static List<Integer> getNeighbor(int i, int j, char[][] mat){
		int M = mat.length, N = mat[0].length;
		List<Integer> nei = new LinkedList<Integer>();
		if(i - 1 >= 0 && mat[i-1][j] != '#')
			nei.add((i-1)*N+j);
		if(i + 1 < M && mat[i+1][j] != '#')
			nei.add((i+1)*N+j);
		if(j - 1 >= 0 && mat[i][j-1] != '#')
			nei.add(i*N+j-1);
		if(j+1 < N && mat[i][j+1] != '#')
			nei.add(i*N+j+1);
		return nei;
	}
	
	public static void main(String[] args){
		int a = 1;
		System.out.println((char)(a + '0'));
	}
}
