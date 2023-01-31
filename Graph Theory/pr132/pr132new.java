import java.io.*;
import java.util.*;
/*data
 6
a b 1
a c 1
c d 1
b d 4
a d 5
c e 50
2
a d
b e
  
 */

public class pr132new {
	// this helper method searches dist for the lowest distance from the start which has not already been 
	//visited.  It returns -1 if it can't find anything better than Integer.MAX_VALUE
	static int findLowest(int[] dist, boolean[] visited) {
		int ans = -1;
		int min = Integer.MAX_VALUE;
		for(int i = 0; i<dist.length; i++) {
			if(min>dist[i]&&!visited[i]) {
				min = dist[i];
				ans = i;
			}
			
		}
		return ans;
	}
// this is the key method.  it returns an int[] with the minimum distances from start
	// we actually don't use goal here but we could to tighten up the code a bit.
	
	
	static int[] solve(int[][] adj, int start, int goal, int len) {
		// visited will track which vertices have been visited.
		boolean[] visited = new boolean[len];
		int[] dist = new int[len];// tracks the min distance so far from the start. 
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start]= 0;// start is 0 from start
		int index = 1;
		while(index!=-1) {
			// use the helper method to find index of vertex with the lowest distance from start
			// lowest of the remaining unvisited vertices
			index = findLowest(dist,visited);
			if(index==-1)// there are no more we can get to.  We are done
				return dist;
			visited[index]= true;// don't go to index again!
			for(int i = 0; i<len; i++) {// now reset distance for each unvisited vertex
				if(!visited[i]&&adj[index][i]!=0) {
					dist[i]= Math.min(dist[i], dist[index]+adj[index][i]);
				}
				
				
			}
			
			
			
		}
		return dist;
	}
		
		
		
	
	
public static void main(String... args) throws IOException {

	Scanner scan = new Scanner(new File("pr132.dat"));
	int noSets = scan.nextInt();
	scan.nextLine();
	// set up the adjacency matrix
	Map<String, Integer> map = new HashMap<>();
	int[][] adj = new int[10][10];
	int index = 0;
	while (noSets-- > 0) {
		String left = scan.next();
		String right = scan.next();
		int dis = scan.nextInt();
		if(!map.containsKey(left))
			map.put(left, index++);
		if(!map.containsKey(right))
			map.put(right, index++);
		adj[map.get(right)][map.get(left)]=dis;
		adj[map.get(left)][map.get(right)]=dis;
		//System.out.println(dis);
		
	}
	//print the adj matrix
	for(int[] row: adj)
		System.out.println(Arrays.toString(row));
	// bring in the start and goal
	noSets = scan.nextInt();
	while (noSets-- > 0) {
		String start = scan.next();
		String end = scan.next();
		//System.out.println(end);
		// solve returns an int[] with the min distances from the start.
		int[] ans = solve(adj,map.get(start), map.get(end), map.size());
		System.out.println(Arrays.toString(ans));
		System.out.println("answer is " +ans[map.get(end)]);
		
	}
	
	

}
}
