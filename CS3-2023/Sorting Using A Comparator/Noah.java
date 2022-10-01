package cs3;

import java.io.*;
import java.util.*;

public class Noah {
	static List<Car> list = new ArrayList<>();

	public static void main(String... args) throws IOException {
		Scanner scan = new Scanner(new File("noah.dat"));
		int noSets = scan.nextInt();
		scan.nextLine();
		while (noSets-- > 0) {
			String[] arr = scan.nextLine().split(",");
			list.add(new Car(arr[0], arr[1], Integer.parseInt(arr[2])));
		}
		System.out.println("---Data Sorted---");
		Comparator<Car> comp1 = (a, b) -> a.make.compareTo(b.make);
		Comparator<Car> comp2 = (a, b) -> a.model.compareTo(b.model);
		Comparator<Car> comp3 = (a, b) -> a.year - b.year;
		list.sort(comp1.thenComparing(comp2).thenComparing(comp3));
		list.forEach(a -> System.out.println(a.make + " " + a.model + " " + a.year));
		System.out.println();
		System.out.println("---Make Breakdown---");
		Map<String, Integer> map = new TreeMap<>();
		list.forEach(a -> {
			map.putIfAbsent(a.make, 0);
			map.put(a.make, map.get(a.make) + 1);
		});
		map.entrySet().forEach(a->System.out.println(a.getKey()+" "+a.getValue()));
		System.out.println();
		System.out.println("---Model Breakdown---");
		map.clear();
		list.forEach(a -> {
			map.putIfAbsent(a.model, 0);
			map.put(a.model, map.get(a.model) + 1);
		});
		map.entrySet().forEach(a->System.out.println(a.getKey()+" "+a.getValue()));
		System.out.println();
		System.out.println("---Year Breakdown---");
		Map<Integer, Integer> map1 = new TreeMap<>();
		list.forEach(a -> {
			map1.putIfAbsent(a.year, 0);
			map1.put(a.year, map1.get(a.year) + 1);
		});
		map1.entrySet().forEach(a->System.out.println(a.getKey()+": "+a.getValue()));
		System.out.println();
	}

}

class Car {
	String make;
	String model;
	int year;

	public Car(String make, String model, int year) {
		super();
		this.make = make;
		this.model = model;
		this.year = year;
	}

}