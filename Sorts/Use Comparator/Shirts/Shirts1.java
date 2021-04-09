import java.util.*;
import java.io.*;

public class Shirts1 {

	String color;
	int id;
	String size;

	public Shirts1(String color, int id, String size) {
		super();
		this.color = color;
		this.id = id;
		this.size = size;
	}

	static Map<String, Integer> map = new HashMap();
	static Comparator<Shirts1> comp = (a, b) -> {
		if (!a.color.equals(b.color))
			return map.get(a.color) - map.get(b.color);
		if (!a.size.equals(b.size))
			return map.get(a.size) - map.get(b.size);
		return a.id - b.id;

	};

	public static void main(String[] args) throws Throwable {
		Scanner scan = new Scanner(new File("shirts.dat"));
		
		map.put("R", 0);
		map.put("O", 1);
		map.put("Y", 2);
		map.put("G", 3);
		map.put("B", 4);
		map.put("S", 5);
		map.put("M", 6);
		map.put("L", 7);

		int noSets = scan.nextInt();
		while (noSets-- > 0) {
			int noItems = scan.nextInt();
			List<Shirts1> list = new ArrayList();
			while (noItems-- > 0) {
				int ID = scan.nextInt();
				String color = scan.next();
				String size = scan.next();
				list.add(new Shirts1(color, ID, size));
				list.sort(comp);
			}
			list.forEach(a -> System.out.print(a.id + " "));
			System.out.println();

		}

	}
}
