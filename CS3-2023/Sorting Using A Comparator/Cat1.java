import java.util.*;
import java.io.*;

public class Cat1 {
	String city;
	String state;
	int pop;
	
	public Cat1(String city, String state, int pop) {
		super();
		this.city = city;
		this.state = state;
		this.pop = pop;
	}

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("cat1.dat"));
		int noSets = scan.nextInt();
		scan.nextLine();
		List<Cat1> list = new ArrayList<>();
		while (noSets-- > 0) {
			String[] arr = scan.nextLine().split(",\\s*");
			//System.out.println(Arrays.toString(arr));
			list.add(new Cat1(arr[0], arr[1], Integer.parseInt(arr[2])));

		}
		Comparator<Cat1> comp1 = (a,b)->a.city.compareTo(b.city);
		Comparator<Cat1> comp2 = (a,b)->a.state.compareTo(b.state);
		Comparator<Cat1> comp3 = (a,b)->a.pop-b.pop;
		list.sort(comp1.thenComparing(comp2).thenComparing(comp3));
		System.out.println("-----sorted by city-----");
		list.forEach(a->System.out.println(a.city+" "+a.state+" "+ a.pop));
		System.out.println("-----State Pop-----");
		Map<String, Integer> map = new TreeMap<>();
		for(Cat1 obj: list) {
			map.putIfAbsent(obj.state, 0);
			map.put(obj.state, map.get(obj.state)+obj.pop);
			}
		map.entrySet().stream().forEach(a->System.out.println(a.getKey()+" "+ a.getValue()));
		
		
		
	}
}