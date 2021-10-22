import java.util.*;
import java.io.*;

public class Descendents2 {
	//adj matrix
	static int[][] arr = new int[100][100];
	//id to name
	static Map<Integer, String> map = new HashMap();
	// name to id
	static Map<String, Integer> revMap = new HashMap();
	//input root and "" output print in proper format using DFS
	static void pr(int n, String str) {
		System.out.println(str+map.get(n));
		List<String> list = new ArrayList();
		for(int j = 0; j<100; j++)
			if(arr[n][j]==1)
				list.add(map.get(j));
		// has to be in order
		Collections.sort(list);
		for(String s: list)
			pr(revMap.get(s), str+"-");
		
		
	}
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("descendents.dat"));
		int noSets = scan.nextInt();
		map.put(1, "root");
		revMap.put("root", 1);
		Descendents obj = new Descendents();
		while (noSets-- > 0) {
			String word = scan.next();
			int id = scan.nextInt();
			int par = scan.nextInt();
			if (!map.containsKey(id)) {
				map.put(id, word);
				revMap.put(word, id);
			}
			arr[par][id] = 1;

		}
		pr(1,"");
		

	}
}
