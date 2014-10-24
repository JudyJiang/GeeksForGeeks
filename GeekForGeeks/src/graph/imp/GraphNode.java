package graph.imp;

import java.util.List;
import java.util.ArrayList;

public class GraphNode {
	public String name;
	private List<GraphNode> neighbours;
	private List<Edge> adjacentEdges;
	
	public GraphNode(){
		super();
		this.neighbours = new ArrayList<GraphNode>();
		this.adjacentEdges = new ArrayList<Edge>();
	}
	
	public GraphNode(String s){
		this();
		this.name = s;
	}
	
	public void AddNeighbours(GraphNode node){
		this.neighbours.add(node);
	}
	
	public void AddEdge(Edge e){
		this.adjacentEdges.add(e);
	}
	
	public List<Edge> getEdges(){
		return this.adjacentEdges;
	}
}
