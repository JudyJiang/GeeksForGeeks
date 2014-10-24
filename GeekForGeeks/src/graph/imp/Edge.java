package graph.imp;

public class Edge {
	public GraphNode previous;
	public GraphNode next;
	private int weight;
	
	public Edge(){
		super();
	}
	
	public Edge(int weight){
		this.weight = weight;
	}
	
	public Edge(GraphNode p, GraphNode n, int w){
		this.previous = p;
		this.next = n;
		this.weight = w;
	}
	
	public void AssignWeight(int w){
		this.weight = w;
	}
	
	public int GetWeight(){
		return this.weight;
	}
	
	public Edge(GraphNode p, GraphNode n){
		this(p, n, 0);
	}
	
	public void addEdge(GraphNode p, GraphNode n){
		this.previous = p;
		this.next = n;
	}
}
