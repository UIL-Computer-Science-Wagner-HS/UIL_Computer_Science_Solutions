import java.io.File;
import java.io.IOException;
import java.util.*;
public class Noah {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("noah.dat"));
		int noSets = scan.nextInt();
		scan.nextLine();
		Map<String, Integer> make = new TreeMap();
		Map<String, Integer> model = new TreeMap();
		Map<String, Integer> year = new TreeMap();
		List<Car> list = new ArrayList<Car>();
		while (noSets-- > 0) {
			String[] arr = scan.nextLine().split("[, ]+");
			Car drive = new Car(arr[0], arr[1], arr[2]);
			list.add(drive);
			make.computeIfPresent(arr[0], (key, val) -> val + 1);
			make.putIfAbsent(arr[0], 1);
			model.computeIfPresent(arr[1], (key, val) -> val + 1);
			model.putIfAbsent(arr[1], 1);
			year.computeIfPresent(arr[2], (key, val) -> val + 1);
			year.putIfAbsent(arr[2], 1);
		}
		Comparator<Car> cmpmk = (a, b) -> a.mk.compareTo(b.mk);
		Comparator<Car> cmpmd = (a, b) -> a.mdl.compareTo(b.mdl);
		Comparator<Car> cmpyr = (a, b) -> a.yr.compareTo(b.yr);
		list.sort(cmpmk.thenComparing(cmpmd).thenComparing(cmpyr));
		for (Car c : list) {
			System.out.println(c.getMake() + " " + c.getModel() + " " + c.getYear());
		}
		System.out.println("---Make Breakdown---");
		make.forEach((k, y) -> System.out.println(k + ": " + y));
		System.out.println("---Model Breakdown---");
		model.forEach((k, y) -> System.out.println(k + ": " + y));
		System.out.println("---Year Breakdown---");
		year.forEach((k, y) -> System.out.println(k + ": " + y));
	}
}

class Car {
	String mk;
	String mdl;
	String yr;

	public Car(String make, String model, String year) {
		mk = make;
		mdl = model;
		yr = year;
	}

	public String getMake() {
		return mk;
	}

	public String getModel() {
		return mdl;
	}

	public String getYear() {
		return yr;
	}
	/*
	 * public Car(String make, String model, String year) { super(); this.make =
	 * make; this.model = model; this.year = year; }
	 */

}
