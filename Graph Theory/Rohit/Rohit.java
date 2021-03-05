import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Scanner;

/**
 * @author Ian Fernandes
 *
 */
public class Rohit {

	public static void main(String[] args) throws IOException{
		Scanner scan = new Scanner(new File("rohit.dat"));
		int noCases = Integer.parseInt(scan.nextLine());
		HashMap<Integer, ArrayList<Integer>> adjacencyList = new LinkedHashMap<>();
		
		while(noCases-->0) {
			int currentNum = 0;
			adjacencyList.clear();
			adjacencyList.put(currentNum++, null);
			
			String[] childrenPerLevel = scan.nextLine().split("\\s");
			for(String children: childrenPerLevel) {
				int numChildrenAtLevel = Integer.parseInt(children);
				LinkedHashSet<Integer> nodes = new LinkedHashSet<Integer>(adjacencyList.keySet());
				for(int node:nodes) {
					if(adjacencyList.get(node) != null)
						continue;
					for(int i = 0; i<numChildrenAtLevel; i++) {
						ArrayList<Integer> currentList;
						if(i==0)
							currentList = new ArrayList<>();
						else
							currentList = adjacencyList.get(node);
						currentList.add(currentNum);
						adjacencyList.put(node, currentList);
						adjacencyList.put(currentNum++, null);
					}
				}
			}
			
			int parent = Integer.parseInt(scan.nextLine());
			if(adjacencyList.containsKey(parent)) {
				ArrayList<Integer> children = adjacencyList.get(parent);
				if(children==null)
					System.out.print("NO CHILDREN");
				else
					children.forEach(x -> System.out.print(x+" "));
			} else
				System.out.print("NOT IN TREE");
			System.out.println();
		}
	}

}
