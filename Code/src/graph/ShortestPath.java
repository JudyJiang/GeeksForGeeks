package graph;

import java.io.*;
import java.util.*;

public class ShortestPath {
	
	private int[][] graph;
	
	public ShortestPath(){
		this.graph = null;
	}
	
	public ShortestPath(int m, int n){
		this();
		this.graph = new int[m][m];
		for(int i = 0; i < m; i++)
			Arrays.fill(this.graph[0], -1);
	}
	
	public void updateRow(int m, int n){
		this.graph[m-1][n-1] = 6;
	}
	
	public void findPath(int start){
		for(int i = 0; i < this.graph.length; i++){
			for(int j = 0; j < this.graph[0].length; j++)
				System.out.print(this.graph[i][j] + " ");
			System.out.println();
		}
		int[] dist = new int[this.graph.length];
		boolean[] visited = new boolean[this.graph.length];
		Arrays.fill(dist, 0);
		int size = this.graph.length;
		Queue<Integer> q = new PriorityQueue<Integer>();
		q.add(start);
		visited[start] = true;
		while(!q.isEmpty()){
			int top = q.poll();
			for(int j = 0; j < size; j++){
				if(!visited[j] && this.graph[top][j] != -1){
					if(dist[j] < dist[top] + this.graph[top][j])
						dist[j] = dist[top] + this.graph[top][j];
					q.add(j);
				}
			}
			visited[top] = true;
		}
		for(int i = 0; i < dist.length; i++)
			System.out.print(dist[i] + " ");
	}
	
	public static void readTest(String filePath){
		BufferedReader br = null;
		ShortestPath graph = new ShortestPath();
		try{
			String currentLine;
			br = new BufferedReader(new FileReader(filePath));
			currentLine = br.readLine();//read number of test cases
			boolean start = true;
			while((currentLine = br.readLine()) != null){
				if(start){
					//System.out.println(currentLine);
					String[] nums = currentLine.split("\\s+");
					graph = new ShortestPath(Integer.valueOf(nums[0]), Integer.valueOf(nums[1]));
					start = false;
				}
				else{
					//System.out.println(currentLine);
					String[] lines = currentLine.split("\\s+");
					if(lines.length == 1){
						start = true;
						graph.findPath(Integer.valueOf(lines[0]));
					}
					else
						graph.updateRow(Integer.valueOf(lines[0]), Integer.valueOf(lines[1]));
				}
			}
		}catch (IOException e){
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		System.out.println("here");
		if(args.length < 1){
			System.out.println("Need File Path\n");
			System.exit(1);
		}
		
		String filePath = args[0];
		readTest(filePath);
	}
}
