package graph.imp;

import graph.imp.util.GraphUtility;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class Graph {
	public int numberOfNodes;
	public int numberOfEdges;
	public HashMap<String, GraphNode> nodesList;
	
	/*
	 * Starts with en empty graph
	 */
	public Graph(){
		this.numberOfNodes = 0;
		this.numberOfEdges = 0;
		this.nodesList = new HashMap<String, GraphNode>();
	
	}
	
	public GraphNode FindNode(String s) throws Exception{
		if(numberOfNodes == 0 && nodesList == null)
			return null;
		
		if(nodesList.size() != this.numberOfNodes){
			System.out.println(this.nodesList.size() + " " + this.numberOfNodes);
			throw new Exception("Node List Not Syncrized");
		}
		
		if(nodesList.containsKey(s))
			return nodesList.get(s);
		
		return null;
	}
	
	public GraphNode GetNode(String name) throws Exception{
		return FindNode(name);
	}
	
	/**
	 * This is more likely to create the start node of the graph or an isolated node.
	 * @param node name
	 */
	public void AddNode(String name){
		GraphNode node = new GraphNode(name);
		AddNode(node);
	}
	
	public void AddNode(GraphNode node){
		this.numberOfNodes++;
		this.nodesList.put(node.name, node);
	}
	
	
	public void AddEdge(GraphNode ancestor, GraphNode newNode, Edge edge) throws Exception{
		if(FindNode(ancestor.name) == null){
			this.AddNode(ancestor);
		}
		
		if(FindNode(newNode.name) == null)
			this.AddNode(newNode);
		ancestor.AddNeighbours(newNode);
		ancestor.AddEdge(edge);
		edge.addEdge(ancestor, newNode);
		this.numberOfEdges++;
	}
	
	public static void main(String[] args) throws Exception{
		Graph g = new Graph();
		g.AddNode("A");
		g.AddNode("B");
		g.AddNode("C");
		g.AddNode("D");
		g.AddNode("E");
		//g.GetNode("A").a
		
		g.AddEdge(g.GetNode("A"), g.GetNode("C"), new Edge(12));
		g.AddEdge(g.GetNode("A"), g.GetNode("D"),  new Edge(60));
		g.AddEdge(g.GetNode("B"),  g.GetNode("A"),  new Edge(10));
		g.AddEdge(g.GetNode("C"),  g.GetNode("B"),  new Edge(20));
		g.AddEdge(g.GetNode("C"),  g.GetNode("D"),  new Edge(32));
		g.AddEdge(g.GetNode("E"),  g.GetNode("A"),  new Edge(7));
		
		GraphUtility.PrintGraph(g);
		
	}
}
