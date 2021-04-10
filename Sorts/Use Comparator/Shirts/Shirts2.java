import java.util.*;
import java.io.*;

public class Shirts2 {

	String color;
	int id;
	String size;

	public Shirts2(String color, int id, String size) {
		super();
		this.color = color;
		this.id = id;
		this.size = size;
	}

	
	public static void main(String[] args) throws Throwable {
		Scanner scan = new Scanner(new File("shirts.dat"));
		
		
		String colors = "ROYGB";
		String size1 = "SML";

		int noSets = scan.nextInt();
		while (noSets-- > 0) {
			int noItems = scan.nextInt();
			List<Shirts2> list = new ArrayList();
			while (noItems-- > 0) {
				int ID = scan.nextInt();
				String color = scan.next();
				String size2 = scan.next();
				list.add(new Shirts2(color, ID, size2));
				Comparator<Shirts2> comp2 = (a,b)->(colors.indexOf(a.color)-colors.indexOf(b.color));
				list.sort(comp2.thenComparing((a,b)->size1.indexOf(a.size)-size1.indexOf(b.size))
						.thenComparing((a,b)->a.id-b.id));
			}
			list.forEach(a -> System.out.print(a.id + " "));
			System.out.println();

		}

	}
}
