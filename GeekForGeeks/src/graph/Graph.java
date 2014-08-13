package graph;

import java.util.List;
import java.util.ArrayList;


public class Graph {
	public int vertices;
	public int edges;
	public List<Integer>[] adjcentNodes;
	
	public Graph(){
		super();
	}
	
	public Graph(int v){
		this();
		this.vertices = v;
		this.adjcentNodes = new List[5];
		for(int i = 0; i < 5; i++)
			this.adjcentNodes[i] = new ArrayList<Integer>();
	}
	
	public void AddEdge(int v, int w){
		this.adjcentNodes[v].add(w);
		this.edges++;
	}
	
	public void PrintGraph(){
		for(int i = 0; i < this.adjcentNodes.length; i++){
			System.out.print("Vertica " + i + " ");
			for(int j = 0; j < this.adjcentNodes[i].size(); j++)
				System.out.print(this.adjcentNodes[i].get(j) + " ");
			System.out.println();
		}
	}
}
