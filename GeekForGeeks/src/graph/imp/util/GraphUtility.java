package graph.imp.util;

import graph.imp.*;
import java.util.Set;
//import java.util.Iterator;
//import java.util.HashMap;

public class GraphUtility {
	public static void PrintGraph(Graph g) throws Exception{
		Set<String> keys = g.nodesList.keySet();
		for(String key : keys){
			GraphNode node = g.GetNode(key);
			System.out.println("Current Node: " + key);
			for(Edge e : node.getEdges()){
				System.out.println("Connect to Node: " + e.next.name + " Edge Weight is: " + e.GetWeight());
			}
		}
	}
}
