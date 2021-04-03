import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Timothy {

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("timothy.dat"));
		Map<Integer, Integer> mappings = new TreeMap<>();
		while(scan.hasNextLine()) {
			String[] nextLine = scan.nextLine().split("\\s+");
			for(String num: nextLine) {
				int number = Integer.parseInt(num);
				if(mappings.containsKey(number)) {
					int currCount = mappings.get(number);
					mappings.put(number, currCount+1);
				} else {
					mappings.put(number, 1);
				}
			}
		}
		
		Set<Map.Entry<Integer, Integer>> entries = mappings.entrySet();
		ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<>(entries);
		Collections.reverse(list);
		for(Map.Entry<Integer, Integer> entry: list) {
			if(entry.getValue()>1) {
				System.out.println(entry.getKey()+" "+(entry.getValue()-1));
			} else {
				System.out.println(entry.getKey());
			}
		}

	}

}
