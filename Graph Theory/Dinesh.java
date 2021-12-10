import java.io.*;
import java.util.*;

public class Dinesh {
	
	static int findMin(boolean[] visited, int[] dist, int[][] adj) {
		int n = -1;
		int min = Integer.MAX_VALUE;
		for(int i = 0; i<visited.length; i++)
			if(dist[i]<min&&visited[i]==false) {
				n = i;
				min = dist[i];
			}
		return n;
		
		
	}
	
	
	
	
	static int solve(int[][] adj, int start, int goal ) {
		int[] dist = new int[adj.length];
		boolean[] visited = new boolean[adj.length];
		for(int i = 0; i<dist.length; i++)
			dist[i]= Integer.MAX_VALUE;
		dist[start]= 0;
		int counter = dist.length;
		while(counter-->0) {
			
		int candidate = findMin(visited,dist,adj);
		if(candidate == -1)
			return dist[goal];
		visited[candidate]= true;
		for(int i = 0; i<visited.length; i++) {
			if(adj[candidate][i]!=0) {
				dist[i]=Math.min(dist[i], dist[candidate]+adj[candidate][i]);
				
				
			}
			
			
		}
		
		}
		return dist[goal];		
		
		
	}
	
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("dinesh.dat"));
		int noSets = scan.nextInt();
		while(noSets-->0) {
			scan.nextLine();
			String[] nodes = scan.nextLine().split("\\s+");
			Map<String, Integer> map = new HashMap<>();
			int index = 0;
			for(String s: nodes)
				map.put(s, index++);
			int[][] adj = new int[nodes.length][nodes.length];
			int edges = scan.nextInt();
			while(edges-->0) {
				String str1 = scan.next();
				String str2 = scan.next();
				int dis = scan.nextInt();
				adj[map.get(str1)][map.get(str2)]= dis;
				adj[map.get(str2)][map.get(str1)]= dis;
							
			}
			int answers = scan.nextInt();
			while(answers-->0) {
				String str1 =scan.next();
				String str2 =scan.next();
				int n = solve( adj,map.get(str1) ,map.get(str2));
				System.out.println(str1+" to "+str2+":"+ n);
			}
			
			
			
		}
		
	}

}
