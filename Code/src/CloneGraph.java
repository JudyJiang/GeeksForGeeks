import java.util.*;

public class CloneGraph {
	static class UndirectedGraphNode { 
		int label;
		ArrayList<UndirectedGraphNode> neighbors;
		UndirectedGraphNode(int x){
			this.label = x;
		}
	}
	
	
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node){
		if(node == null)
			return null;
		
		LinkedList<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
		q.add(node);
		HashMap<UndirectedGraphNode, UndirectedGraphNode> map = 
				new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
		map.put(node, new UndirectedGraphNode(node.label));
		
		while(!q.isEmpty()){
			UndirectedGraphNode top = q.pop();
			ArrayList<UndirectedGraphNode> currNeighbors = top.neighbors;
			for(UndirectedGraphNode nNode : currNeighbors){
				if(!map.containsKey(nNode)){
					UndirectedGraphNode nNodeCopy = new UndirectedGraphNode(nNode.label);
					map.put(nNode, nNodeCopy);
					q.add(nNode);
					map.get(top).neighbors.add(nNodeCopy);
				}
				else{
					map.get(top).neighbors.add(map.get(nNode));
				}
			}
		}
		return map.get(node);
	}
}
