import java.util.*;
import java.io.*;

/**
 * @author Ian Fernandes
 *
 */
public class text_search {
	
	static HashMap<Integer, List<Integer>> locations = new LinkedHashMap<>();
	
	public static void findInstances(String sentence, String target, int begIndex, int lineNum) {
		int index = sentence.indexOf(target);
		if(index==-1)
			return;
		if(!locations.containsKey(lineNum))
			locations.put(lineNum, new ArrayList<>());

		List<Integer> currList = locations.get(lineNum);
		currList.add(begIndex+index+1); // 1-based indexing when displaying
		locations.put(lineNum, currList);
		
		findInstances(sentence.substring(index+1), target, index+1, lineNum);
	}
	
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("text_search.dat"));
		String target = scan.nextLine().toLowerCase();
		int lineNum = 1;
		while(scan.hasNextLine())
			findInstances(scan.nextLine().toLowerCase(), target, 0, lineNum++);
		for(Map.Entry<Integer, List<Integer>> entry: locations.entrySet())
			entry.getValue().forEach(index -> System.out.printf("line %d character %d%n", entry.getKey(), index));
	}
}
