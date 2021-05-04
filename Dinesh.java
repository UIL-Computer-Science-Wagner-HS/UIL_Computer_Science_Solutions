package connections;

import java.util.*;
import java.io.*;

public class Dinesh {
	
	
	static int findMin(boolean[] visited, int[] distance) {
		int min = Integer.MAX_VALUE;
		int index = -1;
		for(int i = 0; i<visited.length; i++) {
			if (!visited[i]&&distance[i]<min) {
				index = i;
				 min = distance[i]; 
			
			}
		}
		return index;
		
	}
	static int solve(List<String> list, int[][] adj, int left, int right ) {
		int[] distance = new int[adj.length];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[left]= 0;
		boolean[] visited = new boolean[adj.length];
		visited[left]= true;
		Stack<Integer> stack = new Stack();
		stack.push(left);
		while(stack.size()>0) {
			int check = stack.pop();
		for(int i = 0; i<adj.length; i++) 
			if(!visited[i]&&distance[i]>distance[check]+adj[check][i]&&adj[check][i]>0)
				distance[i]= distance[check]+adj[check][i];
			
		int n = findMin(visited,distance);
		if(n==-1)
			return distance[right];
		visited[n]=true;
		stack.push(n);
			
			
		}
			
		
		return distance[right];
		
		
	}
	
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("din.dat"));

		int noSets = scan.nextInt();
		while (noSets-- > 0) {
			scan.nextLine();
			String[] nodes = scan.nextLine().split(" ");
			List<String> list = Arrays.asList(nodes);

			int len = nodes.length;
			int[][] adj = new int[len][len];
			int noEd = scan.nextInt();
			while (noEd-- > 0) {
				int a = list.indexOf(scan.next());
				int b = list.indexOf(scan.next());
				int dis = scan.nextInt();
				adj[a][b] = dis;
				adj[b][a] = dis;

			}
			int ans = scan.nextInt();
			while (ans-->0) {
				String left = scan.next();
				String right = scan.next();
				
				int answer = solve(list,adj,list.indexOf(left), list.indexOf(right));
				System.out.println(left+" to "+right+": "+answer);
				
			}

		}

	}
}
