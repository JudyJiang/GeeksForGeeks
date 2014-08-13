package graph;

import java.util.List;
import java.util.ArrayList;
/**
 * This algorithm is to check if every node is strongly connected 
 * Using DFS (& graph transpose), the idea is:
 * if v can reach every node
 * by transposing, we check if v is reachable from each node.
 * @author FengjiaoJiang
 *
 */
public class GraphEulerianCircle {

	public static void DFSGraph(int v, boolean[] visited, List<Integer>[] nodes){
		visited[v] = true;
		
		for(int i = 0; i < nodes[v].size(); i++){
			if(!visited[nodes[v].get(i)])
				DFSGraph(nodes[v].get(i), visited, nodes);
		}		
	}
	
	public static void DFSGraphI(int v, boolean[] visited, List<Integer>[] nodes){
		if(visited[v])
			return;
		
		visited[v] = true;
		for(int i = 0; i < nodes[v].size(); i++){
			DFSGraphI(nodes[v].get(i), visited, nodes);
		}
	}
	
	
	public static Graph GetGraphTranspose(Graph g){
		Graph graph = new Graph(g.vertices);

		for(int i = 0; i < g.vertices; i++){
			if(g.adjcentNodes[i].size() != 0){
				for(int j = 0; j < g.adjcentNodes[i].size(); j++){
					graph.AddEdge(g.adjcentNodes[i].get(j), i);
					graph.edges++;
				}
			}
		}
		return graph;
	}
	
	public static boolean IsEulerianCircle(Graph g){
		boolean[] visited = new boolean[g.vertices];
		for(int i = 0; i < visited.length; i++){
			visited[i] = false;
		}
		
		/*Find the first node who has adjacent node*/
		int startNode = 0;
		for(int i = 0; i < g.vertices; i++){
			if(g.adjcentNodes[i].size() != 0){
				startNode = i;
			}
		}
		
		DFSGraphI(startNode, visited, g.adjcentNodes);
		
		for(int i = 0; i < visited.length; i++){
			if(g.adjcentNodes[i].size() > 0 && !visited[i]){
				return false;
			}
		}
		
		
		Graph graph = GetGraphTranspose(g);
		for(int i = 0; i < visited.length; i++){
			visited[i] = false;
		}
		
		DFSGraphI(startNode, visited, graph.adjcentNodes);
		
		for(int i = 0; i < graph.vertices; i++){
			if(graph.adjcentNodes[i].size() > 0 && !visited[i])
				return false;
		}
		
		return true;
	}
	
	public static void main(String[] args){
		Graph g = new Graph(5);
		g.AddEdge(1, 0);
		g.AddEdge(0, 2);
		g.AddEdge(2, 1);
		g.AddEdge(0, 3);
		g.AddEdge(3, 4);
		g.AddEdge(4, 0);
		
	//	g.PrintGraph();
		if(IsEulerianCircle(g))
			System.out.println("Is a Circle");
		else
			System.out.println("Not a Circle");
	}
}
