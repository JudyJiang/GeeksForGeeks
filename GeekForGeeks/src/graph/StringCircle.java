package graph;

public class StringCircle {
	private static int ALPHABET_SIZE = 26;
	
	public static boolean IsEulerianCycle(Graph g){
		if(!IsSC(g))
			return false;
		
		return true;
	}
	
	
	public static boolean IsSC(Graph g){
		return true;
	}
	
	public static boolean IsEulerianCycle(String[] list){
		Graph g = new Graph(ALPHABET_SIZE);
		
		for(int i = 0; i < list.length; i++){
			int v = list[i].charAt(0) - 'a';
			int w = list[i].charAt(list[i].length() - 1) - 'a';
			g.adjcentNodes[v].add(w);
		}
		
		return IsEulerianCycle(g);
	}
}
