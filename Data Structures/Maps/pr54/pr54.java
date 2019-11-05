import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class pr54 {

	public static void main(String[] args)throws IOException {
		Scanner scan = new Scanner(new File("pr54.dat"));
		int n = Integer.parseInt(scan.nextLine());
		HashMap<String, ArrayList<String>> map = new HashMap<>();
		while(n-->0) {
			String[] line = scan.nextLine().split(" ");
			ArrayList<String> currentList = map.get(line[0]);
			if(map.containsKey(line[0])) {
				currentList.add(line[1]);
				map.put(line[0],currentList);
			} else {
				map.put(line[0], new ArrayList<>(Arrays.asList(line[1])));
			}
		}
		
		Iterator<String> it = new TreeSet<String>(map.keySet()).iterator();
		while(it.hasNext()) {
			String teacher = it.next();
			ArrayList<String> teacherList = map.get(teacher);
			System.out.println(teacher);
			Collections.sort(teacherList);
			for(String a: teacherList)
				System.out.println("   "+a);
			System.out.println();
		}
		
		scan.close();

	}

}
