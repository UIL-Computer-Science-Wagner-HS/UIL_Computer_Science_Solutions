import java.io.*;
import java.util.*;
public class Spices {
	String name;
	int amt;
	int rating;
	String color;
	
public Spices(String name, int amt, int rating, String color) {
		super();
		this.name = name;
		this.amt = amt;
		this.rating = rating;
		this.color = color;
	}

public static void main(String... args) throws IOException {

	Scanner scan = new Scanner(new File("spices1.dat"));
	int noSets = scan.nextInt();
	scan.nextLine();
	StringBuilder colors = new StringBuilder("White, Red, Brown, Orange, Blue").reverse();
	String cos = "BLue Orange Brown Red White";
	List<Spices> list = new ArrayList<>();
	while (noSets-- > 0) {
		list.add(new Spices(scan.next(), scan.nextInt(), scan.nextInt(), scan.next()));
		

	}
	Comparator<Spices> comp1 = (a,b)-> cos.indexOf(b.color) - cos.indexOf(a.color);
	Comparator<Spices> comp2 = (a,b)-> b.amt - a.amt;
	Comparator<Spices> comp3 = (a,b)-> a.name.compareTo(b.name);
	Comparator<Spices> comp4 = (a,b)-> b.rating-a.rating;
	list.sort(comp4.thenComparing(comp1).thenComparing(comp2).thenComparing(comp3));
	list.forEach(a->System.out.println(a.name));

}
}
