import java.util.*;
import java.io.*;

public class Index {

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("index.dat"));
		TreeSet<String> wordSet = new TreeSet<String>();
		while (scan.hasNext()) {
			wordSet.add(scan.next().replaceAll("[_0-9\\W]", "").toLowerCase());
		}
		scan.close();

		Iterator<String> it = wordSet.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}

	}

}
