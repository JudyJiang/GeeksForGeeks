import java.util.*;

public class CourseSchedule {
	//DFS solution
	public static boolean canFinish(int numCourses, int[][] prerequisites){
		if(prerequisites == null || prerequisites.length == 0)
			return true;
		
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
		for(int[] pair : prerequisites){
			if(!map.containsKey(pair[1])){
				ArrayList<Integer> l = new ArrayList<Integer>();
				l.add(pair[0]);
				map.put(pair[1], l);
			}
			else{
				map.get(pair[1]).add(pair[0]);
			}
		}
		
		int[] visited = new int[numCourses];
		for(int i = 0; i < numCourses; i++){
			if(!canFinishDFS(map, i, visited))
				return false;
		}
		
		return true;
	}
	
	public static boolean canFinishDFS(HashMap<Integer, ArrayList<Integer>> map, int start, int[] visited){
		//added visited, mark every 'visiting' node as -1 to detect circle
		if(visited[start] == -1)
			return false;
		
		if(visited[start] == 1)
			return true; // this is to avoid further traverse if one node can already be finished (detected earlier)
		//if 4->3->2 and 3 doesn't have prerequisite, then 3 is 1, 4 doesn't to go through 3 again.
		visited[start] = -1; //if meet it again (circle node)
		if(map.containsKey(start)){
			for(int i : map.get(start))
				if(!canFinishDFS(map, i, visited))
					return false;
		}
		visited[start] = 1; //this node (route) is clean
		
		return true;
	}
	
	
	//BFS solution.
	/*This starts with course without any prerequisite(there must be one, otherwise all depended on 
	 * each other, return false*/
	public static boolean canFinishBFS(int courses, int[][] pres){
		if(pres == null || pres.length == 0)
			return true;
		
		int len = pres.length;
		int[] pCounter = new int[courses];
		for(int i = 0; i < len; i++){
			pCounter[pres[i][0]]++; //count dependencies
		}
		
		LinkedList<Integer> queue = new LinkedList<Integer>();
		for(int i = 0; i < courses; i++)
			if(pCounter[i] == 0)
				queue.add(i);
		
		int numPre = queue.size();
		
		while(!queue.isEmpty()){
			int top = queue.remove();
			for(int i = 0; i < len; i++){
				if(pCounter[pres[i][1]] == top){
					pCounter[pres[i][0]]--;
					if(pCounter[pres[i][0]] == 0){
						numPre++;
						queue.add(pres[i][0]);
					}
				}
			}
		}
		return numPre == courses;
	}
	
	public static void main(String[] args){
		int[][] prerequisites = {{0, 1}, {1, 0}};
	}
}
