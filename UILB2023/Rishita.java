import java.util.*;
import java.io.*;

public class Rishita {

	String code;
	String course;

	public Rishita(String code, String course) {
		super();

		this.code = code;
		this.course = course;
	}

	public static void main(String... args) throws IOException {

		Scanner scan = new Scanner(new File("rishita.dat"));
		// int noSets = scan.nextInt();
		// scan.nextLine();
		List<Rishita> list = new ArrayList<>();
		Map<String, List<Rishita>> map = new TreeMap<>();
		while (scan.hasNextLine()) {
			String[] arr = scan.nextLine().split(",");
			map.putIfAbsent(arr[2], new ArrayList<Rishita>());
			map.get(arr[2]).add(new Rishita(arr[1], arr[0]));

		}

		Comparator<Rishita> comp2 = (a, b) -> a.code.compareTo(b.code);
		for (Map.Entry<String, List<Rishita>> ent : map.entrySet()) {
			System.out.println(ent.getKey());

			List<Rishita> l = ent.getValue();
			l.sort(comp2);
			l.forEach(a -> System.out.println("   " + a.code + "   " + a.course));

		}

	}
}
